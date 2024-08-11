package AuthenticationSystem;

import java.util.HashMap;
import java.util.Map;

public class UsersDatabase {
	
    private  Map<String, String> users;
    private static UsersDatabase _instance;
    
    private UsersDatabase() {
        users = new HashMap<>();
        addUser("admin", "admin");
    }
    
    public static UsersDatabase getInstance() {
    	if (_instance == null) {
    		_instance = new UsersDatabase();
    	}
    	return _instance;
    }

    public boolean isValidUser(String username) {
        return users.containsKey(username);
    }

    public boolean isValidPassword(String username, String password) {
    	return users.get(username).equals(password);
    }
    
    public boolean addUser(String username, String password) {
        if (isValidUser(username)) {
            return false; // User already exists
        }
        users.put(username, password);
        return true; // User added successfully
    }
    
    public String getPassword(String username){
    	if(users.containsKey(username))
    		return users.get(username);
    	return null;
    }
    
    public boolean setPassword(String username, String oldPassword ,String newPassword) {
    	if (users.containsKey(username)) {
    		return users.replace(username, oldPassword, newPassword);
    	}
    	return false;
    }
    
}
