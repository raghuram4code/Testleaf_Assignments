package week2.day1.assignments.strings;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;

public class Palindrome {

	public static void main(String[] args) {

		// Pseudo Code
		// a) Declare A String value as"madam"
		String value = "madam";
		
		// b) Declare another String rev value as ""
		String revValue = "";
		// c) Iterate over the String in reverse order
		char[] charArray = value.toCharArray();
		
		for (int i = (charArray.length) - 1; i >= 0; i--) {
			// d) Add the char into rev
			revValue = revValue+(charArray[i]);
			
		}

		if (revValue.equalsIgnoreCase(value)) {
			System.out.println("Given string is palindrome");
		}
		// e) Compare the original String with the reversed String, if it is same then
		// print palinDrome

		// Hint: Use .equals or .equalsIgnoreCase when you compare a String

	}

}
