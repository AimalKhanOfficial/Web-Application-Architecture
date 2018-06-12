package bank.Templates;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountService;
import bank.service.IAccountService;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@ManagedBean(name = "accounts")
@SessionScoped
public class ListingAccounts implements Serializable {

    private static List<Account> accountServiceList;
    private double accHolderBalance;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    private String customerName;

    static {
        accountServiceList = (List<Account>) returnAccountLists();
        String x = "";
    }


    public double getAccHolderBalance() {
        return accHolderBalance;
    }

    public void setAccHolderBalance(double accHolderBalance) {
        this.accHolderBalance = accHolderBalance;
    }

    public List<Account> getAccountServiceList() {

        return accountServiceList;
    }

    public int createAccNumber() {
        Random rnd = new Random();
        return 100000 + rnd.nextInt(9999999);
    }

    public void createAccount() {
        accountServiceList.add(new AccountService().createAccount(createAccNumber(), this.customerName));
    }

    public void setAccountServiceList(List<Account> accountServiceList) {

        this.accountServiceList = accountServiceList;
    }

    public static Collection<Account> returnAccountLists() {
        IAccountService accountService = new AccountService();
        // create 2 accounts;
        accountService.createAccount(1263862, "Frank Brown");
        accountService.createAccount(4253892, "John Doe");
        // use account 1;
        accountService.deposit(1263862, 240);
        accountService.deposit(1263862, 529);
        accountService.withdrawEuros(1263862, 230);
        // use account 2;
        accountService.deposit(4253892, 12450);
        accountService.depositEuros(4253892, 200);
        accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
        // show balances
        return accountService.getAllAccounts();
    }

    public String showDetails(long accNo){
        return "accountDetails";
    }

    public double getBalance(List<AccountEntry> accountEntry) {
        for (AccountEntry entry : accountEntry) {
            accHolderBalance += entry.getAmount();
        }
        return accHolderBalance;
    }


}
