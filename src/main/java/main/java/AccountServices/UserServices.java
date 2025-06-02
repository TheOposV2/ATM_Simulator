package main.java.AccountServices;

import main.java.Accounts.User;
import main.java.DataAcess.Bank;

public class UserServices implements SessionManager{
    private String login;
    private final Bank bank = Bank.getInstance();

    public boolean addUser(String[] credentials) {

        if(bank.getUser(credentials[0]) == null){
            bank.addUser(credentials[0],new User(credentials));
            return true;
        }
        return false;
    }

    public boolean userWithdraw(Double balanceChange){
        User user =  bank.getBankUsers().get(getSession());
        return user.withdraw(balanceChange);
    }

    public boolean userRemittance(Double balanceChange){
        User user =  bank.getBankUsers().get(getSession());
        return user.remittance(balanceChange);
    }

    public void setSession(String login){
        this.login = login;
    }
    public String getSession(){
        return this.login;
    }

    public boolean loggingIn(String[] credentials){
        User user =  bank.getUser(credentials[0]);
        if(user == null) return false;
        setSession(credentials[0]);
        return user.getPassword().equals(credentials[1]);
    }

    public double getBalance(){
        return bank.getUser(getSession()).getBalance();
    }

    public boolean isUserExisting(String login){
        return bank.getUser(login) != null;
    }
}
