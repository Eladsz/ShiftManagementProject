package System;

import Menu.MenuFactory;
import Menu.MenuFactory.MenuType;

public class SystemMain {

	public static void main(String[] args) {
		MenuFactory.getMenu(MenuType.LOGIN).execute();

	}

}
