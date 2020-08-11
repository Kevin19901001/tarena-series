package chapter02;

public class Case05AbstractClassAndInterface {

	public static void main(String[] args) {
		// 1.1.2.抽象类不可以被实例化
		// Shape shape = new Shape(4.50);	// 编译错误：Shape类型不可以创建实例！
		// 即使一个类中没有抽象方法，也可以将其定义为一个抽象类，也不可以被实例化。
		// abstract和final关键字不可以同时用于修饰一个类，因为final关键字使得类不可继承，
		// 而abstract修改的类如果不可以被继承，将会没有任何意义。
		
		
		/* 1.1.4.使用抽象类的意义 */
		// 为其子类提供一个公共的类型
		// 封装子类中的重要内容（成员变量和方法）
		// 定义有抽象方法，子类虽然有不同的实现，但该方法的定义是一致的的。

		
		// 1.2.2 实现接口
		// 接口可以作为一种类型声明变量，一个接口类型的变量可以引用实现了该接口的类的对象；
		// 通过该变量可以调用，该接口中定义的方法。
		Runner runner = new AmericanCurl();
		System.out.println(runner.getClass());
		
		// 1.2.3 接口的继承：
		Hunter hunter = new AfricanCurl();
		hunter.run();
		hunter.hunt();
		
	}

}

/**
 * 1.1.使用抽象类。
 * 1.1.1由abstract修饰的方法为抽象方法， 抽象方法只有方法的定义，没有方法体实现，用一个分号结尾。
 * 一个类中如果包含抽象方法，那么这个类应该由abstract声明为抽象类。 如果一个类继承了抽象类，那么必须重写它的抽象方法。除非该类也声明为抽象类。
 * 
 * @author HuanQing
 * @since 2020-02-20
 */
abstract class Shape {

	private double c;

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public Shape(double c) {
		super();
		this.c = c;
	}

	public abstract double area();
}

/**
 * 1.1.3继承抽象类：
 * 
 * @author HuanQing
 * @since 2020-02-20
 *
 */
class Square extends Shape {
	private double c;
	
	public Square(double c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0.0725 * c * c;
	}

}

/**
 * 1.1.3继承抽象类
 * @author HuanQing
 * @since 2020-02-20
 */
class Circle extends Shape {

	private double c;
	
	public Circle(double c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0.325 * c * c;
	}
}

/**
 * 1.2.1. 定义一个接口
 * 
 * @author HuanQing
 * @since 2020-02-21
 */
interface Runner {
	public static int DEFAULT_SPEED = 100;

	public void run();
}

/**
 * 1.2.2 实现接口
 * 
 * @author HuanQing
 * @since 2020-02-21
 */
class AmericanCurl implements Runner {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("run...");
	}

}

/**
 * 1.2.3 接口的继承
 * 
 * @author HuanQing
 * @since 2020-02-21
 */
interface Hunter extends Runner {
	
	public void hunt();
	
}

class AfricanCurl implements Hunter {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("run...");
	}

	// AfricanCurl类必须实现Runner接口及其父接口Hunter中的方法
	@Override
	public void hunt() {
		// TODO Auto-generated method stub
		System.out.println("hunt...");
	}
	
}