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
@RequestMapping("/customers")
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
    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Customer> getCustomers(){
        return customers;
    }

    /**
     * GET BY USERNAME
     * @param username PARAM FOR FIND
     * @return USERNAME FROM CUSTOMERS
     */
    // @RequestMapping(value = ("/{username}"), method = RequestMethod.GET)
    @GetMapping("/{username}")
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
    // @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public Customer postCustomer(@RequestBody Customer customer){
        customers.add(customer);
        return customer;
    }

    /**
     * ENDPOINT FOR MODIFY CUSTOMERS
     * @param customer CUSTOMER FOR MODIFY
     * @return CUSTOMER JSON
     */
    //@RequestMapping(method = RequestMethod.PUT)
    @PutMapping
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

    /**
     * ENDPOINT FOR TO REMOVE CUSTOMERS
     * @param id CUSTOMER FOR TO REMOVE
     * @return CUSTOMER REMOVED.
     */
    //@RequestMapping(value = ("/{id}"), method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public Customer deleteCustomer(@PathVariable int id){
        for (Customer c : customers){
            if (c.getId() == id){
                customers.remove(c);
                System.out.println("Customer has been removed successfully!");

                return c;
            }
        }
        return null; //bad practice
    }

    /**
     * ENDPOINT FOR MODIFY SPECIFIC PARAM FROM CUSTOMER
     * @param customer CUSTOMER WITH THE PARAM
     * @return CUSTOMER JSON
     */
    //@RequestMapping(method = RequestMethod.PATCH)
    @PatchMapping
    public Customer patchCustomer(@RequestBody Customer customer){
        for (Customer c : customers){
            if (c.getId() == customer.getId()){
                if (customer.getName() != null){
                    c.setName(customer.getName());
                }
                if (customer.getUsername() != null){
                    c.setUsername(customer.getUsername());
                }
                if (customer.getPassword() != null){
                    c.setPassword(customer.getPassword());
                }

                return c;
            }
        }
        return null;
    }
}
