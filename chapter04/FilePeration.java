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
	
	
	// 2. RandomAccessFile
	// 2.1. 创建对象
	// 2.1.1. 【创建对象】简介
	// Java提供了一个可以对文件随机访问的操作，访问包括度和写操作。该类名为RandomAccessFile。该类的读写时基于指针的操作。
	
	// 2.1.2. 【创建对象】只读模式
	// RandomAccessFile在对文件进行随机访问操作时有两个模式分别为只读模式和读写模式。
	// 只读模式：在创建RandomAccessFile时，其提供的构造方法要求我们传入访问模式：
	// RandomAccessFile(File file, String mode)
	// RandomAccessFile(String fileName, String mode)
	// 其中狗仔方法的第一个参数是需要访问的文件，而第二个参数则是访问模式：字符串“r”表示对该文件的访问时只读的。
	
	// 2.1.3. 【创建对象】读写模式
	// 创建一个基于文件访问的读写模式的RandomAccessFile，我们只需要在第二个参数中传入“rw”即可。
	// RandomAccessFile raf = new RandomAccessFile(file, "rw");
	// 那么这时在使用RandomAccessFile对该文件的访问就是又可读又可写的。
	
	
	// 2.2. 字节数据读写操作
	// 2.2.1. 【字节数据读写操作】write(int d)方法
	// RandomAccessFile提供了一个可以向文件中写出字节的方法：void write(int d)
	// 该方法会根据当前指针所在位置处写入一个字节，是将参数int的“低8位”写出
	
	// 2.2.2. 【字节数据读写操作】read()方法
	// 
}
