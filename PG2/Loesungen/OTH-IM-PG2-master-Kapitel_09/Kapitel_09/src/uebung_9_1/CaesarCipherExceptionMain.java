package uebung_9_1;

public class CaesarCipherExceptionMain {
	public static void main(String[] args) {
		CaesarCipher caesarCipher = new CaesarCipher();
		try {
			System.out.println(caesarCipher.encryptAlternative1("abc", 3));

			System.out.println(caesarCipher.decryptAlternative1("xyz", 3));
		}
		catch (IllegalCapitalLetterException e) {
			e.printStackTrace();
		}
		catch (InvalidCharacterException e) {
			e.printStackTrace();
		}
	}

}
