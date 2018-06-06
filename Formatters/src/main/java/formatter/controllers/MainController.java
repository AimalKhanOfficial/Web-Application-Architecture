package formatter.controllers;

import formatter.dao.CustomerDataService;
import formatter.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private CustomerDataService customerDataService;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("customerList", customerDataService.getAllUsers());
        return "index";
    }

    @GetMapping("/{customer}")
    public String particularCus(Customer customer, Model model){
        return "cust";
    }

}
