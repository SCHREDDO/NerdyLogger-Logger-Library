# NerdyLogger-Logger-Library
![build version](https://img.shields.io/badge/version-v1.0.0-brightgreen.svg)
![release version](https://img.shields.io/badge/release-v0.0.0-blue.svg)
![framework or language](https://img.shields.io/badge/Java-1.5-blue.svg)
![license](https://img.shields.io/badge/license-AGPL--3.0-lightgrey.svg)

### Current Version 0.0.0
### Development Version 1.0.0

## About
The NerdyLogger project was created out of boredom and fun. NerdyLogger is a library that allows users to log events. In addition, the library offers features to simplify the logging. The library is programed with Java 5.

##### Infos: 
- English isn’t my first language, so please excuse any mistakes.
- Contact me for proposals or questions.

## Features
### Features Timeline
#### Version 1.0.0
- defin log filename (Simpel Logger)
- set logging level for one logger instance (Simpel Logger)
- set logging level for all logger instance (Simpel Logger)
- set logging message template for one logger instance (Simpel Logger)
- one logger instance can handel one log file (Simpel Logger)
- log with level fatal (Simpel Logger)
- log with level error (Simpel Logger)
- log with level warning (Simpel Logger)
- log with level info (Simpel Logger)
- log with level debug (Simpel Logger)
- log with level trace (Simpel Logger)
- log independent from logging level and logging message template settings (Simpel Logger)
- create backup from log file (Simpel Logger)
- clear log file (Simpel Logger)
- add/remove listener for the event logging (Simpel Logger)
- add/remove listener for the event logging into a file (Simpel Logger)
- add/remove listener for the event logging into the consol (Simpel Logger)
### Upcoming Features
#### Simplified Logger
- [ ] set logging level
- [ ] log with level fatal
- [ ] log with level error
- [ ] log with level warning
- [ ] log with level info
- [ ] log with level debug
- [ ] log with level trace
- [ ] log independent from logging level
- [ ] clear log file
#### Simpel Logger
- [x] defin log filename
- [x] set logging level for one logger instance
- [x] set logging level for all logger instance
- [x] set logging message template for one logger instance
- [x] one logger instance can handel one log file
- [x] log with level fatal
- [x] log with level error
- [x] log with level warning
- [x] log with level info
- [x] log with level debug
- [x] log with level trace
- [x] log independent from logging level and logging message template settings
- [x] create backup from log file
- [x] clear log file
- [x] add/remove listener for the event logging
- [x] add/remove listener for the event logging into a file
- [x] add/remove listener for the event logging into the consol
#### Extend Logger
- [ ] defin logging settings in a file
- [ ] defin log filenames
- [ ] set logging level for one logger instance
- [ ] set logging level for all logger instance
- [ ] set logging message template for one logger instance
- [ ] set logging message template for all logger instance
- [ ] one logger instance can handel multi log files
- [ ] log with level fatal
- [ ] log with level error
- [ ] log with level warning
- [ ] log with level info
- [ ] log with level debug
- [ ] log with level trace
- [ ] log independent from logging level and logging message template settings
- [ ] create backup from log file
- [ ] clear log file
- [ ] add/remove listener for the event logging
- [ ] add/remove listener for the event logging into a file
- [ ] add/remove listener for the event logging into the consol

## Getting Started

## Usage
### Defined Logging Levels
| Name |
|------|
| fatal |
| error |
| warning |
| info |
| debug |
| trace |
### Logging Level Setting Options
| Name | Description |
|------|-------------|
| defauld ||
| allSameLevel ||
| nonConsol ||
| allConsol ||

### Function / Methode
#### Class: SimpelLogger 
| Name | Return | Description | Throws |
|------|--------|-------------|--------|
| getLogPath | String |||
| SimpelLogger |  |||
| log | int |||
| fatal | int |||
| error | int |||
| warning | int |||
| info | int |||
| debug | int |||
| trace | int |||
| createBackup | int |||
| clearLog | int |||
| addLogEventListener | void |||
| removeLogEventListener | void |||
| addLogFileEventListener | void |||
| removeLogFileEventListener | void |||
| addLogConsolEventListener | void |||
| removeLogConsolEventListener | void |||

### Examples

## List of Error/Warning Codes
| Name | Description |
|------|-------------|

## Dependencies
### Runtime Dependencies
- Java 1.5 or higher
### Development Dependencies
- Java 1.5

## Unit Tests
No Unit Tests defined.

## Changelog
### = 1.0.0 June 24th 2018 =
#### Added
- defin log filename
- set logging level for one logger instance
- set logging level for all logger instance
- set logging message template for one logger instance
- one logger instance can handel one log file
- log with level fatal
- log with level error
- log with level warning
- log with level info
- log with level debug
- log with level trace
- log independent from logging level and logging message template settings
- create backup from log file
- clear log file
- add/remove listener for the event logging
- add/remove listener for the event logging into a file
- add/remove listener for the event logging into the consol

## Support Possibilities
- give proposals
- report bugs

## License
NerdyLogger is released under the [AGPL-3.0](https://www.gnu.org/licenses/agpl-3.0.de.html) License.
