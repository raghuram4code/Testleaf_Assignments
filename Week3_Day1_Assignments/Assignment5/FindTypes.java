package week2.day1.assignments.strings;

public class FindTypes {

	public static void main(String[] args) {
		// Here is the input
		String test = "$$ Welcome to 2nd Class of Automation $$ ";

		// Here is what the count you need to find
		int  letter = 0, space = 0, num = 0, specialChar = 0;

		// Build the logic to find the count of each

		// a) Convert the String to character array
		//char[] testArray = test.toCharArray();
		// b) Traverse through each character (using loop)
		for (int i=0;i<test.length();i++)
		{
			// c) Find if the given character is what type using (if)
			// i) Character.isLetter
			if (Character.isLetter(test.charAt(i))) {
				letter++;
			}	
			// ii) Character.isDigit
			else if(Character.isDigit(test.charAt(i))){
				num++;
			}	
			// iii)Character.isSpaceChar
			else if(Character.isSpaceChar(test.charAt(i))) {
				space++;
			}
			// iv) else -> consider as special character
			else {
				specialChar++;
				}
		}
		// Print the count here
		System.out.println("letter: " + letter);
		System.out.println("space: " + space);
		System.out.println("number: " + num);
		System.out.println("specialCharcter: " + specialChar);

		
	}

}
