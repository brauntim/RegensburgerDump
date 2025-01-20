package uebung_5_6.errors;

public class FieldIsFullException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FieldIsFullException() {
		super("Das Spielfeld ist vollstaendig belegt und kein Spieler kann mehr gewinnen.");
	}
}
