package Menu;

import Employee.Role;
import Logger.Logger;
import Menu.RoleMenus.AdminMenu;
import Menu.RoleMenus.ManagerMenu;
import Menu.RoleMenus.ShiftMangerMenu;
import Menu.RoleMenus.WorkerMenu;

public class MenuFactory {
	
	public enum MenuType {
		LOGIN
	}
	
	public static Menu getMenu(Role role) {
		String menuName = role.getName() + " Menu";
		switch(role) {
		case ADMIN:{
			return new AdminMenu(menuName);
		}
		case SHIFT_MANAGER:{
			return new ShiftMangerMenu(menuName);
		}
		case MANAGER:{
			return new ManagerMenu(menuName);
		}
		case WORKER:{
			return new WorkerMenu(menuName);
		}
		
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
