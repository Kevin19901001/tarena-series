package chapter02;

public class Case01ObjectAndClass {

	public static void main(String[] args) {
		// Object oriented programming:
		// 1.structure program design:
		
		// 2.abstract data type:
		// Employee:
		// name, age, gender, salary
		
		// 3.class:
//		public class Emp {
//			String name;
//			int age;
//			char gender;
//			double salary;
//		}
		
		
		// Class definition:
//		class ClassName {
//			[member variable type] [variable name]
//		}
		// 1.member variable
		
		// 2.methods of class
		
		
		// Create and use object:
		// 1.use key word 'new' to create object
//		new JFrame();
		
		// 2.reference variable:
//		Cell c = new Cell();
		
		// 3.access member variable of object and call methods:
//		c.raw = 2;
//		c.col = 3;
//		
//		c.drop();
//		c.moveLeft();
		
		// 4.value reference variable:
		Emp e1 = new Emp();
		Emp e2 = e1;
		e1.name = "Steven";
		e2.name = "Koco";
		System.out.println(e1.name);
		System.out.println(e2.name);
		
		
		// 5.Null and NullPionterException:
		// Emp emp = null;
		// emp.setAge(12);	// NullPointerException
		
		
		// practice: pint emp info:
		Emp emp = new Emp();
		emp.name = "Hovered";
		emp.age = 45;
		emp.gender = 'M';
		emp.salary = 4500.00;
		emp.printInfo();
		
		// salary up:
		emp.salary *= 150.0/100;
		emp.printInfo();
	}

}


class Emp {
	String name;
	int age;
	char gender;
	double salary;

	public Emp() {
		super();
	}

	public Emp(String name, int age, char gender, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	/**
	 * print emp info
	 */
	public void printInfo() {
		System.out.println("----------------");
		System.out.println("NAME: " + name);
		System.out.println("AGE: " + age);
		System.out.println("GENDER: " + gender);
		System.out.println("SALARY: " + salary);
	}
	
}