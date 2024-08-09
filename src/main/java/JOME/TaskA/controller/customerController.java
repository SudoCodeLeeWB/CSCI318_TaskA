package JOME.TaskA.controller;

import JOME.TaskA.entity.Customer;
import JOME.TaskA.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class customerController {

    // for productRepository
    private final CustomerRepository customerRepository;


    public customerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // get the id of a product and return a "Product"
    @GetMapping("/customer/{id}")
    Customer getCustomerById(@PathVariable Long id){
        return customerRepository.findById(id).orElseThrow(RuntimeException::new);

    }

    @GetMapping("/customers")
    List<Customer> getAllCustomers(){
        return customerRepository.findAll();

    }

    @PostMapping("/customers")
    Customer createCustomer(@RequestBody Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

}
