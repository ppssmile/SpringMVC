package ru.geekbrains.SpringMVS.Repository.Impl;

import org.springframework.stereotype.Repository;
import ru.geekbrains.SpringMVS.Domain.Product;
import ru.geekbrains.SpringMVS.Repository.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> products;

    @PostConstruct
    private void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "title", 20));
        products.add(new Product(2L, "title", 20));
        products.add(new Product(3L, "title", 20));
        products.add(new Product(4L, "title", 20));
        products.add(new Product(5L, "title", 20));
    }


    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        for (Product product : products) {
            if (product.getId()==id){
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }
}
