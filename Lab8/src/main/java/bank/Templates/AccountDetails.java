package bank.Templates;

import bank.domain.AccountEntry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "accDetails")
@SessionScoped
public class AccountDetails{

    public String showDetails(String accNo){
        return "accountDetails";
    }

}
