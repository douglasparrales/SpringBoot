package SpringBoot.service;

import SpringBoot.domain.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductService {

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
