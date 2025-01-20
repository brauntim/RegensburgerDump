package uebung_9_3;

public class ConsoleLog implements LogInterface {
	LogLevel level = LogLevel.DEBUG;

	@Override
	public void setLogLevel(LogLevel level) {
		this.level = level;
	}

	@Override
	public void error(String msg) {
		if (this.level.ordinal() <= LogLevel.ERROR.ordinal()) {
			System.err.println("error: " + msg);
		}

	}

	@Override
	public void warning(String msg) {
		if (this.level.ordinal() <= LogLevel.WARN.ordinal()) {
			System.out.println("warning: " + msg);
		}

	}

	@Override
	public void debug(String msg) {
		if (this.level == LogLevel.DEBUG) {
			System.out.println("debug: " + msg);
		}
	}
}
