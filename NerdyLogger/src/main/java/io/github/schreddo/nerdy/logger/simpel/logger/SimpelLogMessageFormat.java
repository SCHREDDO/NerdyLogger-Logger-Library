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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.github.schreddo.nerdy.logger.abstracts.LogMessageFormat;
import io.github.schreddo.nerdy.logger.enums.LogLevel;

public class SimpelLogMessageFormat extends LogMessageFormat {
	
	private String logMessageTemplate;
	
	public String getLogMessageTemplate() {
		return logMessageTemplate;
	}
	public void setLogMessageTemplate(String logMessageTemplate) {
		this.logMessageTemplate = logMessageTemplate;
	}

	public SimpelLogMessageFormat() {
		setLogMessageTemplate(null);
	}
	
	public SimpelLogMessageFormat(String logMessageTemplate) {
		setLogMessageTemplate(logMessageTemplate);
	}

	@Override
	public String formatLogMessage(String message, LogLevel loggerLevel) {
		String logMessage = getLogMessageTemplate();
		
		logMessage = formatLogMessageDate(logMessage);
		logMessage = formatLogMessageLogLevel(logMessage, loggerLevel);
		logMessage = formatLogMessageMessage(logMessage, message);

		return logMessage;
	}
	
	@Override
	public String formatLogMessage(String message, String logMessageTemplate, LogLevel loggerLevel) {
		String logMessage = logMessageTemplate;
		
		if (logMessage == null) {
			logMessage = message;
		} else {
			logMessage = formatLogMessageDate(logMessage);
			logMessage = formatLogMessageLogLevel(logMessage, loggerLevel);
			logMessage = formatLogMessageMessage(logMessage, message);
		}

		return logMessage;
	}
	
	private String formatLogMessageDate(String logMessage) {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss z");
		
		if (logMessage.contains("<time=|")) {
			int strIndex = logMessage.indexOf("=tf(");
			int strIndexEnd = logMessage.indexOf(")tf=");
			String format = logMessage.substring(strIndex + 4, strIndexEnd + 1);
			dateFormat = new SimpleDateFormat(format);
		}
		
		logMessage = logMessage.replace("<time>", dateFormat.format(new Date()));
		return logMessage;
	}
	
	private String formatLogMessageLogLevel(String logMessage, LogLevel loggerLevel) {
		logMessage = logMessage.replace("<level>", loggerLevel.toString());
		
		return logMessage;
	}
	
	private String formatLogMessageMessage(String logMessage, String message) {
		logMessage = logMessage.replace("<message>", message);
		
		return logMessage;
	}
}
