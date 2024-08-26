package System;

import Logger.Logger;
import Menu.MenuFactory;
import Menu.MenuFactory.MenuType;

public class SystemMain {

	public static void main(String[] args) {
		Logger.initLogger();
		ShiftGenerator.generateShifts();
		WorkerGenerator.generateAndAssignWorkers(15);
		MenuFactory.getMenu(MenuType.LOGIN).execute();
		Logger.log("Exiting Shift Management System Program");
	}
	


}
