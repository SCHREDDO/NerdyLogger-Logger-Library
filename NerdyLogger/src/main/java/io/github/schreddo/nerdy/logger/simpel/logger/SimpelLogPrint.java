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

import java.util.ArrayList;
import java.util.List;

import io.github.schreddo.nerdy.logger.abstracts.LogPrint;
import io.github.schreddo.nerdy.logger.enums.LogLevel;
import io.github.schreddo.nerdy.logger.events.LogConsolEvent;
import io.github.schreddo.nerdy.logger.events.LogEvent;
import io.github.schreddo.nerdy.logger.events.LogFileEvent;
import io.github.schreddo.nerdy.logger.functions.LogPrintInConsole;
import io.github.schreddo.nerdy.logger.functions.LogPrintInFile;

public class SimpelLogPrint extends LogPrint {
	
	private String logPath;
	private LogLevel fileLogLevel;
	private LogLevel consolLogLevel;
	
	private List<LogEvent> logEventListeners;
	private List<LogFileEvent> logFileEventListeners;
	private List<LogConsolEvent> logConsolEventListeners;
	
	public String getLogPath() {
		return logPath;
	}
	public void setLogPath(String logPath) {
		this.logPath = logPath;
	}
	public LogLevel getFileLogLevel() {
		return fileLogLevel;
	}
	public void setFileLogLevel(LogLevel fileLogLevel) {
		this.fileLogLevel = fileLogLevel;
	}
	public LogLevel getConsolLogLevel() {
		return consolLogLevel;
	}
	public void setConsolLogLevel(LogLevel consolLogLevel) {
		this.consolLogLevel = consolLogLevel;
	}
	
	public List<LogEvent> getLogEventListeners() {
		return logEventListeners;
	}
	public void setLogEventListeners(List<LogEvent> logEventListeners) {
		this.logEventListeners = logEventListeners;
	}
	public List<LogFileEvent> getLogFileEventListeners() {
		return logFileEventListeners;
	}
	public void setLogFileEventListeners(List<LogFileEvent> logFileEventListeners) {
		this.logFileEventListeners = logFileEventListeners;
	}
	public List<LogConsolEvent> getLogConsolEventListeners() {
		return logConsolEventListeners;
	}
	public void setLogConsolEventListeners(List<LogConsolEvent> logConsolEventListeners) {
		this.logConsolEventListeners = logConsolEventListeners;
	}

	public SimpelLogPrint() {
		setLogPath("Log.txt");
		setFileLogLevel(LogLevel.INFO);
		setConsolLogLevel(LogLevel.INFO);
		
		setLogEventListeners(new ArrayList<LogEvent>());
		setLogFileEventListeners(new ArrayList<LogFileEvent>());
		setLogConsolEventListeners(new ArrayList<LogConsolEvent>());
	}
	
	public SimpelLogPrint(String logPath, LogLevel fileLoggerLevel, LogLevel consolLogLevel) {
		setLogPath(logPath);
		setFileLogLevel(fileLoggerLevel);
		setConsolLogLevel(consolLogLevel);
		
		setLogEventListeners(new ArrayList<LogEvent>());
		setLogFileEventListeners(new ArrayList<LogFileEvent>());
		setLogConsolEventListeners(new ArrayList<LogConsolEvent>());
	}
	
	@Override
	public int printController(String message, LogLevel loggerLevel) {
		if (getFileLogLevel().ordinal() <= loggerLevel.ordinal()) {
			LogPrintInFile.printLogMessageInFile(getLogPath(), message);
			
			informLogFileEventListener(message);
		}
		
		if (getConsolLogLevel().ordinal() <= loggerLevel.ordinal()) {
			LogPrintInConsole.printLogMessageInConsole(message);
			
			informLogConsolEventListener(message);
		}
		
		informLogEventListener(message);
		
		return 0;
	}

	@Override
	public int printController(String message, LogLevel loggerLevel, Object logPath, LogLevel fileLoggerLevel, LogLevel consolLogLevel) {
		if (fileLogLevel.ordinal() <= loggerLevel.ordinal()) {
			LogPrintInFile.printLogMessageInFile((String)logPath, message);
			
			informLogFileEventListener(message);
		}
		
		if (consolLogLevel.ordinal() <= loggerLevel.ordinal()) {
			LogPrintInConsole.printLogMessageInConsole(message);
			
			informLogConsolEventListener(message);
		}
		
		informLogEventListener(message);
		
		return 0;
	}
	
	@Override
	public int informListener(String message) {
		for (int i = 0; i < getLogEventListeners().size(); i++) {
			getLogEventListeners().get(i).eventLog(message);
		}
		
		for (int i = 0; i < getLogFileEventListeners().size(); i++) {
			getLogFileEventListeners().get(i).eventLogFile(message);
		}
		
		for (int i = 0; i < getLogConsolEventListeners().size(); i++) {
			getLogConsolEventListeners().get(i).eventLogConsol(message);
		}
		
		return 0;
	}
	
	@Override
	public int informLogEventListener(String message) {
		for (int i = 0; i < getLogEventListeners().size(); i++) {
			getLogEventListeners().get(i).eventLog(message);
		}
		
		return 0;
	}
	
	@Override
	public int informLogFileEventListener(String message) {
		for (int i = 0; i < getLogFileEventListeners().size(); i++) {
			getLogFileEventListeners().get(i).eventLogFile(message);
		}
		
		return 0;
	}
	
	@Override
	public int informLogConsolEventListener(String message) {
		for (int i = 0; i < getLogConsolEventListeners().size(); i++) {
			getLogConsolEventListeners().get(i).eventLogConsol(message);
		}
		
		return 0;
	}
}
