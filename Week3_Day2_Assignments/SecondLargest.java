package week3.Assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SecondLargest {
	public static void main(String[] args) {
			int[] data = {3,2,11,4,45,7,58,34};
			/*
			 Pseudo Code:
			 1) Arrange the array in ascending order
			 2) Pick the 2nd element from the last and print it
			 */
			List <Integer> list1 = new ArrayList<>();
			Set<Integer> set = new TreeSet<>();
			for (int i : data) {
				list1.add(i);
				set.add(i);
			}
			
			List<Integer> setList  = new ArrayList<>(set);
			Collections.sort(list1);
			System.out.println(list1);
			System.out.println("The second largest number in given array is:");
			System.out.println(list1.get(list1.size()-2));
			System.out.println(list1.get(setList.size()-2));
			
				
	}

}
