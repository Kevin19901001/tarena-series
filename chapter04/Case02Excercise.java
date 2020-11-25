package chapter04;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.Test;

/**
 * 第4课程第2单元练习
 * @author HuanQing
 * @since 2020-11-25
 */
public class Case02Excercise {

	// 1. 测试构建FOS对象写文件，使用追加和覆盖两种模式
	@Test
	public void testFos() throws Exception {
		// 实现覆盖写
		// 创建文件字节输出流
		FileOutputStream fos = new FileOutputStream(new File("fos.dat"));
		
		// 写出一组字节
		fos.write("Hello, World!".getBytes());
		fos.close();
		
		
	}
	
}
