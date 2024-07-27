package Interfaces;

import Logger.LogLevel;

public interface LoggerObserver {
	void update(String message, LogLevel loglevel);
}
