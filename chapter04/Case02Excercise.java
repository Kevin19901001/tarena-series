package chapter04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

/**
 * 第4课程第2单元练习
 * @author HuanQing
 * @since 2020-11-25
 */
public class Case02Excercise {

	// 1. 测试构建FOS对象写文件，使用追加和覆盖两种模式
	/** 
	 * 测试覆盖写的方式
	 * @throws Exception
	 */
	@Test
	public void testFos() throws Exception {
		// 实现覆盖写
		// 创建文件字节输出流
//		FileOutputStream fos = new FileOutputStream(new File("fos.dat"));
		FileOutputStream fos = new FileOutputStream("fos.dat");
		
		// 写出一组字节
		fos.write("Hello, World!".getBytes());
		fos.close();
	}
	
	/**
	 * 测试追加写的方式
	 * @throws Exception
	 */
	@Test
	public void testFosByAppend() throws Exception {
//		FileOutputStream fos = new FileOutputStream("fos.dat", true);
		FileOutputStream fos = new FileOutputStream(new File("fos.dat"), true);
		fos.write("\nOho!".getBytes());
		fos.close();
	}
	
	
	
	// 2. 测试构建FIS对象并读取文件数据
	/**
	 * 测试文件输入流的
	 * @throws Exception
	 */
	@Test
	public void testFis() throws Exception {
//		FileInputStream fis = new FileInputStream("fos.dat");
		FileInputStream fis = new FileInputStream(new File("fos.dat"));
		int d = -1;
		while((d = fis.read()) != -1) {
			System.out.print((char)d + " ");
		}
		fis.close();
	}
	
	
	
	// 3. 实现文件复制
	// 使用FileOutputStream类和FileInputStream类实现文件复制。
	// 1. 使用FileOutputStream类的write(int d)方法和FileInputStream类的read()方法复制fos.dat文件为fos_copy1.dat文件。
	// 2. 使用FileOutputStream类的write(byte[] b)和FileInputStream类的read(byte[] b)方法复制fos.dat为fos_copy2.dat文件。
	@Test
	public void testCopy1() throws Exception {
		FileInputStream fis = new FileInputStream("fos.dat");
		FileOutputStream fos = new FileOutputStream("fos_copy1.dat");
		
		int d = -1;
		while((d = fis.read()) != -1) {
			fos.write(d);
		}
		
		fis.close();
		fos.close();
	}
	
	@Test
	public void testCopy2() throws Exception {
		FileInputStream fis = new FileInputStream("fos.dat");
		FileOutputStream fos = new FileOutputStream("fos_copy2.dat");
		
		int length = -1;
		byte[] b = new byte[32];
		while((length = fis.read(b)) != -1) {
			fos.write(b, 0, length);
		}
		
		System.out.println("复制完毕！");
		fis.close();
		fos.close();
	}
	
	
	
	// 4. 实现基于缓存区的文件复制
	/**
	 * 使用BufferedOutputStream和BufferedInputStream实现文件的复制，复制fos.dat为fos_copy3.dat
	 * @throws Exception
	 */
	@Test
	public void testBisAndBos() throws Exception {
		FileInputStream fis = new FileInputStream("fos.dat");
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		FileOutputStream fos = new FileOutputStream("fos_copy3.dat");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		int d = -1;
		
		while((d = bis.read()) != -1) {
			bos.write((char)d);
		}
		
		System.out.println("复制完毕！");
		
		bis.close();
		bos.close();
	}
	
	
	
	// 5. 实现存储Emp的序列化和反序列化
	/**
	 * 使用OOS实现对象的序列化
	 * @throws Exception
	 */
	@Test
	public void testOisAndOos() throws Exception {
		Emp zhangsan = new Emp("张三", 15, '男', 4000.00);
		
		FileOutputStream fos = new FileOutputStream("emp.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(zhangsan);
		System.out.println("序列化完毕！");
		oos.close();
		
		FileInputStream fis = new FileInputStream("emp.obj");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Emp inputZhangsan = (Emp) ois.readObject();
		System.out.println("反序列化完毕！\n" + inputZhangsan);
		
		ois.close();
	}
	
	
	
	// 6. 按照指定编码将文本写入文件
	
}

class Emp implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;
	private char gender;
	private double sal;
	
	public Emp(String name, int age, char gender, double sal) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.sal = sal;
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

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + gender;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(sal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (age != other.age)
			return false;
		if (gender != other.gender)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(sal) != Double.doubleToLongBits(other.sal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + ", age=" + age + ", gender=" + gender + ", sal=" + sal + "]";
	}
}