package uebung_9_2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class Log4jTestMain {

	// Logger init
	private static final Logger logger = LogManager.getLogger(Log4jTestMain.class);

	public static void main(String[] args) {

		Configurator.setRootLevel(Level.DEBUG);
		logger.debug("Meine Debug-Meldung");
		logger.info("Meine Info-Meldung");
		logger.warn("Meine Warn-Meldung");
		logger.error("Meine Error-Meldung");
		logger.fatal("Meine Fatal-Meldung");
	}

}
