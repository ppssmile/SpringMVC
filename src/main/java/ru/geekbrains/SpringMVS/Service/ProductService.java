package ru.geekbrains.SpringMVS.Service;

import ru.geekbrains.SpringMVS.Domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById (Long id);

    boolean addProduct(Product product);

}
