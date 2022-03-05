package week2.day1.assignments.strings;

public class ReverseEvenWords {

	public static void main(String[] args) {
		//Build a logic to reverse the even position words (output: I ma a erawtfos tester)

		// Pseudo Code:
	
		// Declare the input as Follow
		 String test = "I am a software tester",  newStr ="";
		// a) split the words and have it in an array
		 String [] splitStr = test.split(" ");
		// b) Traverse through each word (using loop)
		 for (int i=0;i<splitStr.length;i++) {
			// c) find the odd index within the loop (use mod operator)
			 if(i%2==1) {
				 String tempStr="";
				// d)split the words and have it in an array
				 char[] wordArray= splitStr[i].toCharArray();
				 for (int j= wordArray.length-1;j>=0;j--) {
					 tempStr = tempStr+wordArray[j];
				 }
				 newStr = newStr+tempStr+" ";
				 System.out.print(tempStr +" ");
			 }
			 else {
			 newStr = newStr + splitStr[i]+" ";
			 System.out.print(splitStr[i]+ " ");
			 }
		 }
		System.out.println();
		System.out.println(newStr);
		
	

	}

}
