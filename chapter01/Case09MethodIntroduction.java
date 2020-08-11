package chapter01;

public class Case09MethodIntroduction {

	public static void main(String[] args) {
		// 3.method calling:
		int sum = sum(5, 6);
		System.out.println("sum:" + sum);

		say("Hello, world!");
	}

	// 1.method:
	public static int sum(int num1, int num2) {
		return (num1 + num2);
	}

	// 2.method definition:
	static void say(String letters) {
		System.out.println(letters);
	}

}
