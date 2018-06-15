package service;


import dao.AccountDAO;
import dao.IAccountDAO;
import domain.Account;
import domain.Customer;
import jms.IJMSSender;
import jms.JMSSender;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named
@ApplicationScoped
public class AccountService implements IAccountService, Serializable {
    private IAccountDAO accountDAO;
    private ICurrencyConverter currencyConverter;
    private IJMSSender jmsSender;

    private static List<Account> accountServiceList;

    static {
        accountServiceList = (List<Account>) returnAccountLists();
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

    public int createAccNumber() {
        Random rnd = new Random();
        return 100000 + rnd.nextInt(9999999);
    }

    public String createAccount(String customerName) {
        try {
            int accNo = createAccNumber();
            accountServiceList.add(new AccountService().createAccount(accNo, customerName));
            return "Success, Account Created! Acc # : " + accNo;
        } catch (Exception exception) {
            return "fail";
        }
    }

    public String depositAmount(String accNo, String amt) {
        accountServiceList.stream().filter(a -> a.getAccountnumber() == Integer.parseInt(accNo))
                .reduce((acc1, acc2) -> {
                    return acc1;
                }).get().deposit(Double.parseDouble(amt));
        return "Amount Deposited";
    }

    public List<Account> returnFinalListOfAccounts() {
        return accountServiceList;
    }

    public AccountService() {
        accountDAO = new AccountDAO();
        currencyConverter = new CurrencyConverter();
        jmsSender = new JMSSender();
    }

    public Account createAccount(long accountNumber, String customerName) {
        Account account = new Account(accountNumber);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);
        accountDAO.saveAccount(account);
        System.out.println(
                "createAccount with parameters accountNumber= " + accountNumber + " , customerName= " + customerName);
        return account;
    }

    public void deposit(long accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);
        accountDAO.updateAccount(account);
        System.out.println("deposit with parameters accountNumber= " + accountNumber + " , amount= " + amount);
        if (amount > 10000) {
            jmsSender.sendJMSMessage("Deposit of $ " + amount + " to account with accountNumber= " + accountNumber);
        }
    }

    public Account getAccount(long accountNumber) {
        Account account = accountDAO.loadAccount(accountNumber);
        return account;
    }

    public Collection<Account> getAllAccounts() {
        return accountDAO.getAccounts();
    }

    public void withdraw(long accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);
        System.out.println("withdraw with parameters accountNumber= " + accountNumber + " , amount= " + amount);
    }

    public void depositEuros(long accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.deposit(amountDollars);
        accountDAO.updateAccount(account);
        System.out.println("depositEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
        if (amountDollars > 10000) {
            jmsSender.sendJMSMessage("Deposit of $ " + amount + " to account with accountNumber= " + accountNumber);
        }
    }

    public void withdrawEuros(long accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.withdraw(amountDollars);
        accountDAO.updateAccount(account);
        System.out.println("withdrawEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
    }

    public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);
        System.out.println("transferFunds with parameters fromAccountNumber= " + fromAccountNumber + " , toAccountNumber= "
                + toAccountNumber + " , amount= " + amount + " , description= " + description);
        if (amount > 10000) {
            jmsSender.sendJMSMessage("TransferFunds of $ " + amount + " from account with accountNumber= " + fromAccount
                    + " to account with accountNumber= " + toAccount);
        }
    }
}
