/*
 * Author:  Hong Zhang
 * File:    Faculty.java
 * Date:    03/17/2014
 * Descr:
 * In-class exercise to demonstrate class inheritance.
 */

// Person class that is parent class
class Person {
	// instance variable
	private int id;
	
	// person no-arg constructor
	/*
	public Person() {
		System.out.println("Person no-arg constructor");
	}
	*/
	
	// person parameterized constructor
	public Person(int id) {
		this.id = id;
		System.out.println("Person parameter constructor");
	}
	
	// method to create String representation of a person object
	/*public String toString() {
		return String.format("\n\tThis is a person object with ID %5d", id);
	}
	*/
	
	// override equals method to test for object equality
	public boolean equals(Object o) {
		// test to see if Person object before comparing 
		if (o instanceof Person) {
			return this.id == ((Person)o).id;	
		}
		else 
			return false;		
	}
}

// Employee class that inherits from Person
class Employee extends Person {
	// instance attribute
	private String dept;
	
	// employee no-arg constructor
	public Employee() {
		// error when superclass does not have no-arg constructor; 
		// must explicitly call parameterized constructor
		super(222); 
		System.out.println("Employee no-arg constructor");
	}
	// employee parameter constructor
	public Employee(String dept){
		super(333);
		this.dept = dept;
		System.out.println("Employee parameter constructor");
	}
	
	// method to create string representation of employee object
	public String toString() {
		return String.format("\n\tThis is an employee object in %s dept %s", 
				dept, super.toString());
	}
}

// Faculty class that inherits from Employee
public class Faculty extends Employee {
	// instance attribute
	private String[] courses;
	
	// faculty no-arg constructor
	public Faculty() {
		System.out.println("Faculty no-arg constructor");
	}
	
	// faculty parameter constructor
	public Faculty(String... classes){
		// see if any values passed
		if(classes.length != 0) {
			// copy array to courses
			// create array ref of appropriate size
			courses = new String[classes.length];
			System.arraycopy(classes, 0, courses, 0, classes.length);
		}
		System.out.println("Faculty parameter constructor");
	}
	
	// method to create string representation of faculty object
	public String toString() {
		return String.format("\n\tThis is a faculty object teaching courses %s %s",
				java.util.Arrays.toString(courses), super.toString());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Creating a new faculty object...");
		Faculty f1 = new Faculty("CIS1400", "CIS2541", "CIS2571");
		System.out.println("Here is your faculty object..." + f1.toString());
		
		System.out.println("Creating a new employee object...");
		Employee e1 = new Employee();
		System.out.println("Creating a new person object...");
		Person p1 = new Person(111);
		
		// testing put whether object are 'equal'
		Person p2 = new Person(111);
		if (p1 == p2)
			System.out.println("p1 == p2");
		else 
			System.out.println("p1 != p2");
		if (p1.equals(p2))
			System.out.println("p1 equal p2");
		else 
			System.out.println("p1 DOES NOT equal p2"); 
		// polymorphism -- have subclass objects passed to 
		// method requiring superclass object
		display(f1);
		display(e1);
		display(p1);
		// create array of objects 
		Object [] objArray = {e1, f1, p1};
		for (int i = 0; i< objArray.length; i++) {
			// dynamic binding will call appropriate method 
			display(objArray[i]);
		}
	}

	// generic method to display passed object
	public static void display(Object x) {
		System.out.println("Your object is " + x);
	}
}


