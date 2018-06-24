// Copyright (C) 2018 Sebastian Lühnen
//
//
// This file is part of NerdyLogger.
// 
// NerdyLogger is free software: you can redistribute it and/or modify
// it under the terms of the GNU Affero General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// NerdyLogger is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Affero General Public License for more details.
//
// You should have received a copy of the GNU Affero General Public License
// along with NerdyLogger. If not, see <http://www.gnu.org/licenses/>.
//
//
// Created By: Sebastian Lühnen
// Created On: 24.06.2018
// Last Edited On: 24.06.2018
// Language: Java
//
package io.github.schreddo.nerdy.logger.simpel.logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import io.github.schreddo.nerdy.logger.NerdyLogger;
import io.github.schreddo.nerdy.logger.enums.LogLevel;
import io.github.schreddo.nerdy.logger.enums.LogLevelSetting;
import io.github.schreddo.nerdy.logger.events.LogConsolEvent;
import io.github.schreddo.nerdy.logger.events.LogEvent;
import io.github.schreddo.nerdy.logger.events.LogFileEvent;
import io.github.schreddo.nerdy.logger.functions.LogPrintInConsole;
import io.github.schreddo.nerdy.logger.functions.LogPrintInFile;

public class SimpelLogger extends NerdyLogger {
	
	private String logPath;
	private SimpelLogPrint simpelLogPrint;
	private SimpelLogMessageFormat simpelLogMessageFormat;
	
	private static LogLevelSetting logLevelSetting;
	private static LogLevel sameFileLogLevel;
	private static LogLevel sameConsolLogLevel;
	
	public String getLogPath() {
		return logPath;
	}
	public void setLogPath(String logPath) {
		this.logPath = logPath;
	}
	public SimpelLogPrint getSimpelLogPrint() {
		return simpelLogPrint;
	}
	public void setSimpelLogPrint(SimpelLogPrint simpelLogPrint) {
		this.simpelLogPrint = simpelLogPrint;
	}
	public SimpelLogMessageFormat getSimpelLogMessageFormat() {
		return simpelLogMessageFormat;
	}
	public void setSimpelLogMessageFormat(SimpelLogMessageFormat simpelLogMessageFormat) {
		this.simpelLogMessageFormat = simpelLogMessageFormat;
	}
	
	public static LogLevelSetting getLogLevelSetting() {
		return logLevelSetting;
	}
	public static void setLogLevelSetting(LogLevelSetting logLevelSetting) {
		SimpelLogger.logLevelSetting = logLevelSetting;
	}
	public static LogLevel getSameFileLogLevel() {
		return sameFileLogLevel;
	}
	public static void setSameFileLogLevel(LogLevel sameFileLogLevel) {
		SimpelLogger.sameFileLogLevel = sameFileLogLevel;
	}
	public static LogLevel getSameConsolLogLevel() {
		return sameConsolLogLevel;
	}
	public static void setSameConsolLogLevel(LogLevel sameConsolLogLevel) {
		SimpelLogger.sameConsolLogLevel = sameConsolLogLevel;
	}

	public SimpelLogger() {
		super();
		
		setLogLevelSetting(LogLevelSetting.defauld);
		setFileLogLevel(LogLevel.INFO);
		setConsolLogLevel(LogLevel.INFO);
		
		loggerInitialisieren(null, null, null);
	}

	public SimpelLogger(String logName) {
		super(logName);
		
		setLogLevelSetting(LogLevelSetting.defauld);
		setFileLogLevel(LogLevel.INFO);
		setConsolLogLevel(LogLevel.INFO);
		
		loggerInitialisieren(logName, null, null);
	}

	public SimpelLogger(LogLevel logLevel) {
		super(logLevel);
		
		setLogLevelSetting(LogLevelSetting.defauld);
		setFileLogLevel(LogLevel.INFO);
		setConsolLogLevel(LogLevel.INFO);
		
		loggerInitialisieren(null, logLevel, null);
	}

	public SimpelLogger(String logName, LogLevel logLevel) {
		super(logName, logLevel);
		
		setLogLevelSetting(LogLevelSetting.defauld);
		setFileLogLevel(LogLevel.INFO);
		setConsolLogLevel(LogLevel.INFO);
		
		loggerInitialisieren(logName, logLevel, null);
	}
	
	public SimpelLogger(String logName, LogLevel logLevel, String logMessageTemplate) {
		super(logName, logLevel, logMessageTemplate);
		
		setLogLevelSetting(LogLevelSetting.defauld);
		setFileLogLevel(LogLevel.INFO);
		setConsolLogLevel(LogLevel.INFO);
		
		loggerInitialisieren(logName, logLevel, logMessageTemplate);
	}
	
	public SimpelLogger(LogLevelSetting logLevelSetting, LogLevel sameFileLogLeve, LogLevel sameConsolLogLevel) {
		super();
		
		setLogLevelSetting(logLevelSetting);
		setFileLogLevel(sameFileLogLeve);
		setConsolLogLevel(sameConsolLogLevel);
		
		loggerInitialisieren(null, null, null);
	}
	
	public SimpelLogger(String logName, LogLevelSetting logLevelSetting, LogLevel sameFileLogLeve, LogLevel sameConsolLogLevel) {
		super(logName);
		
		setLogLevelSetting(logLevelSetting);
		setFileLogLevel(sameFileLogLeve);
		setConsolLogLevel(sameConsolLogLevel);
		
		loggerInitialisieren(logName, null, null);
	}
	
	public SimpelLogger(LogLevel logLevel, LogLevelSetting logLevelSetting, LogLevel sameFileLogLeve, LogLevel sameConsolLogLevel) {
		super(logLevel);
		
		setLogLevelSetting(logLevelSetting);
		setFileLogLevel(sameFileLogLeve);
		setConsolLogLevel(sameConsolLogLevel);
		
		loggerInitialisieren(null, logLevel, null);
	}
	
	public SimpelLogger(String logName, LogLevel logLevel, LogLevelSetting logLevelSetting, LogLevel sameFileLogLeve, LogLevel sameConsolLogLevel) {
		super(logName, logLevel);
		
		setLogLevelSetting(logLevelSetting);
		setFileLogLevel(sameFileLogLeve);
		setConsolLogLevel(sameConsolLogLevel);
		
		loggerInitialisieren(logName, logLevel, null);
	}
	
	public SimpelLogger(String logName, LogLevel logLevel, String logMessageTemplate, LogLevelSetting logLevelSetting, LogLevel sameFileLogLeve, LogLevel sameConsolLogLevel) {
		super(logName, logLevel, logMessageTemplate);
		
		setLogLevelSetting(logLevelSetting);
		setFileLogLevel(sameFileLogLeve);
		setConsolLogLevel(sameConsolLogLevel);
		
		loggerInitialisieren(logName, logLevel, logMessageTemplate);
	}
	
	@Override
	protected int loggerInitialisieren(String logName, LogLevel logLevel, String logMessageTemplate) {
		loggerInitialisierenLog(logName);
		loggerInitialisierenLogLevel(logLevel);
		loggerInitialisierenLogMessageTemplate(logMessageTemplate);
		
		setSimpelLogPrint(new SimpelLogPrint(getLogPath(), getFileLogLevel(), getConsolLogLevel()));
		setSimpelLogMessageFormat(new SimpelLogMessageFormat(getLogMessageTemplate()));
		
		File f = new File(getLogPath());
		if(!(f.exists() && !f.isDirectory())) { 
			createLogFile();
		}
		
		return 0;
	}
	
	private int loggerInitialisierenLog(String logName) {
		if (logName == null) {
			logName = "log.txt";
		}
		
		if ((Character.toString(logName.charAt(0))).equals(".")) {
			logName = logName.substring(1, logName.length());
		} else {
			logName = "" + System.getProperty("user.dir") + "\\" + logName;
		}
		setLogPath(logName);
		
		return 0;
	}
	
	private int loggerInitialisierenLogLevel(LogLevel logLevel) {
		if (logLevel != null) {
			switch (getLogLevelSetting()) {
			case defauld:
				setFileLogLevel(logLevel);
				setConsolLogLevel(logLevel);
				break;
			case allSameLevel:
				setFileLogLevel(getSameFileLogLevel());
				setConsolLogLevel(getSameConsolLogLevel());
				break;
			case nonConsol:
				setFileLogLevel(logLevel);
				setConsolLogLevel(LogLevel.NON);
				break;
			case allConsol:
				setFileLogLevel(getSameFileLogLevel());
				setConsolLogLevel(LogLevel.ALL);
				break;
			default:
				break;
			}
		}
		
		return 0;
	}
	
	private int loggerInitialisierenLogMessageTemplate(String logMessageTemplate) {
		if (logMessageTemplate == null || logMessageTemplate.isEmpty()) {
			setLogMessageTemplate("| <level> | <time>: <message>");
		} else {
			setLogMessageTemplate(logMessageTemplate);
		}
		
		return 0;
	}

	@Override
	public int log(String message) {
		message = getSimpelLogMessageFormat().formatLogMessage(message, LogLevel.INFO);
		
		LogPrintInFile.printLogMessageInFile(getLogPath(), message);
		LogPrintInConsole.printLogMessageInConsole(message);
		
		return 0;
	}

	@Override
	public int log(LogLevel logLevel, String message) {
		message = getSimpelLogMessageFormat().formatLogMessage(message, logLevel);
		
		LogPrintInFile.printLogMessageInFile(getLogPath(), message);
		LogPrintInConsole.printLogMessageInConsole(message);
		
		return 0;
	}

	@Override
	public int log(LogLevel logLevel, String message, boolean isMessageTemplate) {
		if (isMessageTemplate) {
			message = getSimpelLogMessageFormat().formatLogMessage(message, getLogMessageTemplate(), logLevel);
		} else {
			message = getSimpelLogMessageFormat().formatLogMessage(message, null, logLevel);
		}
		
		LogPrintInFile.printLogMessageInFile(getLogPath(), message);
		LogPrintInConsole.printLogMessageInConsole(message);
		
		return 0;
	}

	@Override
	public int fatal(String message) {
		return logController(message, LogLevel.FATAL);
	}

	@Override
	public int error(String message) {
		return logController(message, LogLevel.ERROR);
	}

	@Override
	public int warning(String message) {
		return logController(message, LogLevel.WARNING);
	}

	@Override
	public int info(String message) {
		return logController(message, LogLevel.INFO);
	}

	@Override
	public int debug(String message) {
		return logController(message, LogLevel.DEBUG);
	}

	@Override
	public int trace(String message) {
		return logController(message, LogLevel.TRACE);
	}

	@Override
	protected String buildMessage(String message, String logMessageTemplate, LogLevel loggerLevel) {
		message = getSimpelLogMessageFormat().formatLogMessage(message, loggerLevel);
		
		return message;
	}
	
	@Override
	protected int logController(String message, LogLevel loggerLevel) {
		if (loggerLevel.ordinal() <= getFileLogLevel().ordinal() || loggerLevel.ordinal() <= getConsolLogLevel().ordinal()) {

			message = buildMessage(message, getLogMessageTemplate(), loggerLevel);

			getSimpelLogPrint().printController(message, loggerLevel);
		}
		
		return 0;
	}

	@Override
	public int createBackup() {
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
			File backupZIP = new File(getLogPath().replaceAll(".txt", "__" + dateFormat.format(new Date()) + ".zip"));
		
			ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(backupZIP));
		
			ZipEntry oldLog = new ZipEntry(getLogPath());
			zip.putNextEntry(oldLog);
			zip.close();
		} catch (Exception e) {
			return 0;
		}
		
		return 0;
	}

	@Override
	public int clearLog() {
		createLogFile();
		return 0;
	}
	
	@Override
	public boolean createLogFile() {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss z");
		
		File log = new File(getLogPath());
		log.getParentFile().mkdirs();
		
		FileWriter logFile;
		try {
			logFile = new FileWriter(log);
			logFile.write("Log(" + dateFormat.format(new Date()) + ") Location: " + getLogPath());
			logFile.flush();
			logFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
    public void addLogEventListener(LogEvent listener) {
    	getSimpelLogPrint().getLogEventListeners().add(listener);
    }
    
    public void removeLogEventListener(LogEvent listener) {
    	getSimpelLogPrint().getLogEventListeners().remove(listener);
    }
    
    public void addLogFileEventListener(LogFileEvent listener) {
    	getSimpelLogPrint().getLogFileEventListeners().add(listener);
    }
    
    public void removeLogFileEventListener(LogFileEvent listener) {
    	getSimpelLogPrint().getLogFileEventListeners().remove(listener);
    }
    
    public void addLogConsolEventListener(LogConsolEvent listener) {
    	getSimpelLogPrint().getLogConsolEventListeners().add(listener);
    }
    
    public void removeLogConsolEventListener(LogConsolEvent listener) {
    	getSimpelLogPrint().getLogConsolEventListeners().remove(listener);
    }
}
