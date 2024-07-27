package Logger;

import Interfaces.LoggerObserver;

public class ConsoleLogger implements LoggerObserver {

	@Override
	public void update(String message, LogLevel loglevel) {
		if(loglevel != LogLevel.DEBUG) {
			if (loglevel == LogLevel.ERROR)
				System.out.println("ERROR: " + message);
			else
				System.out.println(message);
		}
					
	}

}
