package atm.dataaccess;

import atm.accounts.User;

import java.util.Map;

public interface BankRepository {
    public Map<String, User> getBankUsers();
    public void addUser(String login, User user);
    public User getUser(String login);
}
