package formatter.dao;

import formatter.entities.Address;
import formatter.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerDataService {

    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("Aimal Khan");

        Address address = new Address();
        address.setCity("Fairfield");
        address.setCounty("Jefferson");
        address.setStreet("1000 N, 4th Streer");
        address.setZipCode("52557");

        customer.setAddress(address);
        customers.add(customer);
    }

    public List<Customer> getAllUsers() {
        return customers;
    }
}
