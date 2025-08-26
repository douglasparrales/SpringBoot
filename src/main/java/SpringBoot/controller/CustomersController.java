package SpringBoot.controller;

import SpringBoot.domain.Customers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class Controller Customer
 */
@RestController
public class CustomersController {

    /**
     * Data Simulated
     */
    private List<Customers> customers = new ArrayList<>(Arrays.asList(
            new Customers(123,"goku","gokuultrainstrinto","sayayin"),
            new Customers(456,"vegeta","princeofsaayain","kakaroto"),
            new Customers(789,"bulma","bulmaCC","CC"),
            new Customers(234,"yayirobe","Maestroyayirobe","Mryayirobe")
    ));

    /**
     * Endpoint Customer
     * @return customers List<>
     */
    @GetMapping("/customers")
    public List<Customers> getCustomers(){
        return customers;
    }
}
