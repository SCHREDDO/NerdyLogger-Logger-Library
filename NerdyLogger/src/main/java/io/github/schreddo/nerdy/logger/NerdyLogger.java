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
package io.github.schreddo.nerdy.logger;

import io.github.schreddo.nerdy.logger.abstracts.Logger;
import io.github.schreddo.nerdy.logger.enums.LogLevel;

public abstract class NerdyLogger extends Logger {
	
	private String logMessageTemplate;
	private LogLevel fileLogLevel;
	private LogLevel consolLogLevel;

	public String getLogMessageTemplate() {
		return logMessageTemplate;
	}
	public void setLogMessageTemplate(String logMessageTemplate) {
		this.logMessageTemplate = logMessageTemplate;
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

	public NerdyLogger() {
		setLogMessageTemplate("");
		setFileLogLevel(LogLevel.INFO);
		setConsolLogLevel(LogLevel.INFO);
	}

	public NerdyLogger(String logName) {
		setLogMessageTemplate("");
		setFileLogLevel(LogLevel.INFO);
		setConsolLogLevel(LogLevel.INFO);
	}

	public NerdyLogger(LogLevel logLevel) {
		setLogMessageTemplate("");
		setFileLogLevel(LogLevel.INFO);
		setConsolLogLevel(LogLevel.INFO);
	}

	public NerdyLogger(String logName, LogLevel logLevel) {
		setLogMessageTemplate("");
		setFileLogLevel(LogLevel.INFO);
		setConsolLogLevel(LogLevel.INFO);
	}

	public NerdyLogger(String logName, LogLevel logLevel, String logMessageTemplate) {
		setLogMessageTemplate("");
		setFileLogLevel(LogLevel.INFO);
		setConsolLogLevel(LogLevel.INFO);
	}
	
	protected abstract int loggerInitialisieren(String logName, LogLevel logLevel, String logMessageTemplate);
	
	protected abstract int logController(String message, LogLevel loggerLevel);
	
	protected abstract String buildMessage(String message, String logMessageTemplate, LogLevel loggerLevel);
}