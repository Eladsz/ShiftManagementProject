package AuthenticateSystem.Handlers;

import AuthenticationSystem.UsersDatabase;
import Logger.Logger;
public class UserExistsHandler extends Handler {


    @Override
    public boolean handle(String username, String password) {
        if (!UsersDatabase.getInstance().isValidUser(username)) {
            Logger.error("This username is not registered!");
            Logger.error("Sign Up to our app now!");
            return false;
        }
        
        return handleNext(username, password);
    }
}
