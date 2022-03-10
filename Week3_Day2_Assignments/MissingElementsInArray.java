package week3.Assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class MissingElementsInArray {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,7,6,9};
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		for (int arr1 : arr) {
			list1.add(arr1);
			
		}
		Collections.sort(list1);
				
		for (int i=0;i<list1.size();i++) {
			//System.out.println(i);
			if(i+1!=list1.get(i)) {
				System.out.println(i+1);
				break;
			}
		}
		System.out.println(list1);

	}

}
