package uz.pdp.http_calls;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
//        www.pdp.uz/students/add-new
//        www.pdp.uz/students/update
//        www.pdp.uz/students/delete
//        www.pdp.uz/students/list

//        www.pdp.uz/mentors/add-new
//        www.pdp.uz/mentors/update
//        www.pdp.uz/mentors/delete
//        www.pdp.uz/mentors/list

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://cbu.uz/uz/arkhiv-kursov-valyut/json/"))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
//        System.out.println(body);
//        HttpResponse<InputStream> response = HttpClient.newHttpClient()
//                .send(request, HttpResponse.BodyHandlers.ofInputStream());
//        InputStream body = response.body();

        Gson gson = new GsonBuilder()
                .setDateFormat("dd.MM.yyyy")
                .create();
        String jsonObject = """
                {
                    "id": 38,
                    "Code": "398",
                    "Ccy": "KZT",
                    "CcyNm_RU": "\\u041a\\u0430\\u0437\\u0430\\u0445\\u0441\\u0442\\u0430\\u043d\\u0441\\u043a\\u0438\\u0439 \\u0442\\u0435\\u043d\\u0433\\u0435",
                    "CcyNm_UZ": "Qozog\\u2018iston tengesi",
                    "CcyNm_UZC": "\\u049a\\u043e\\u0437\\u043e\\u0493\\u0438\\u0441\\u0442\\u043e\\u043d \\u0442\\u0435\\u043d\\u0433\\u0435\\u0441\\u0438",
                    "CcyNm_EN": "Kazakhstan Tenge",
                    "Nominal": "1",
                    "Rate": "26.72",
                    "Diff": "0.2",
                    "Date": "22.11.2023"
                  }
                """;

        String jsonArray = """
                [
                     {
                       "id": 69,
                       "Code": "840",
                       "Ccy": "USD",
                       "CcyNm_RU": "\\u0414\\u043e\\u043b\\u043b\\u0430\\u0440 \\u0421\\u0428\\u0410",
                       "CcyNm_UZ": "AQSH dollari",
                       "CcyNm_UZC": "\\u0410\\u049a\\u0428 \\u0434\\u043e\\u043b\\u043b\\u0430\\u0440\\u0438",
                       "CcyNm_EN": "US Dollar",
                       "Nominal": "1",
                       "Rate": "12270.07",
                       "Diff": "-7.35",
                       "Date": "22.11.2023"
                     },
                     {
                       "id": 21,
                       "Code": "978",
                       "Ccy": "EUR",
                       "CcyNm_RU": "\\u0415\\u0432\\u0440\\u043e",
                       "CcyNm_UZ": "EVRO",
                       "CcyNm_UZC": "E\\u0412\\u0420\\u041e",
                       "CcyNm_EN": "Euro",
                       "Nominal": "1",
                       "Rate": "13428.36",
                       "Diff": "0.55",
                       "Date": "22.11.2023"
                     }
                ]
                """;

//        Currency currency = new uz.pdp.Currency();

//        Currency currency = gson.fromJson(jsonObject, Currency.class);
//        System.out.println(currency);

        Type type = TypeToken.getParameterized(List.class, Currency.class).getType();
        List<Currency> list = gson.fromJson(jsonArray, type);
        String json = gson.toJson(list);
        System.out.println(json);
        System.out.println(list);
    }
}