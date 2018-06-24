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
package io.github.schreddo.nerdy.logger.functions;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LogPrintInFile {

	public static int printLogMessageInFile(String path, String message) {
		Path log = Paths.get(path);

		try {
			FileChannel fileChannel = FileChannel.open(log, StandardOpenOption.APPEND, StandardOpenOption.WRITE);
			ByteBuffer byteBuffer = ByteBuffer.wrap(("\r\n" + message).getBytes());
			fileChannel.write(byteBuffer);
			fileChannel.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return 0;
	}
}
