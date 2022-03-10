package week3.Assignments;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.WebElement;

public class RemovDuplicatesCollections {

	private void usingList() {
		// TODO Auto-generated method stub

	
	// Pseudo code

	// a) Use the declared String text as input

		String text = "We learn java basics as part part of java sessions in java week1 ";
		
	// b) Initialize an integer variable as count
		
		int count = 0;
		String updStr="";
	// c) Split the String into array and iterate over it
		
		
		List<String> list = new ArrayList<>();
		
		for (String str : text.split(" ")) {
			list.add(str);
			
		}
		
		for (int i=0;i<list.size();i++) {
			for (int j=i+1;j<list.size();j++) {
				if(list.get(i).equals(list.get(j))) {
					count++;
					list.set(j," ");
					
				}
				
			}
		}
	
		while (list.contains(" ")){
			list.remove(" ");
			count--;
			
		}
		
		for (String string : list) {
			updStr = updStr+ string +" ";
			
		}
		//System.out.println("No of repeatations in provided string: "+ count);
		System.out.println("New String without duplicates"+"\n"+updStr);
	 
	}
	
	private void usingSet() {

		// a) Use the declared String text as input

			String text = "We learn  java basics as part of java sessions in java week1";
			
		// b) Initialize an integer variable as count
			
			int count = 0;
			String updStr="";
		// c) Split the String into array and iterate over it
						
			Set<String> set = new LinkedHashSet<>();
			
			for (String str : text.split(" ")) {
				if(!set.add(str)) {
					count++;
				}
				else {
					set.add(str);
				}
				
			}
					
			//System.out.println(set);
			
			List<String> list = new ArrayList<>(set);
			//System.out.println(list);
			for (String string : list) {
				updStr = updStr+ string +" ";
				
			}
			
			//System.out.println("No of repeatations in provided string: "+ count);
			System.out.println("New String without duplicates"+"\n"+updStr);
		
	}
	public static void main(String[] args) {
		
		RemovDuplicatesCollections obj = new RemovDuplicatesCollections();
		obj.usingList();
		obj.usingSet();
			
		



	}

}
