package chapter01;

public class Case05OperatorAndExpression {
	
	public static void main(String[] args) {
		// %:
		int n = 225;
		System.out.println(n%8);							// 1
		
		// ++ and --:
		int aa = 10, bb = 20;
		int cc1 = aa++;
		int cc2 = ++bb;
		System.out.println("aa:" + aa + " bb:" + bb + " cc1:" + cc1 + " cc2:" + cc2);	// aa:11 bb:21 cc1:10 cc2:21
		
		// relation operator:
		int max = 10;
		int num = 9;
		boolean b1 = max > 15;
		boolean b2 = num%2 == 1;
		System.out.println(b1);
		System.out.println(b2);
		
		// logic operator:
		int score = 80;
		boolean b = score>=60 && score<=90;
		System.out.println(b);
		
		boolean flag = true;
		int n1 = 200;
		boolean b3 = flag || (n1>0 && n1<100);
		System.out.println(b3);
		
		int x = 100, y = 200;
		boolean b4 = (x > y) && (x++ > 100);			// (x > y> is false, then (x++ > 100) will not be operated
		System.out.println(b4);
		System.out.println(x);
		
		boolean b5 = (x > 0) || (y++ > 200);			// (x > 0) is true , then (y++ > 200) will not be operated
		System.out.println(b5);
		System.out.println(y);
		
		// assignment operator:
		int num1 = 18, index;
		System.out.println(index=num1%5);
		System.out.println(index);

		// +:
		int o = 100;
		String msg = "o=" + o;
		System.out.println(msg);
		msg = "" + 100 + 200;
		System.out.println(msg);						// 100200
		msg = 100 + 200 + "";
		System.out.println(msg);						// 300
		
		// 3 eyes operator:
		int j = 100, k = 200;
		int flag1 = j > k ? 1 : -1;
		System.out.println(flag1);						// -1
	}

}
