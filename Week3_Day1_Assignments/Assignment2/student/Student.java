package org.student;

import org.department.Department;

public class Student extends Department {
	
	private String studentName() {
		String studentName = "Kalam";
		return studentName;

	}
	
	public String studentDept() {
		// TODO Auto-generated method stub
		String dep =this.depName();
		return dep;
	}
	
	private String studentId() {
		// TODO Auto-generated method stub
		String id="345678";
		return id;
	}


	public static void main(String[] args) {
		
		Student objStudent = new Student();
		
		System.out.println(objStudent.studentName() + " bearing ID  " + objStudent.studentId() + " is studying "
				+ objStudent.studentDept() +" in " + objStudent.collgeName()+" with id " + objStudent.collegeCode() +" which is at "
				+ objStudent.CollegeRank()+"th Rank.");
	}

}
