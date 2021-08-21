package ru.geekbrains.SpringMVS.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.SpringMVS.Domain.Product;
import ru.geekbrains.SpringMVS.Service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(  "/products")
    @ResponseBody
    public String getProducts(Model uiModel){
        List<Product> products= productService.findAll();
        uiModel.addAttribute("products", products);
        return "products";
    }

    @GetMapping( "/form")
    @ResponseBody
    public String getForm(Model uiModel){
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "product";
    }

    @PostMapping("/form")
    public String createProduct(@RequestBody Product product){
        productService.addProduct(product);
        return "redirect:/product";
    }
}
