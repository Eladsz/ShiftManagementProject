//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
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
