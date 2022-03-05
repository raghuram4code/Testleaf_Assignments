package week2.day1.assignments.strings;

public class CharOccurance {

	public static void main(String[] args) {
		// Check number of occurrences of a char (eg 'e') in a String

		String str = "welcome to chennai";
		char chkstr = 'e';

		// declare and initialize a variable count to store the number of occurrences
		int count =0;
		// convert the string into char array
		char[] charstr=str.toCharArray();

		// get the length of the array
		int arrCharLent =charstr.length;

		// traverse from 0 till the array length
		for (int i=0; i<arrCharLent;i++) {
			// Check the char array has the particular char in it
			if (charstr[i]==chkstr) {
				// if is has increment the count
				count++;
			}
			
		}

		// print the count out of the loop
		if(count>0) {
		System.out.println("The number of occureneces of the character "+ chkstr+" in given string "+ str+" is "+ count);
		}
		else {
		System.out.println("The chararcter "+chkstr+" is not available in given string "+str);
		}

	}

}
