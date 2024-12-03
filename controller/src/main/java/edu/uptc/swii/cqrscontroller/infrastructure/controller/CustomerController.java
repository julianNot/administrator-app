package edu.uptc.swii.cqrscontroller.infrastructure.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import edu.uptc.swii.cqrscontroller.model.Customer;
import edu.uptc.swii.cqrscontroller.application.service.*;



@RestController
public class CustomerController {
    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/addcustomer")
    public String sendMessageAddCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return customer.toString();
    }


    @PostMapping("/updatecustomer")
    public String sendMessageUpdateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return customer.toString();
    }


    @PostMapping("/delcustomer")
    public String sendMessageDeleteCustomer(@RequestBody Customer customer) {
        return customerService.deleteCustomer(customer);
    }
}
