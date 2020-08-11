package chapter01;

public class Case04JavaBasicDataType {

	public static void main(String[] args) {
		
		// There are 8 kinds of data type in java:
		
		// int: -2^31 ~ 2^31
		int a = 100000;
		int b = 0x168a0;
		int c = 0303240;
		System.out.println(a + b + c);
		
		int i = 5/3;
		System.out.println(i);
		
		int total = 87;
		int error = 23;
		int percent = error/total*100;
		System.out.println(percent);
		
		percent = 100*error/total;
		System.out.println(percent + "%");
		
		// long: -2^63 ~ 2^63-1
		long l2 = 10000000000l;
		
		long distance1 = 10000 * 365 * 24 * 60 * 60;
		System.out.println("distance1: " + distance1);
		System.out.println(distance1 + l2);
		
		long time = System.currentTimeMillis();
		System.out.println(time);
		
		//double:
		double pi = 3.14;
		double r = 8;
		double s = pi * r * r;
		System.out.println(s);
		
		double money = 3.0;
		double price = 2.9;
		System.out.println(money - price);				// 0.10000000000000009
		
		// char:
		char c1 = '中';
		char c2 = '\u4e2d';
		System.out.println(c1);
		System.out.println(c2);
		
		char c3 = 65;
		char c4 = 'A';
		char c5 = '\u0041';
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		
		char c6 = '\\';
		System.out.println(c6);							// \
		
		// boolean:
		int age = 18;
		boolean isChild = age<16;
		System.out.println(isChild);
		
		// data type transformation:
		int i1 = 100;
		int i2 = 100;
		long ll1 = i1 + i2;
		System.out.println(ll1);
		
		long ll2 = 1024;
		int i3 = (int)ll2;
		System.out.println(i3);								// 1024
		
		long ll3 = 1024 * 1024 * 1024 * 4L;
		int i4 = (int)ll3;
		System.out.println(i4);								// 0(overflow)
		
		double d1 = 3.1415926535897932384;
		float f1 = (float)d1;
		System.out.println(f1);							// 3.1415927(precision lost)
		
		// auto transformation:
		long distance2 = 10000 * 365 * 24 * 60 * 60 * 299792458l;
		System.out.println(distance2);
		
		double change = 800 - 299.0;
		System.out.println(change);
		
		double persent = 80/100;
		System.out.println(persent);						// 0.0
		
		double persent2 = 80.0/100;
		System.out.println(persent2);						// 0.8
		
		// %:
		int n = 225;
		System.out.println(n%8);							// 1
		
		// ++ and --:
		int aa = 10, bb = 20;
		int cc1 = aa++;
		int cc2 = ++bb;
		System.out.println("aa:" + aa + " bb:" + bb + " cc1:" + cc1 + " cc2:" + cc2);	// aa:11 bb:21 cc1:10 cc2:21
	}

}
