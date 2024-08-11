package AuthenticateSystem.Handlers;

import AuthenticationSystem.UsersDatabase;
import Logger.Logger;
public class ValidPasswordHandler extends Handler {
    @Override
    public boolean handle(String username, String password) {
        if (!UsersDatabase.getInstance().isValidPassword(username, password)) {
            Logger.error("Wrong Password!");
            return false;
        }
        Logger.debug("password is correct");
        return handleNext(username, password);
    }
}
