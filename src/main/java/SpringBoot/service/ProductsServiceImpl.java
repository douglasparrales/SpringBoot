package SpringBoot.service;

import SpringBoot.domain.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Lazy
@Service
@ConditionalOnProperty(name = "service.products", havingValue = "list")
public class ProductsServiceImpl implements ProductService {

    public ProductsServiceImpl(){
        System.out.println("Instance of class ProductsServiceImpl");
    }

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "laptop", 799.99, 5),
            new Product(2, "cellphone", 499.99, 12),
            new Product(3, "smartwatch", 299.99, 10),
            new Product(4, "VR Glasses", 1299.99,3)
    ));

    @Override
    public List<Product> getProducts() {
        return products;
    }
}
