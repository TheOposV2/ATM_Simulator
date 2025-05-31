package ATMsimulator;


public class UserServices{
    private String login;
    private final Bank bank = Bank.getInstance();

    public boolean addUser(String[] credentials) {

        if(bank.getUser(credentials[0]) == null){
            bank.addUser(credentials[0],new User(credentials));
            return true;
        }
        return false;
    }

    public Double userWithdraw(Double balanceChange){
        User user =  bank.getBankUsers().get(getSession());
        user.withdraw(balanceChange);
        return user.getBalance();
    }

    public Double userRemittance(Double balanceChange){
        User user =  bank.getBankUsers().get(getSession());
        user.remittance(balanceChange);
        return user.getBalance();
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
}
