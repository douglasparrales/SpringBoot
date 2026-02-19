package SpringBoot.controller;

import SpringBoot.domain.Product;
import SpringBoot.service.ProductService;
import SpringBoot.service.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    //injection of dependencies
    @Autowired
    private ProductService productsService;

    @GetMapping
    public ResponseEntity<?> getProducts(){
        List<Product> products = productsService.getProducts();
        return ResponseEntity.ok(products);
    }
}
