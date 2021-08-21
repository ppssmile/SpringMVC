package ru.geekbrains.SpringMVS.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.SpringMVS.Domain.Product;
import ru.geekbrains.SpringMVS.Repository.ProductRepository;
import ru.geekbrains.SpringMVS.Service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.getProducts();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.getProduct(id);
    }

    @Override
    public boolean addProduct(Product product) {
        if (productRepository.getProducts().add(product)) return true;
        return false;
    }
}
