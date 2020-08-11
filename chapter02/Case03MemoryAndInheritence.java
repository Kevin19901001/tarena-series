package chapter02;

import javax.swing.JFrame;

import utils.Foo;

/**
 * To talk about Java memory mamangement and inheritance:
 * @author HuanQing
 * @since 2020-02-14
 */
public class Case03MemoryAndInheritence {

	public static void main(String[] args) {
		// 1.Obejct memory management:
		// JVM memory: heap, stack, method area
		// Objects in the heap;
		// GC: Garbage Collection;
		// System.gc();
		
		// Local variable in stack;

		// Member variable and local variable:
		// Local variable: defined in method, without default value, must be inited when defining;
		// Existed int stack and was cleared after method calling.
		
		// Member variable: defined in class, out of method, with defaut value;
		// existed in heap when create object of class.
		
		// Method area: store class info;
		// Just one method:
		JFrame jf1 = new JFrame();
		JFrame jf2 = new JFrame();
		jf1.setSize(200, 300);
		jf2.setSize(400, 500);
		
		
		// Super reference refer to sub object:
		Foo foo = new Goo(10);
		
		// Reference of super class can refer to object of sub class,
		// but this reference can access members of super class only, 
		// can not access those in sub class
		// foo.num = 5;	// Syntax error!
		// foo.g();		// Syntax error!
		foo.f();		// method foo()
	}

}


// 2.Inheritance:
// Keyword 'extends':
class Animal {
	public Animal() {}
}

class Cat extends Animal {
	public Cat() {}
}

/**
 * Sub class extends supuer class,
 * it has to add a constructor from super class,
 * by method super(*args).
 * @author HuanQing
 * @since 2020-02-15
 */
class Goo extends Foo {

	int num;
	
	public Goo(int value) {
		super(value);
	}
	
	public Goo(int value, int num) {
		super(value);
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void g() {
		System.out.println("method g()");
	}
	
}

