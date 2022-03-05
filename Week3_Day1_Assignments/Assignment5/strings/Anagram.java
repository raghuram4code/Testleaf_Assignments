package week2.day1.assignments.strings;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		
		// Pseudo Code
		// Declare a String
		String text1 = "stops";
		// Declare another String
	    String text2 = "potsa";
	    String temp ="";
	    
	    boolean flag = true;
		// a) Check length of the strings are same then (Use A Condition)
	    if (text1.length()==text2.length()) {
			// b) Convert both Strings in to characters
	    	char[] charArrayTxt1 = text1.toCharArray();
	    	char[] charArrayTxt2 = text2.toCharArray();
	    	
			// c) Sort Both the arrays
	    	Arrays.sort(charArrayTxt1);
	    	Arrays.sort(charArrayTxt2);
	    	
			// d) Check both the arrays has same value
	    	
	    	for (int i=0;i<charArrayTxt1.length;i++) {
	    		if(!(charArrayTxt1[i]==charArrayTxt2[i])) {
	    			 flag = false;
	    			 temp = temp +charArrayTxt2[i] ;
	    		}
	     	}
	    	if (flag) {System.err.println("Strings are Anagram");}
	    	else {System.out.println("Both strings are not Anagram even lengths are matching and differnt variable in txt 2 is "+ temp);}
	    		
	    }	    
	    else {
	    	System.out.println("Strings are not Anagram");
	    }
		 

	}

}
