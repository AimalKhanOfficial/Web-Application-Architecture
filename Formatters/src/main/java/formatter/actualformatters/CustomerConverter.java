package formatter.actualformatters;

import formatter.dao.CustomerDataService;
import formatter.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import javax.validation.constraints.Max;
import java.util.List;
import java.util.Optional;

public class CustomerConverter implements Converter<String, Customer> {

    private CustomerDataService tradeService;

    public CustomerConverter (CustomerDataService tradeService) {
        this.tradeService = tradeService;
    }

    @Override
    public Customer convert(String aLong) {
        List<Customer> customers = tradeService.getAllUsers();

        for(Customer customer : customers){
            if(customer.getId().equalsIgnoreCase(aLong)){
                return customer;
            }
        }

        return null;
    }
}
