package org.studentinfo;

public class Students {
	
	public void getStudnetInfo(int id) {
	 
		System.out.println("Student id is "+id);

	}
	
	
	public void getStudnetInfo(int id, String name) {
		System.out.println("Student with id "+ id+" name is "+ name);

	}

	
	public void getStudnetInfo(String email, long phnum) {
		
		System.out.println("Student email is "+email+" and phonenumber is "+phnum);

	}

	public static void main(String[] args) {
		
		int id = 3456;
		String name = "Raghuram", email ="Sample@gmail.com";
		Long phnum = 9884516666L;
		
		Students objStudents = new Students();
		objStudents.getStudnetInfo(id);
		objStudents.getStudnetInfo(id, name);
		objStudents.getStudnetInfo(email, phnum);
	}
}
