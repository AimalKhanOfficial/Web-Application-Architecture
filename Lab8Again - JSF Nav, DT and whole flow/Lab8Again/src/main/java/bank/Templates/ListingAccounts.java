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
import java.util.Optional;
import java.util.Random;

@ManagedBean(name = "accounts")
@SessionScoped
public class ListingAccounts implements Serializable {

    @Inject
    IAccountService service;

    private String depositAmt;
    private String depositAmtAccNum;

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

    public String createAccount() {
        this.depositAmtAccNum = createAccNumber() + "";
        accountServiceList.add(new AccountService().createAccount(Integer.parseInt(this.depositAmtAccNum), this.customerName));
        return "deposit";
    }

    public String depositAmount(){
        Optional<Account> acc = accountServiceList.stream().filter(a -> a.getAccountnumber() == Integer.parseInt(this.depositAmtAccNum))
                .reduce((acc1, acc2) -> {
                    return acc1;
                });

        Account acc2 = acc.get();
        acc2.deposit(Double.parseDouble(this.getDepositAmt()));
        return "index";
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

    public String showDetails(Long accNo){
        return "accountDetails";
    }

    public double getBalance(List<AccountEntry> accountEntry) {
        for (AccountEntry entry : accountEntry) {
            accHolderBalance += entry.getAmount();
        }
        return accHolderBalance;
    }

    public String getDepositAmt() {
        return depositAmt;
    }

    public void setDepositAmt(String depositAmt) {
        this.depositAmt = depositAmt;
    }

    public String getDepositAmtAccNum() {
        return depositAmtAccNum;
    }

    public void setDepositAmtAccNum(String depositAmtAccNum) {
        this.depositAmtAccNum = depositAmtAccNum;
    }


}
