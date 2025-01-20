package uebung_4_2;

public class PasswordManager {
	// Attributes should always be private or protected. Only if they are final
	// constants the can be public.
	private String password = "pg2machtspass";
	private int failedAttemptsCounter = 0;

	public int verifyPassword(String passwordToCheck) {
		if (failedAttemptsCounter >= 3) {
			// If the user entered a wrong password too often, a value less than zero is
			// returned
			return -1;
		}
		else if (passwordToCheck.equals(password)) {
			// if the password is correct, one is returned
			failedAttemptsCounter = 0;
			return 1;
		}
		else {
			// Zero is returned for a wrong password and the counter for wrong password is
			// increased.
			failedAttemptsCounter++;
			return 0;
		}
	}

	public boolean changePassword(String newPassword, String oldPassword) {
		// check if the old password is correct. If so, it get´s replaced by the new
		// one.
		if (password.equals(oldPassword)) {
			password = newPassword;
			failedAttemptsCounter = 0;
			return true;
		}
		else {
			return false;
		}
	}

	public int getFailedAttemptsCounter() {
		return failedAttemptsCounter;
	}
}