package Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import Commands.ExitCommand;
import IO.Input;
import Logger.Logger;
import Interfaces.*;

public abstract class Menu implements MenuInterface, Command{
	
	private Map<String, Command> options;
	private List<String> optionsNames;
	private String menuName;
	private String exitMessage;
	protected boolean keep = true;
	
	public Menu(String name) {
		setMenuName(name);
		options = new LinkedHashMap<String, Command>();
		optionsNames = new ArrayList<String>();	
		addExitOption("Exit");
	}
	
	public Menu(String name, String returnOption) {
		setMenuName(name);
		options = new HashMap<String, Command>();
		optionsNames = new ArrayList<String>();
		addExitOption(returnOption);
	}
	
	@Override
	public void display() {
		int i = 0;
		Logger.log("\n\n\n*********************************");
		Logger.log(menuName);
		for (String option : getOptionsNames()) {
			Logger.log((i++) + ". " + option);
		}
		Logger.log("*********************************");
		
	}
	
	@Override
	public void exit() {
		if (exitMessage == null)
			Logger.log("Exiting " + menuName + "...");
		else
			Logger.log(exitMessage);
		
		return;
	}
	
	@Override
	public void execute() {
		while(true) {

			display();
			Logger.log("Please choose an option:");
			int index = Input.getNumberInRange(0, getOptionsCount()-1);
			String option = getOptionsNames().get(index);
			
			try {
			  getOptions().get(option).execute();
				
			}
			catch (Exception e) {
				Logger.error(e.getMessage());
				Logger.error("Please try again");
			}
			
			if (index == 0) {
				exit();
				break;
			}
			else 
				AfterAction();
			
			if(!keep)
				return;
		}
		
		
	}
	
	
	public void AfterAction() {
		
	}
	
	public void AddOption(String newOption, Command cmd) {
			optionsNames.add(newOption);
			getOptions().put(newOption, cmd);
	}
	
	
	
	public List<String> getOptionsNames(){
		return optionsNames;
	}
	
	public int getOptionsCount() {
		return getOptions().size();
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Map<String, Command> getOptions() {
		return options;
	}
	
	public void SetExitMessage(String msg) {
		this.exitMessage = msg;
	}
	
	private void addExitOption(String exitOptionName) {
		optionsNames.add(exitOptionName);
		getOptions().put(exitOptionName, new ExitCommand());
	}
	

	
	
	
}
