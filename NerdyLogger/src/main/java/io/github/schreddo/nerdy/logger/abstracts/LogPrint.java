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
package io.github.schreddo.nerdy.logger.abstracts;

import io.github.schreddo.nerdy.logger.enums.LogLevel;

public abstract class LogPrint {
	
	public LogPrint() {
		
	}

	public abstract int printController(String message, LogLevel loggerLevel);
	
	public abstract int printController(String message, LogLevel loggerLevel, Object logPath, LogLevel fileLoggerLevel, LogLevel consolLogLevel);

	public abstract int informListener(String message);

	public abstract int informLogEventListener(String message);

	public abstract int informLogFileEventListener(String message);

	public abstract int informLogConsolEventListener(String message);
}
