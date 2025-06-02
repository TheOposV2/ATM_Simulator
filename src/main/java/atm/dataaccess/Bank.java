package atm.dataaccess;

import atm.accounts.User;

import java.util.*;

public class Bank implements BankRepository {
    private static Bank instance;

    private final Map<String, User> bankUsers = new HashMap<String, User>();

    public Bank() {
        String[] credentials = {"admin","admin"};
        this.bankUsers.put("admin",new User(credentials));
    }

    public static Bank getInstance() {
        synchronized (Bank.class) {
            if (instance == null) {
                instance = new Bank();
            }
            return instance;
        }
    }

    public Map<String, User> getBankUsers(){
        return this.bankUsers;
    }

    public void addUser(String login, User user){
            getBankUsers().put(login,user);
    }
    public User getUser(String login){
        return getBankUsers().get(login);
    }


}
