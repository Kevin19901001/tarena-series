package chapter01;

public class Case03JavaVariable {

	public static void main(String[] args) {
		
		int a = 5;
		int b = 6;
		int c = a + b;
		System.out.println(c);
		
		int x = 1, y = 2;
		int z = x + y;
		System.out.println(z);
		
		int m,n = 3;				// n has been valued 3, but m has not been valued
		m = 3;
		int o = m + n;
		System.out.println(o);
		
		int sum;
		sum = 0;
		sum = sum + 100;
		System.out.println(sum);
	}

}
