package chapter02;

/**
 * 多态和内部类
 * 
 * @author HuanQing
 * @since 2020-02-22
 */
public class Case06PolymophicAndInnerClass {

	public static void main(String[] args) {
		/**
		 * 1.1 多态: 1.1.1 多态的意义： 一个类型的引用在指向不同的对象时会有不同的实现； 同一个对象，造型成不同的类型时，会有不同的功能。
		 */
		Player bp = new BasketballPlayer();
		Player co = new Coach();
		bp.play();
		co.play();

		/**
		 * 1.1.2 向上造型： 一个类的对象可以向上造型的类型有： 父类的类型、它所实现的接口的类型。 Java编译器根据类型检查方法调用是否正确。
		 */

		/**
		 * 1.1.3 强制转型： 可以通过强制转换将父类型变量转换成子类型变量， 前提是该变量指向的对象确实是该子类类型。
		 * 也可以通过强制转换将变量转换为某种接口类型， 前提是该变量指向的对象确实实现了该接口。 如果在强制转换过程中违背了上述两个前提，
		 * 将会抛出ClassCastException。
		 */

		/**
		 * 1.1.4 instanceof关键字： 在强制转型中，为了避免出现ClassCastException，
		 * 可以通过instanceof关键字判断某个引用指向的对象是否为指定类型。
		 */
		System.out.println(bp instanceof Player);
		System.out.println(co instanceof Player);
		System.out.println(bp instanceof BasketballPlayer);
		System.out.println(co instanceof Coach);

		/**
		 * 1.2 内部类
		 *
		 * 1.2.2 创建内部类对象
		 */
		Outer outer = new Outer(100);
		outer.printTime();				// 101
	}

}

/**
 * 1.1.1 多态的意义
 * 
 * @author HuanQing
 * @since 2020-02-22
 */
interface Player {
	void play();
}

/**
 * 1.1.1 多态的意义
 * 
 * @author HuanQing
 * @since 2020-02-22
 */
class BasketballPlayer implements Player {

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("playing basketball...");
	}

}

/**
 * 1.1.1 多态的意义
 * 
 * @author HuanQing
 * @since 2020-02-22
 */
class Coach implements Player {

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("coaching player...");
	}

}

/**
 * 1.2.1 定义成员内部类 一个类可以定义在另一个类的内部，定义在类内部的类称之为Inner，其所在的类称为Outer。
 * Inner在Outer的内部。通常只服务于Outer，对外部不具备可见性，Inner可以直接调用Outer的成员及方法（包括私有的）。
 * 
 * @author HuanQing
 * @since 2020-02-23
 */
class Outer {
	private int time;

	private Inner inner;

	/**
	 * 构造器
	 * 
	 * @param time
	 */
	public Outer(int time) {
		super();
		this.time = time;
		this.inner = new Inner();
		inner.timeInc();
	}

	/**
	 * 打印时间
	 */
	public void printTime() {
		System.out.println(time);
	}

	/**
	 * 内部类
	 * 
	 * @author HuanQing
	 * @since 2020-02-23
	 */
	class Inner {
		public void timeInc() {
			time++;
		}
	}
}

/**
 * 1.2.2 定义匿名内部类
 * 
 * @author HuanQing
 * @since 2020-02-23
 */
interface Action {
	public void exec();
}

/**
 * 1.2.2 如果在一段程序中，需要创建一个类的对象（通常这个类需要继承某个接口或者实现某个类），
 * 而且创建对象后，这个类的价值也就不存在了，这个类可以不必命名，称为匿名内部类。
 * 
 * @author Administrator
 * @since 2020-02-23
 */
class Main {

	public static void main(String[] args) {
		Action action = new Action() {

			@Override
			public void exec() {
				// TODO Auto-generated method stub
				System.out.println("In anonymous inner class, override unimplemented methdo!");
			}

		};

		action.exec();
	}

}