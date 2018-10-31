package com.ksa.core.logger;

/**
 * Interface to provide logger functionality in core package, It enables to log
 * debug/error/info level of log messages
 * 
 * @version 1.0
 * @author Shashank.Agarwal
 * @since Jan 30, 2017 4:41:06 PM
 */
public interface Logger {
	/**
	 * Interface method to capture debug message, a debug message is lowest
	 * priority log
	 * 
	 * @param logSource
	 *            : source from this is called
	 * @param message
	 *            : message to log
	 */
	public void debug(String logSource, String message);

	/**
	 * Interface method to capture debug message, a debug message is second
	 * lowest priority log, INFO > DEBUG
	 * 
	 * @param logSource
	 *            : source from this is called
	 * @param message
	 *            : message to log
	 */
	public void info(String logSource, String message);

	/**
	 * Interface method to capture debug message, a debug message is high
	 * priority log <br/>
	 * ERROR>INFO>DEBUG
	 * 
	 * @param logSource
	 *            source from this is called
	 * @param message
	 *            message to log
	 * @param e
	 *            thrown exception
	 */
	public void error(String logSource, String message, Throwable e);

	/**
	 * Interface method to capture debug message, a debug message is high
	 * priority log <br/>
	 * ERROR>INFO>DEBUG
	 * 
	 * @param logSource
	 *            : source from this is called
	 * @param message
	 *            : message to log
	 */
	public void error(String logSource, String message);

	/**
	 * Interface method enables to write message in an specific file location,
	 * provided in implementation details
	 * 
	 * @param logSource
	 *            : source from this is called
	 * @param message
	 *            : message to write
	 */
	public void writeToFile(String logSource, String message);

	/**
	 * 
	 * @return true to write : dafault false
	 */
	public boolean isWriteToFileEnabled();
}
