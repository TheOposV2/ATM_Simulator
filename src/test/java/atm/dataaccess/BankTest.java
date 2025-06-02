package atm.dataaccess;

import atm.accounts.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @Test
    void testAddUser() {
        Bank bank = Bank.getInstance();
        String[] credentials = {"test", "1234"};
        User user = new User(credentials);

        bank.addUser("test", user);
        assertEquals(user, bank.getUser("test"));
    }

}
