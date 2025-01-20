package uebung_9_3;

import uebung_9_3.LogInterface.LogLevel;

public class MainProgram {
	public static void main(String[] args) {
		// Erstellen eines neuen ConsoleLog
		ConsoleLog cLog = new ConsoleLog();

		// Loggen auf lvl WARN
		cLog.setLogLevel(LogLevel.ERROR);

		cLog.debug("MSG1");
		cLog.warning("MSG1");
		cLog.error("MSG1");

		// Loggen auf lvl DEBUG
		cLog.setLogLevel(LogLevel.WARN);
		cLog.debug("MSG2");
		cLog.warning("MSG2");
		cLog.error("MSG2");

		cLog.setLogLevel(LogLevel.DEBUG);
		cLog.debug("MSG3");
		cLog.warning("MSG3");
		cLog.error("MSG3");
	}
}
