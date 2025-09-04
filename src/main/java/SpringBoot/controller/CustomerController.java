package SpringBoot.controller;

import SpringBoot.domain.Customer;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.ok(customers);
    }

    /**
     * GET BY USERNAME
     * @param username PARAM FOR FIND
     * @return USERNAME FROM CUSTOMERS
     */
    // @RequestMapping(value = ("/{username}"), method = RequestMethod.GET)
    @GetMapping("/{username}")
    public ResponseEntity<?> getCustomer(@PathVariable String username){
        for (Customer c : customers){
            if (c.getUsername().equalsIgnoreCase(username)){
                return ResponseEntity.status(HttpStatus.FOUND).body(c);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The customer has not been found with username: " + username);
    }

    /**
     * ENDPOINT POST CUSTOMER
     * @param customer customer
     * @return customer JSON
     */
    // @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<?> postCustomer(@RequestBody Customer customer){
        customers.add(customer);

        // URI CREATION
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(customer.getUsername())
                .toUri();

        // return ResponseEntity.created(location).build();
        return ResponseEntity.created(location).body(customer);
    }

    /**
     * ENDPOINT FOR MODIFY CUSTOMERS
     * @param customer CUSTOMER FOR MODIFY
     * @return CUSTOMER JSON
     */
    //@RequestMapping(method = RequestMethod.PUT)
    @PutMapping //MUST GENERATE CODE 204.
    public ResponseEntity<?> putCustomer(@RequestBody Customer customer){
        for (Customer c : customers){
            if (c.getId() == customer.getId()){
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * ENDPOINT FOR TO REMOVE CUSTOMERS
     * @param id CUSTOMER FOR TO REMOVE
     * @return CUSTOMER REMOVED.
     */
    //@RequestMapping(value = ("/{id}"), method = RequestMethod.DELETE)
    @DeleteMapping("/{id}") //MUST GENERATE CODE 204.
    public ResponseEntity<?> deleteCustomer(@PathVariable int id){
        for (Customer c : customers){
            if (c.getId() == id){
                customers.remove(c);
                System.out.println("Customer has been removed successfully!");

                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * ENDPOINT FOR MODIFY SPECIFIC PARAM FROM CUSTOMER
     * @param customer CUSTOMER WITH THE PARAM
     * @return CUSTOMER JSON
     */
    //@RequestMapping(method = RequestMethod.PATCH)
    @PatchMapping
    public ResponseEntity<?> patchCustomer(@RequestBody Customer customer){
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

                return ResponseEntity.status(HttpStatus.OK)
                        .body("The customer has been MODIFY with id: " + customer.getId());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The customer has not been FOUND with id: " + customer.getId());
    }
}
