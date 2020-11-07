package chapter04;

import java.io.File;
import java.io.FileFilter;

import org.junit.Test;

public class Case01FilePeration {

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
	// RandomAccessFile提供了一个可以从文件中读取字节的方法：int read()
	// 该方法会从文件中读取一个byte(8位)填充到int的低8位，高24位为0，返回值范围正数：0~255，如果返回-1表示读取到了文件末尾。
	// 每次读取后自动移动文件指针，准备下次读取。
	
	// 2.2.3. 【字节数据读写操作】write(byte[] d)方法
	// RandomAccessFile提供了一个可以向文件中写出一组字节的方法：void write(byte[] d)
	// 该方法会根据当前指针所在的位置处连续写出给定的数组中的所有字节。
	// 与该方法相似的还有一个常用方法：void write(byte[] d, int offset, int len)
	// 该方法会根据当前指针所在位置处连续写出给定数组中的部分字节，这个部分是从数组的offset处开始，连续len个字节。
	
	// 2.2.4. 【字节数据读写操作】read(byte[] b)
	// RandomAccessFile提供了一个可以从文件中批量读取字节的方法：int read(byte[] b)
	// 该方法会从指定位置处尝试最多读取给定数组的总长度的字节量，并从给定的字节数组第一个位置开始，将读取到的字节顺序存放至数组中，返回值为实际读取到的字节量。
	
	// 2.2.5. 【字节数据读写操作】close()方法
	// RandomAccessFile在对文件访问的操作全部结束后，要调用close()方法来释放与其关联的所有系统资源：void close()
	// RandomAccessFile raf = new RandomAccessFile(file, "r");
	// raf.close();
	// 访问完毕后要关闭以释放系统资源。
	
	
	// 2.3. 【文件指针操作】
}
