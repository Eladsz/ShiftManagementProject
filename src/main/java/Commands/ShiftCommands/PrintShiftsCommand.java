package Commands.ShiftCommands;

import java.time.LocalDate;

import IO.Input;
import Interfaces.Command;
import Logger.Logger;
import Shift.ShiftManager;

public class PrintShiftsCommand implements Command {

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
		for (printOption option : printOption.values()) {
			Logger.log(option.getIndex() + ". " + option.getName());
		}
		
		Logger.log("Choose an option: ");
		int option = Input.getNumberInRange(1, printOption.values().length);
		
		switch (option) {
		case  1:{
			printShiftsByDay(Input.getPastDate("Enter the date"));
			break;
		}
		case  2:{
			printShiftByWeek(Input.getNumberInRange(1, 53, "Enter the week number"));
			break;
		}
		case  3:{
			printShiftByMonth(Input.getNumberInRange(1, 12, "Enter the month number"));
			break;
		}

		} 
	}


	private void printShiftByMonth(int month) {
		ShiftManager.getInstance().printShiftsByMonth(month);
		
	}


	private void printShiftByWeek(int week) {
		ShiftManager.getInstance().printShiftsByWeek(week);
		
	}


	private void printShiftsByDay(LocalDate day) {
		ShiftManager.getInstance().printShiftsByDay(day);
		
	}
	}


