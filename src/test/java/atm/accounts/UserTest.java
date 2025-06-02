package atm.accounts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    void addUser(){
        String[] credentials = {"Ty" , "Ja123"};
        user = new User(credentials);

    }
    @Test
    void initialBalanceShouldBeZero(){
        assertEquals(0.0,user.getBalance());
    }

    @Test
    void remittanceShouldIncreaseBalance(){
        user.remittance(100.0);
        assertEquals(100.0,user.getBalance());
    }
    @Test
    void withdrawShouldFailIfInsufficientFunds() {
        boolean result = user.withdraw(100.0);
        assertFalse(result);
        assertEquals(0.0, user.getBalance());
    }

    @Test
    void withdrawShouldReduceBalance(){
        user.remittance(100.0);
        boolean withdrawResult = user.withdraw(50.0);
        assertTrue(withdrawResult);
        assertEquals(50.0, user.getBalance());
    }
}
