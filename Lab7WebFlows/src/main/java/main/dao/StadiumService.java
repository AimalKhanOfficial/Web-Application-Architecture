package main.dao;

import main.entities.Stadium;
import main.entities.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StadiumService {

    private static ArrayList<Stadium> stadiumList;

    static {
        stadiumList = new ArrayList<>();
        Stadium stadium1 = new Stadium();
        stadium1.setStadiumKey(1);
        stadium1.setName("National Stadium");
        stadium1.setCity("Karachi");
        stadium1.setState("Sindh");

        Stadium stadium2 = new Stadium();
        stadium2.setStadiumKey(1);
        stadium2.setName("Gadafi Stadium");
        stadium2.setCity("Lahore");
        stadium2.setState("Punjab");

        stadiumList.add(stadium1);
        stadiumList.add(stadium2);
    }

    public List<Stadium> getStadiumList(){
        return stadiumList;
    }

    public void deleteStadium(String key){
        java.util.Optional<Stadium> stadium = this.getStadiumList().stream().filter(a ->  a.getStadiumKey() == Integer.parseInt(key)).findFirst();
        boolean check = this.getStadiumList().remove(stadium.get());
    }
}
