package week3.Assignments;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class FindIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Pseudo Code
		//
		// a) Declare An array for {3,2,11,4,6,7};
		int [] arr1 = {3,2,11,4,6,7};
		int [] arr2 = {1,2,8,4,9,7};
		
		List<Integer> tempList = new ArrayList<>();
		
		List<Integer> list1 = new ArrayList<>();
		
		for (int i : arr1) {
			list1.add(i);
		}
		
		List<Integer> list2 = new ArrayList<>();
		
		for (int j : arr2) {
			list2.add(j);	
			}
		
		for (int int1 : list1) {
			for(int int2:list2) {
				if(int1==int2) {
					tempList.add(int1);
				}	
			}			
		}
		System.out.println(tempList);
		
		// b) Declare another array for {1,2,8,4,9,7};
		// c) Declare for loop iterator from 0 to array length
		// d) Declare a nested for another array from 0 to array length
		// e) Compare Both the arrays using a condition statement
		// f) Print the first array (shoud match item in both arrays)
		//

	}

}
