package uebung_9_3;

public interface LogInterface {
	public enum LogLevel {
		DEBUG, WARN, ERROR
	}

	void setLogLevel(LogLevel level);

	void error(String msg);

	void warning(String msg);

	void debug(String msg);
}
