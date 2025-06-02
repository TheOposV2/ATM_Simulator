package main.java;

import main.java.AccountServices.UserServices;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceTest {
    @Test
    public void shouldNotAddDuplicateUser(){
        UserServices services = new UserServices();
        String[] credentials = {"duplicate", "pass"};
        services.addUser(credentials);

        boolean addedAgain = services.addUser(credentials);

        assertFalse(addedAgain);
    }
    @Test
    public void shouldReturnTrueIfUserExist(){
        UserServices services = new UserServices();
        String[] credentials = {"testuser", "1234"};
        services.addUser(credentials);

        assertTrue(services.isUserExisting("testuser"));
    }

}
