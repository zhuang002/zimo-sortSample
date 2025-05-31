package sortSample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] dArray = {1.2, 1.4 ,3.5, 2.3, 0.7, 1.0,2.1};
		
		Arrays.sort(dArray);
		for (double d:dArray) {
			System.out.print(""+d+' ');
		}
		System.out.println();
		
		ArrayList<String> sArray = new ArrayList<>();
		sArray.add("John");
		sArray.add("Alice");
		sArray.add("Marx");
		sArray.add("Savid");
		sArray.add("Derek");
		sArray.add("Mary");
		
		Collections.sort(sArray);
		
		for (String s:sArray) {
			System.out.print(s+" ");
		}
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Student[] students = new Student[n];
		
		for (int i=0;i<n;i++) {
			Student student = new Student(sc.next(),sc.next(), 
					new Date(sc.nextInt(), sc.nextInt(),sc.nextInt()),
					sc.next(), sc.next());
			
			
			students[i] = student;
		}
		
		for (Student student:students) {
			System.out.println(student);
		}
		
		
		System.out.println("=====Sort order by name======");
		
		Arrays.sort(students, (x,y)->{
			return x.name.compareTo(y.name);
		});
		for (Student student:students) {
			System.out.println(student);
		}
		
		
		System.out.println("=====Sort order by id======");
		
		Arrays.sort(students, (x,y)->{
			return x.ID.compareTo(y.ID);
		});
		
		for (Student student:students) {
			System.out.println(student);
		}
		
		System.out.println("=====Sort order by birthDate======");
		
		Arrays.sort(students, (x,y)->{
			if (x.birthDate.year<y.birthDate.year) return -1;
			if (x.birthDate.year>y.birthDate.year) return 1;
			if (x.birthDate.month<y.birthDate.month) return -1;
			if (x.birthDate.month>y.birthDate.month) return 1;
			if (x.birthDate.day<y.birthDate.day) return -1;
			if (x.birthDate.day>y.birthDate.day) return 1;
			return 0;
		});
		
		for (Student student:students) {
			System.out.println(student);
		}
		
		System.out.println("=====Sort order by age======");
		
		Arrays.sort(students, (x,y)->{
			if (x.birthDate.year<y.birthDate.year) return 1;
			if (x.birthDate.year>y.birthDate.year) return -1;
			if (x.birthDate.month<y.birthDate.month) return 1;
			if (x.birthDate.month>y.birthDate.month) return -1;
			if (x.birthDate.day<y.birthDate.day) return 1;
			if (x.birthDate.day>y.birthDate.day) return -1;
			return 0;
		});
		
		for (Student student:students) {
			System.out.println(student);
		}
		
		
		
		
	}

}


class Human {
	
	String name;
	String gender;
	Date birthDate;
	String nationality;
	
	
	public Human(String name, String gender, Date birthDate, String nationality) {
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.nationality = nationality;
	}
	
	

	@Override
	public String toString() {
		return this.name+" "+this.gender+" " + this.birthDate
			+" "+this.nationality;
	}
	
}

class Date {
	int year;
	int month;
	int day;
	
	// constructor
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.year+" "+this.month+" " +this.day;
	}
}

class Student extends Human {
	String ID;
	
	public Student(String name, String gender, Date birthDate, String nationality, String id) {
		super(name,gender,birthDate,nationality);
		this.ID = id;
	}
		
	@Override
	public String toString() {
		return super.toString()+" "+this.ID;
	}
}
