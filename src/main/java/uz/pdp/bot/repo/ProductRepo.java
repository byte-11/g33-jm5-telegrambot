package uz.pdp.bot.repo;

import javassist.NotFoundException;
import uz.pdp.bot.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    public static final List<Product> PRODUCT_LIST = new ArrayList<>();

    static {
        PRODUCT_LIST.addAll(
                List.of(Product.builder().id(1).name("Milk").description("0.5%").price(13500F).build(),
                        Product.builder().id(2).name("Banana").description("Bananza").price(26000F).build())
        );
    }

    public static Product getById(long id) {
        return PRODUCT_LIST.stream()
                .filter(p -> p.getId() == id)
                .findFirst().orElseThrow(
                        () -> new IllegalStateException("Product not found with id - " + id)
                );
    }

}
