package main.entities;

import java.util.ArrayList;
import java.util.List;

public class Stadium {
    private int stadiumKey;
    private String name;
    private String city;
    private String state;

    public int getStadiumKey() {
        return stadiumKey;
    }

    public void setStadiumKey(int stadiumKey) {
        this.stadiumKey = stadiumKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(Match match) {
        this.matches.add(match);
    }

    private List<Match> matches;

    public Stadium(){
        matches = new ArrayList<>();
    }
}
