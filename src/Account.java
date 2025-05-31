package ATMsimulator;


//Account
interface Account {

    String getPassword();
    void setPassword(String password);
    String getLogin() ;
    void setLogin(String login);
    Double getBalance();
    void withdraw(Double withdrawAmount);
    void remittance(Double remittanceAmount);


}
