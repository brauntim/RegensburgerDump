package uebung_9_1;

import java.util.regex.Pattern;

public class CaesarCipher {
	Pattern asciiPattern = Pattern.compile("[a-zA-Z]+");
	Pattern uppercasePattern = Pattern.compile(".*[A-Z].*");

	public String encryptAlternative1(String text, int key)
			throws IllegalCapitalLetterException, InvalidCharacterException {
		String output = "";

		if (!asciiPattern.matcher(text).matches()) {
			throw new InvalidCharacterException("Invalid character in " + text);
		}
		if (uppercasePattern.matcher(text).matches()) {
			throw new IllegalCapitalLetterException("Uppercase letter in " + text);
		}

		// Algorithm: (P + K) mod 26, P is the letter and K the key
		for (char c : text.toCharArray()) {
			int encryptedC = (((c - 'a') + key) % 26) + 'a';
			output += (char) encryptedC;
		}

		return output;
	}

	public String decryptAlternative1(String text, int key)
			throws IllegalCapitalLetterException, InvalidCharacterException {
		String output = "";

		if (!asciiPattern.matcher(text).matches()) {
			throw new InvalidCharacterException("Invalid character in " + text);
		}
		if (uppercasePattern.matcher(text).matches()) {
			throw new IllegalCapitalLetterException("Uppercase letter in " + text);
		}

		for (char c : text.toCharArray()) {
			int encryptedC = (((c - 'a') - key) % 26) + 'a';
			if (encryptedC < 'a') {
				encryptedC += 'z' - 'a' + 1;
			}
			output += (char) encryptedC;
		}

		return output;
	}
}
