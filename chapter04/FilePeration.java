package chapter04;

import java.io.File;
import java.io.FileFilter;

import org.junit.Test;

public class FilePeration {

	// 1. 文件操作 File
	// 1.1. File表示目录信息
	// 1.1.1. 【File表示目录信息】listFiles()方法
	// File的listFile()方法用于返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的子项（文件或目录）。
	// File[] listFiles()：返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件或目录。
	// 如果目录为空，那么数组也将为空。
	// 如果抽象路径名不表示一个目录，或者发生I/O错误，则返回null。
	
	// 1.1.2. 【File表示目录信息】FileFilter接口
	// FileFilter用于抽象路径名的过滤器
	// 此接口的实例可传递给File类的listFiles(FileFilter)方法。用于返回满足该过滤器要求的子项。
	// File[] listFiles(FileFilter filter)：
	
	@Test
	public void testFileFilter() {
		File dir = new File(".");
		File[] files = dir.listFiles(new FileFilter() {

			@Override
			public boolean accept(File file) {
				// TODO Auto-generated method stub
				return file.getName().endsWith(".txt");
			}});
		
		for(File file : files) {
			System.out.println(file);
		}
	}
	
}
