//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package Interfaces;

import Logger.LogLevel;

public interface LoggerObserver {
	void update(String message, LogLevel loglevel);
}
