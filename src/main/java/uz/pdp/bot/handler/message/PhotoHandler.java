package uz.pdp.bot.handler.message;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import uz.pdp.bot.BotConfig;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class PhotoHandler {
    @SneakyThrows
    public static void handle(final Message message, final TelegramLongPollingBot bot) {
        final List<PhotoSize> photo = message.getPhoto();
        final PhotoSize photoSize = photo.stream().max(Comparator.comparingInt(PhotoSize::getFileSize)).orElse(null);

        final GetFile getFile = new GetFile(photoSize.getFileId());
        final File file = bot.execute(getFile);
        save(file);
        bot.execute(SendMessage.builder().chatId(message.getChatId()).text("Photo saved successfully.").build());
    }

    private static void save(final File file) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(File.getFileUrl(BotConfig.BOT_TOKEN, file.getFilePath())))
                .GET()
                .build();
        HttpResponse<InputStream> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofInputStream());
        Path path = Path.of("src/main/resources/" + file.getFilePath());
        if (Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }
        Files.copy(response.body(), path, StandardCopyOption.COPY_ATTRIBUTES);

    }
}
