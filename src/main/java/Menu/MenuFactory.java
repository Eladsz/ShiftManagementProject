package Menu;

import Employee.Role;
import Logger.Logger;

public class MenuFactory {
	
	public enum MenuType {
		LOGIN
	}
	
	public static Menu getMenu(Role role) {
		switch(role) {
			
		
		}
		Logger.error("MenuFactory.getMenu() - returns null");
		return null;
	}
	
	public static Menu getMenu(MenuType menu) {
		switch(menu) {
		case LOGIN:{
			return new LoginMenu();			
		}
		
		}
		Logger.error("MenuFactory.getMenu() - returns null");
		return null;
	}
}
