package main.controllers;

import main.dao.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StadiumController {

    @Autowired
    StadiumService stadiums;

    @GetMapping("/stadiums")
    public String getAllStadiums(Model model){
        model.addAttribute("stadiums", stadiums.getStadiumList());
        return "stadiums";
    }

    @GetMapping("/deleteStadium/{key}")
    public String deleteTeam(@PathVariable("key") String stadiumKey){
        stadiums.deleteStadium(stadiumKey);
        return "redirect:/stadiums";
    }
}
