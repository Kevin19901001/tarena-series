package chapter04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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
}
