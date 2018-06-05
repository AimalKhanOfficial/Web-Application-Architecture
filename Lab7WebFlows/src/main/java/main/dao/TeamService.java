package main.dao;

import main.entities.Player;
import main.entities.Team;
import org.apache.el.stream.Optional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    private static ArrayList<Team> teamList;

    static {
        teamList = new ArrayList<>();

        Team team1 = new Team();
        team1.setTeamKey(1);
        team1.setName("Pakistan");
        team1.setCity("No City");
        team1.setMascot("Team Green");
        team1.setPlayers(new Player("Aimal", "Khan"));
        team1.setPlayers(new Player("Misbah", "ul Haq"));
        team1.setHomeUniform("Light Green");
        team1.setVisitUniform("Dark Green");

        Team team2 = new Team();
        team2.setTeamKey(2);
        team2.setName("Australia");
        team2.setCity("No City");
        team2.setMascot("Team Yellow");
        team2.setPlayers(new Player("Adam", "Gilchrist"));
        team2.setPlayers(new Player("Steve", "Smith"));
        team2.setHomeUniform("Light Yellow");
        team2.setVisitUniform("Dark Yellow");

        teamList.add(team1);
        teamList.add(team2);
    }

    public List<Team> getTeamList(){
        return teamList;
    }

    public void deleteTeam(String key){
        java.util.Optional<Team> team = this.getTeamList().stream().filter(a ->  a.getTeamKey() == Integer.parseInt(key)).findFirst();
        boolean check = this.getTeamList().remove(team.get());
    }

}
