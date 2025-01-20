package uebung_5_6.errors;

public class ColumnIsFullException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ColumnIsFullException() {
		super("Die ausgewaehlte Spalte ist voll.");
	}

}
