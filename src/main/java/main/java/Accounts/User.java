package main.java.Accounts;


public class User implements Account {
    private String password;
    private String login;
    private Double balance;

    public User(String[] credentials) {
        this.login = credentials[0];
        this.password = credentials[1];
        this.balance = 0.0;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Double getBalance() {
        return balance;
    }


    public boolean withdraw(Double withdrawAmount) {
        if (balance >= withdrawAmount) {
            balance -= withdrawAmount;
            return true;
        } else {
            return false;
        }
    }

    public boolean remittance(Double remittanceAmount) {

        this.balance = this.balance + remittanceAmount;
        return true;

    }


}
