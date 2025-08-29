package SpringBoot.controller;

import SpringBoot.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class Controller Customer
 */
@RestController
public class CustomerController {

    /**
     * Data Simulated
     */
    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123,"goku","gokuultrainstrinto","sayayin"),
            new Customer(456,"vegeta","princeofsaayain","kakaroto"),
            new Customer(789,"bulma","bulmaCC","CC"),
            new Customer(234,"yayirobe","Maestroyayirobe","Mryayirobe")
    ));

    /**
     * Endpoint Customer
     * @return customers List<>
     */
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customers;
    }

    /**
     * GET BY USERNAME
     * @param username PARAM FOR FIND
     * @return USERNAME FROM CUSTOMERS
     */
    @GetMapping("/customers/{username}")
    public Customer getCustomer(@PathVariable String username){
        for (Customer c : customers){
            if (c.getUsername().equalsIgnoreCase(username)){
                return c;
            }
        }
        return null;//bad practice
    }

    /**
     * ENDPOINT POST CUSTOMER
     * @param customer customer
     * @return customer JSON
     */
    @PostMapping("/customers")
    public Customer postCustomer(@RequestBody Customer customer){
        customers.add(customer);
        return customer;
    }

    /**
     * ENDPOINT FOR MODIFY CUSTOMERS
     * @param customer CUSTOMER FOR MODIFY
     * @return CUSTOMER JSON
     */
    @PutMapping("/customers")
    public Customer putCustomer(@RequestBody Customer customer){
        for (Customer c : customers){
            if (c.getId() == customer.getId()){
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());
                return c;
            }
        }
        return null;//bad practice
    }
}
