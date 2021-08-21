package ru.geekbrains.SpringMVS.Repository;

import ru.geekbrains.SpringMVS.Domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> getProducts();

    Optional<Product> getProduct(Long id);

}
