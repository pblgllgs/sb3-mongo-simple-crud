package com.pblgllgs.mongo.data;

import com.github.javafaker.Faker;
import com.pblgllgs.mongo.documents.Category;
import com.pblgllgs.mongo.documents.Product;
import com.pblgllgs.mongo.service.CategoryService;
import com.pblgllgs.mongo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author pblgl
 * Created on 08-11-2023
 */

@Component
@RequiredArgsConstructor
public class DataloaderProducts implements CommandLineRunner {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Override
    public void run(String... args) throws Exception {
        List<Product> products = productService.findAll();
        if (products.isEmpty()) {
            Faker faker = new Faker();
            for (int i = 0; i < 50; i++) {
                Category category = Category.builder()
                        .id(UUID.randomUUID().toString())
                        .name(faker.harryPotter().character())
                        .description(faker.lorem().sentence()).build();
                categoryService.save(category);
                Product product = Product.builder()
                        .name(faker.dragonBall().character())
                        .id(UUID.randomUUID().toString())
                        .description(faker.lorem().sentence())
                        .tags(
                                Arrays.asList(
                                        faker.color().hex(),
                                        faker.color().hex())
                        )
                        .build();
                productService.save(product);
            }
        }
    }
}
