package main.java.Accounts;

interface Account {

    String getPassword();
    void setPassword(String password);
    String getLogin() ;
    void setLogin(String login);
    Double getBalance();
    boolean withdraw(Double withdrawAmount);
    boolean remittance(Double remittanceAmount);


}
