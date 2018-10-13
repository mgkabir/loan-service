package org.isearch.loan.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @GetMapping("/count")
    public Long getTotalCustomers(){
	return customerRepository.count();
    }

    @PostMapping("")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer aCustomer) {
	customerRepository.save(aCustomer);
	return new ResponseEntity<Customer>(aCustomer,HttpStatus.CREATED);
    }
}
