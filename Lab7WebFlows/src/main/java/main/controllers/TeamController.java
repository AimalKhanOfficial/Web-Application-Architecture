package main.controllers;

import main.dao.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TeamController {

    @Autowired
    TeamService teams;

    @GetMapping("/teams")
    public String getAllTeams(Model model){
        model.addAttribute("teams", teams.getTeamList());
        return "teams";
    }

    @GetMapping("/deleteTeam/{key}")
    public String deleteTeam(@PathVariable("key") String teamKey){
        teams.deleteTeam(teamKey);
        return "redirect:/teams";
    }
}
