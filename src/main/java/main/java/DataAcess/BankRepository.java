package main.java.DataAcess;

import main.java.Accounts.User;

import java.util.Map;

public interface BankRepository {
    public Map<String, User> getBankUsers();
    public void addUser(String login, User user);
    public User getUser(String login);
}
