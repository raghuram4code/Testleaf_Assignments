package week3.Assignments;

import java.util.ArrayList;
import java.util.List;

public class PrintDuplicatesInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {14,12,13,11,15,14,18,16,17,19,18,17,20};
		int count =0;
		int lenOfArr = arr.length;
		System.out.println(lenOfArr);
		
		List<Integer> list = new ArrayList<>();
		List<Integer> templist = new ArrayList<>();
		for (int i=0;i<lenOfArr;i++) {
			list.add(arr[i]);
		}
		System.out.println(list);
		
		for (int  element=0; element<lenOfArr-1;element++) {
			for(int i=element+1;i<lenOfArr;i++) {
				if(list.get(element)==arr[i]) {
					count++;
					templist.add(list.get(element));
				}
				
			}
		}
		System.out.println(templist);
	}

}
