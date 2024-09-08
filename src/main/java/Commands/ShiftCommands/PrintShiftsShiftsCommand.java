//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package Commands.ShiftCommands;

import java.time.LocalDate;

import Commands.LoginMenuCommands.LoginCommand;
import IO.Input;
import Interfaces.Command;
import Logger.Logger;
import Menu.LoginMenu;
import Shift.ShiftManager;

public class PrintShiftsShiftsCommand implements Command {
	public boolean printMyShifts = true;
	
	enum printOption {
		
		ByDay (1, "By Day"),
		ByWeek (2, "By Week"),
		ByMonth(3, "By Month");

		private int index;
		private String name;

		printOption(int index, String name) {
			this.name = name;
			this.index = index;
		}
		
		public String getName() {
			return name;
		}
		
		public int getIndex() {
			return index;
		}
	}
	
	
	@Override
	public void execute() {
		
		int employeeID = LoginCommand.loggedIn.getId();
		if (!printMyShifts)
			employeeID = Input.getIDFromUser("Enter the employee ID");
		
		for (printOption option : printOption.values()) {
			Logger.log(option.getIndex() + ". " + option.getName());
		}
		Logger.log("Choose an option: ");
		
		int option = Input.getNumberInRange(1, printOption.values().length);
		
		switch (option) {
		case  1:{
			printShiftsByDay(Input.getPastDate("Enter the date"), employeeID);
			break;
		}
		case  2:{
			printShiftByWeek(Input.getNumberInRange(1, 53, "Enter the week number"), employeeID);
			break;
		}
		case  3:{
			printShiftByMonth(Input.getNumberInRange(1, 12, "Enter the month number"), employeeID);
			break;
		}

		} 
	}


	private void printShiftByMonth(int month, int id) {
		ShiftManager.getInstance().printShiftsByMonth(month, id);
		
	}


	private void printShiftByWeek(int week, int id) {
		ShiftManager.getInstance().printShiftsByWeek(week, id);
		
	}


	private void printShiftsByDay(LocalDate day, int id) {
		ShiftManager.getInstance().printShiftsByDay(day, id);
		
	}
	}


