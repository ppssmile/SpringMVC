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

    @GetMapping(  "/result")
    public String getProducts(Model uiModel){
        List<Product> products= productService.findAll();
        uiModel.addAttribute("products", products);
        return "result";
    }

    @GetMapping( "/form")
    public String getForm(Model uiModel){
        uiModel.addAttribute("product", new Product());
        return "form";
    }

    @PostMapping(value = "/form")
    public String createProduct(@ModelAttribute Product product){
        productService.addProduct(product);
        return "redirect:/product/result";
    }
}
