import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Random;

@Named("Person")
@SessionScoped
public class Person implements Serializable {

    public String getSomeOtherValue() {
        return new Random().nextInt(999999) + "";
    }

    public void setSomeOtherValue(String someOtherValue) {
        this.someOtherValue = someOtherValue;
    }

    private String someOtherValue;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public void execute(){
        this.name = new Random().nextInt() + "";
    }
}
