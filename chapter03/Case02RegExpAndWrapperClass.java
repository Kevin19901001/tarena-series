package chapter03;

import java.util.Arrays;

import org.junit.Test;

public class Case02RegExpAndWrapperClass {

	public static void main(String[] args) {
		// 1. 正则表达式
		// 1.1 基本正则表达式
		// 1.1.1 正则表达式简介：
		// “[a-z]”表示'a'到'z'的任意一个字符；
		// “[a-z]+”表示由1个或多个a-z字符组成的字符串；
		// “[abc]”表示abc中任意一个字符；
		// “{^abc}”表示出abc之外的任意字符；
		// “[a-zA-Z0-9]”表示a~z、A~Z、0～9中任意一个字符；
		//  “[a-z&&[^bc]]”表示a~z中除了bc外的任意一个字符；
		// “.”表示任意一个字符；
		// “\d”任意一个数字字符，相当于[0-9]；
		//  “\w”单词字符，相当于[a-zA-Z0-9_]；
		// “\s”表示空白字符，相当于：[\t\n\x0B\f\r]
		// “\D”表示非数字字符；
		// “\W”表示非单词字符；
		// “\S”表示非空白字符；
		// “X?”表示0个或1个X；
		// “X*”表示0个或多个X；
		// “X+”表示1个或多个X；
		// “X{n}”表示n个X；
		// “X{n, }”表示n到任意多个X；
		// “X{n, m}”表示n到m个X
		// 检索邮政编码：\d{6}
		
		// 1.1.2 分组()：()表示分组，可以将一系列正则表达式看作是一个整体，分组时可以使用“|”表示“或”关系。
		// 匹配手机号码前面的区号：(+86|0086)?\s?\d{11}

		// 1.1.3 ^和$：
		// ^代表字符串开始
		// $代表字符串结尾
		// 匹配用户名规则-从头到尾连续8~10个单词字符：
		System.out.println("abcd1234_abcd".matches("^\\w{8,10}$"));		// true
		System.out.println("abcd1234_abcd".matches("\\w{8,10}"));			// false
		
		
		// 2. Object
		// 2.1 Object
		// 2.1.1 Object：在Java类继承结构中，java.lang.Object类位于顶端。如果定义一个Java类时，没有使用extends关键字声明其父类，则其父类默认为java.lang.Object类。
		// Object类型的引用变量可以指向任何类型的对象。
		
		// 2.2 toString()方法
		// 2.2.1 如何重写toString()方法：Object类中的重要方法，用来表示对象值的字符串表示；原则上建议重写，格式大多数遵循“类的名字[域值]”
		
		// 2.2.2 String重写toString()方法：
		// public String toString() {
		//	 return this;
		// }
		// Java语言中很多地方会默认调用对象的toString()方法：1、字符串+对象，自动调用对象的toString()方法；2、System.out.println(对象)，自动调用对象的toString()方法
		// 如果不重写toString()方法，将使用Object的toString()方法，其逻辑为类名+散列码。
		// toString()方法是非常有用的调试工具；
		// 强烈建议为自定义的所有类添加toString()方法。
		
		// String的toString()方法，就是将其自身返回：
		// public String toString() {
		// 	return this;
		// }
		
		
		// 2.3 equals()方法：
		// 2.3.1 equals()方法是Object中，用于检测一个对象是否等于另一个对象的方法。在Object类中，这个方法判断两个对象是否具有相同的引用，即是否为相同的对象。
		// 在实际应用中，一般需要重写该方法，通过比较对象的成员属性，使该方法更有意义。
		
		// 2.3.2 如何重写equals()方法：
		//public boolean equals(Object obj) {
		//	if() {
		//		return false;
		//	}else if() {
		//		return false;
		//	}else {
		//		return true
		//	}
		//}
		
		// 2.3.3 String重写equals()方法：
		//public class Demo{
		//	public static void main(String[] args) {
		//		String s1 = "abc";
		//		String s2 = "abc";
		//		String s3 = "ABC";
		//		
		//		System.out.println(s1.equals(s2));	// true
		//		System.out.println(s1.equals(s3));	// false
		//	}
		//}
		
		// 2.3.4 equals()和==的区别：
		// ==用于比较变量的值，可以应用于任何类型。如果用于引用类型，比较的是两个引用变量中存储的值（地址信息），判断两个变量是否指向相同的对象。
		// equals()是Object的方法，重写以后，可用用于比较两个对象的“内容”是否相等；
		// 需要注意的是，Object默认的equals()方法的比较规则同==
		
		
		// 3. 包装类
		// 3.1 包装类概述
		// 3.1.1 包装类概述
		// 在进行类型转换的范畴内，有一种特殊的转换，需要将int这样的基本数据类型转换为对象。
		// 所有的基本类型都有一个与之对应的类，即包装类。
		// 包装类是不可变类，在构造了包装类对象后，不允许改变包装在其中的值；
		// 包装类是final的，不能定义它们的子类。
		// int => java.lang.Integer
		// long => java.lang.Long
		// double => java.lang.Double
		// float => java.lang.Float
		// short => java.lang.Short
		// byte => java.lang.Byte
		// char => java.lang.Character
		// boolean => java.lang.Boolean
		
		
		// 3.2 8种基本类型包装类
		// 3.2.1 Number及其主要方法
		// 抽象类Number是Byte, Double, Float, Integer, Short和Long类的父类。
		// Number的子类必须提供将表示的数值转换为byte, double, float, int, long和short的方法。
		
	}
	
	/**
	 * 1.2 String正则API：
	 * 1.2.1 match(String regexp)方法
	 */
	@Test
	public void email() {
		String emailRegexp = "^[a-zA-Z0-9_.-]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z0-9] {2,4}$";
		String email = "abc@souhu.com.cn";
		System.out.println(email.matches(emailRegexp));								// true
	}
	
	/**
	 * 1.2.2 String[] split(String regexp)方法
	 */
	@Test
	public void testSplit() {
		// 按空格拆分
		String langs = "java cpp php c# objective-c";
		String[] langsArr = langs.split("\\s");
		System.out.println(Arrays.toString(langsArr));
		
		// 按"+"、"-"、"="拆分
		String line = "100+200-150-150";
		String[] arr = line.split("[\\+\\-=]");
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 1.2.3 String replaceAll(String regexp, String replacement)方法
	 */
	@Test
	public void testReplaceAll() {
		String words = "abc123def456ghi89";
		String newWords = words.replaceAll("\\d+", "数字");
		System.out.println(newWords);
	}
	
	/**
	 * 3.2.1 Number及其主要方法
	 */
	@Test
	public void testIntValueAndDoubleValue() {
		Number d = 123.45;
		Number n = 123;
		
		// 输出d和n对象所属的类型：
		System.out.println(d.getClass().getName());	// java.lang.Double
		System.out.println(n.getClass().getName());	// java.lang.Integer
		
		int intValue = d.intValue();
		double doubleValue = d.doubleValue();
		System.out.println(intValue + " , " + doubleValue);	// 123 , 123.45
		
		intValue = n.intValue();
		doubleValue = n.doubleValue();
		System.out.println(intValue + " , " + doubleValue);	// 123 , 123.0
	}
	
	/**
	 * 3.2.2 Integer常用功能
	 * 该类提供了多个方法，能在int和String类型之间相互转换，还提供了一些常量如：static int MAX_VALUE，static int MIN_VALUE
	 */
	@Test
	public void testParseInt() {
		String str0 = "123";
		int value0 = Integer.parseInt(str0);
		System.out.println(value0);							// 123
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		//String str1 = "一百二十三";
		//int value1 = Integer.parseInt(str1);				// java.lang.NumberFormatException
		//System.out.println(value1);
	}
	
	/**
	 * 3.2.3 Double常用功能
	 * double doubleValue()返回此Double对象的double值
	 * static double parseDouble(String s)返回一个新的double值，该值被初始化为用指定的String表示的值
	 */
	@Test
	public void testParseDoubleValue() {
		String s1 = "";
		double value = Double.parseDouble(s1);
		System.out.println(value);
		
		//s1 = "$12345.00";
		//value = Double.parseDouble(s1);						// NumberFormatException
	}
	
	/**
	 * 3.2.4 自动装箱和拆箱操作
	 * 从Java5.0版本以后加入到了autoboxing功能
	 * 自动装箱和拆箱的功能是依靠JDK5的编译器在编译期的预处理工作
	 */
	public void testAutoBoxing() {
		Integer a = 100;		// 装箱
		Integer b = 200;		// 装箱
		Integer c = a + b;		// 拆箱再装箱
		@SuppressWarnings("unused")
		double d = c;			// 拆箱
	}
}
