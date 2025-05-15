package com.chat.productcatalog.config;


import com.chat.productcatalog.model.Category;
import com.chat.productcatalog.model.Product;
import com.chat.productcatalog.repository.CategoryRepository;
import com.chat.productcatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;

    public DataSeeder(ProductRepository productRepo, CategoryRepository categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        //Clear existing data
        productRepo.deleteAll();
        categoryRepo.deleteAll();

        // Create Categories
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        electronics.setName("Clothing");

        Category home = new Category();
        electronics.setName("Home and Kitchen");

          categoryRepo.save(electronics);
          categoryRepo.save(clothing);
          categoryRepo.save(home);
        // categoryRepo.saveAll(List.of(electronics, clothing, home));

        //create Products
        Product phone = new Product();
        phone.setName("Smart Phone");
        phone.setPrice(700.00);
        phone.setDescription("Latest Model: Smartphone With amazing features");
        phone.setCategory(electronics);
        phone.setImageUrl("https://placehold.co/600x400");

        Product watch = new Product();
        watch.setName("Apple Watch");
        watch.setPrice(200.00);
        watch.setDescription("Apple Watch with all the features");
        watch.setCategory(electronics);
        watch.setImageUrl("https://placehold.co/600x400");

        Product shirt = new Product();
        shirt.setName("Shirt");
        shirt.setPrice(100.00);
        shirt.setDescription("Shirt with all the features");
        shirt.setCategory(clothing);
        shirt.setImageUrl("https://placehold.co/600x400");

        Product book = new Product();
        book.setName("Book");
        book.setPrice(10.00);
        book.setDescription("Book with all the features");
        book.setCategory(home);
        book.setImageUrl("https://placehold.co/600x400");

        productRepo.saveAll(List.of(phone, watch, shirt, book));




    }

}
