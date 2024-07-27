package DatabaseTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import AuthenticationSystem.UsersDatabase;
import Logger.Logger;

public class UsersDatabaseTest {
    @BeforeAll
    public static void setup() {
        Logger.initLogger();
    }
    @Test
    public void testAddUser() {
        assertTrue(UsersDatabase.getInstance().addUser("new_user", "new_password"));				//New user
        assertFalse(UsersDatabase.getInstance().addUser("admin", "admin")); 						// Existing user
    }

    @Test
    public void testIsValidUser() {
        assertTrue(UsersDatabase.getInstance().isValidUser("admin")); 								
        assertFalse(UsersDatabase.getInstance().isValidUser("nonexistent_user")); 					// not exist
    }

    @Test
    public void testIsValidPassword() {
        assertTrue(UsersDatabase.getInstance().isValidPassword("admin", "admin"));					//hard-coded user
        assertFalse(UsersDatabase.getInstance().isValidPassword("admin", "wrong_password"));		// not exist
    }
}
