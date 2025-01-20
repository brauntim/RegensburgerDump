package uebung_3_03;

public class ArrayEquality {
	public static void main(String[] args) {
		// array init
		int[] arr1 = { 1, 2, 4 };
		int[] arr2 = { 1, 2, 4 };

		String[] arr3 = { "hello", "world", "test" };
		String[] arr4 = { "hello", "world", "lol" };

		// check array for equality
		if (arraysEqual(arr1, arr2)) {
			System.out.println("Integer-Arrays stimmen ueberein");
		}
		else {
			System.out.println("Integer-Arrays stimmen nicht ueberein");
		}

		if (arraysEqual(arr3, arr4)) {
			System.out.println("String-Arrays stimmen ueberein");
		}
		else {
			System.out.println("String-Arrays stimmen nicht ueberein");
		}
	}

	// Method to compare int-arrays
	public static boolean arraysEqual(int[] arr1, int[] arr2) {
		// if one of the arrays is null or if the diff in length, they are already not
		// equal.
		if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
			return false;
		}
		else {
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i] != arr2[i]) {
					// comparing each element. if one is not equal, we return false
					return false;
				}
			}
			// if every element is equal, we return true.
			return true;
		}
	}

	// Methods can have the same name, as long the differ in their params. This
	// method is for string-arrays
	public static boolean arraysEqual(String[] arr1, String[] arr2) {
		// if one of the arrays is null or if the diff in length, they are already not
		// equal.
		if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
			return false;
		}
		else {
			for (int i = 0; i < arr1.length; i++) {
				if (!(arr1[i].equals(arr2[i]))) {
					// comparing each element. if one is not equal, we return false
					return false;
				}
			}
			// if every element is equal, we return true.
			return true;
		}
	}
}
