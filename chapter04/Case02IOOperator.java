package chapter04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

/**
 * IO基本操作
 * @author HuanQing
 * @since 2020-11-10
 */
public class Case02IOOperator {

	// 1. 【基本IO操作】
	// 1.1. 【IS与OS】
	// 1.1.1. 【输入与输出】
	// 我们编写的程序除了自身会定义一些数据外，经常还会引用外界的数据，或者是将自身的数据发送到外界。比如，我们编写的程序想读取一个文本文件，又或者我们想将程序中的某些数据写入到一个文件中。
	// 这是我们就要使用输入与输出。
	// 什么是输入：输入是一个从外界进入到程序的方向，通常我们需要读取外界的数据时，使用输入。所以，输入是用来读取数据的。
	// 什么是输出：输出是一个从程序发送到外界的方向，通常我们需要写出数据到外界时，使用呼出。所以，输出是用来写出数据的。
	
	// 1.1.2. 【IS与OS】节点流与处理流
	// 按照流是否直接与特定的地方（如磁盘、内存、设备等）相连，分为节点流和处理流两类。
	// 节点流：可以从或向一个特定的地方（节点）读写数据。
	// 处理流：是对一个已存在的流的连接和封装，通过所封装的流的功能调用实现数据读写。
	// 处理流的构造方法总是要带一个其它的流对象做参数。一个流对象经过其它流的多次包装，成为流的链接。
	// 通常节点流也称为低级流。
	// 通常处理流也称为高级流或过滤流。
	
	// 1.1.3. 【IS与OS】IS和OS常用方法
	// InputStream是所有字节输入流的父类，其定义了基础的读写方法，常用的方法如下：
	// int read()：读取一个字节，以int形式返回，该int值的“低8位”有效，若返回值为-1则表示EOF。
	// int read(byte[] d)：尝试最多读取给定数组的length个字节并存入该数组，返回值为实际读取到的字节量。
	// OutputStream是所有字节输出流的父类，其定义了基础的写出方法，常用的方法如下：
	// void write(int d)：写出一个字节，写的是给定的int的“低8位”。
	// void write(int[] d)：将给定的字节数组中的所有字节全部写出。
	
	
	// 1.2. 【文件流】
	// 1.2.1. 【文件流】创建FOS对象，重写模式
	// FileOutputStream是文件的字节输出流，我们使用该流可以以字节为单位将数据写入文件。
	// 构造方法：FileOutputStream(File file)：创建一个向指定File对象表示的文件中写出数据的文件输出流。
	// FileOutputStream(String filename)：创建一个向具有指定名称的文件中写出数据的文件输出流。
	// 这里需要注意的是，若指定的文件已经包含内容，那么当使用FOS对其写入数据时，会将该文件中原有数据全部清除。
	
	// 1.2.2. 【文件流】创建FOS对象，追加模式
	// 通过上一节的构造方法创建的FOS对文件进行写操作时，会覆盖文件中的原有数据。若想在文件的原有数据之后追加新数据则需要以下构造方法创建FOS。
	// FileOutputStream(File file, boolean append)：创建一个向指定File对象表示的文件中写出数据的文件输出流。
	// FileOutputStream(String filename, boolean append)：创建一个向具有指定名称的文件中写出数据的文件输出流。
	// 以上两个构造方法中，第二个参数若为true，那么通过FOS写出的数据都是在文件末尾追加的。
	
	// 1.2.3. 【文件流】创建FIS对象
	// FileInputStream是文件的字节输入流，我们使用该流可以以字节为单位从文件中读取数据。
	// 两个常用的构造方法：
	// FIleInputStream(File file)：创建一个从指定File对象表示的文件中读取数据的文件输入流。
	// FileInputStream(String name)：创建用于读取给定的文件系统中的路径名name所指定的文件的文件输入流。
	
	// 1.2.4. 【文件流】read()和write(int d)方法：
	// FileInputStream继承自InputStream，其提供了以字节为单位读取文件数据的方法read()：从此输入流中读取一个数据字节，若返回-1则表示EOF。
	// FileOutputStream继承自OutputStream，其提供了以字节为单位向文件写数据的方法write(int d)：将指定的字节写入此文件输出流，这里只写给定的int值的低8位。
	
	// 1.2.5. 【文件流】read(byte[] d)和write(byte[] d)
	// FileInputStream也支持批量读取数据的方法：int read(byte[] d)：从此输入流中将最多d.length个字节的数据读入到字节数组d中。
	// FileOutputStream也支持批量写出字节数据的方法：void write(byte[] d)：将d.length个字节从指定的字节数组写入到此文件输出流中。
	// void write(byte[] d, int offset, int length)：将指定byte数组中从偏移量offset开始的length个字节写入此文件输出流。
	
	
	// 1.3. 【缓冲流】
	// 1.3.1. 【缓冲流】BOS基本工作原理
	// 在向硬件设备做写出操作时，增大写出次数无疑会降低写出效率，为此我们可以使用缓冲输出流来一次性批量写出若干数据减少写出次数来提高写出效率。
	// BufferedOutputStream缓冲输出流内部维护着一个缓冲区，每当我们向该流写数据时，都会先将数据存入缓冲区，当缓冲区已满时，缓冲流会将数据一次性全部写出。
	
	// 1.3.2. 【缓冲流】BOS实现写出缓冲
	@Test
	public void testBos() throws Exception {
		FileOutputStream fos = new FileOutputStream("demo.dat");
		
		// 创建缓冲字节输出流
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		// 所有字节被存入缓冲区
		bos.write("Hello, World!".getBytes());
		
		// 关闭流之前，缓冲输出流会将缓冲内容一次性写出
		bos.close();
	}
	
	// 1.3.3. 【缓冲流】BOS的flush()方法
	// 使用缓冲输出流可以提高写出效率，但是这也存在着一个问题，就是写出数据缺乏及时性。
	// 有时我们需要在执行完某些写出操作后，就希望将这些数据确实写出，而非在缓冲区中保存知道缓冲区满后才写出。
	// 这时我们可以使用缓冲流的一个方法：void flush()：清空缓冲区，将缓冲区中的数据强制写出。
	
	// 1.3.4. 【缓冲流】BIS基本工作原理
	// 在读取数据时，若以字节为单位读取数据，会导致读取次数过于频繁，从而大大地降低读取效率。
	// 为此我们可以通过提高一次性读取的字节数量减少读取的次数来提高读取的效率。
	// BufferedInputStream是缓冲字节输入流，其内部维护着一个缓冲区（字节数组），使用该流在读取一个字节时该流会尽可能多的一次性读取若干字节并存入缓冲区。
	// 然后逐一地将字节返回，知道缓冲区中的数据被全部读取完毕，会再次读取若干字节，从而反复。
	// 这样就减少了读取的次数，从而提高了读取效率。
	// BIS是一个处理流，该流为我们提供了缓冲功能。
	
	// 1.3.5. 【缓冲流】BIS实现输入缓冲
	@Test
	public void testBis() throws Exception {
		// 创建缓冲字节输入流
		FileInputStream fis = new FileInputStream("demo.dat");
		
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		int d = -1;
		
		// 缓冲读入，实际上并非是一个字节一个字节地从文件读取的
		while((d = bis.read()) != -1) {
			System.out.print(d + " ");
		}
		
		bis.close();
	}
	
	
	// 1.4. 【对象流】
	// 1.4.1. 【对象流】对象序列化概念
	// 对象时存在于内存中的，有时候我们需要将对象保存到硬盘上，又有时我们需要将对象传输到另一台计算机上等等这样的操作。
	// 这时我们需要将对象转换为一个字节序列，而这个过程就成为对象序列化。
	// 相反我们有这样一个字节序列需要将其转换位对应的对象，这个过程就成为对象的反序列化。
	
	// 1.4.2. 【对象流】使用OOS实现对象序列化
	// ObjectOutputStream是用来对对象进行序列化的输出流。
	// 其实现对象序列化的方法为：void writeObject(Object o)：该方法可以将给定的对象转换为一个细节序列后给出。
	
	// 1.4.3. 【对象流】使用OIS实现对象的反序列化
	// ObjectInputStream是用来对对象进行饭序列化的输入流
	// 其实现对象反序列化的方法为： Object readObject()：该方法可以从流中读取字节并转换为对应的对象。
	
	// 1.4.4. 【对象六】Serializable接口
	// ObjectOutputStream在对对象进行序列化时有一个要求，就是需要序列化的对象所属的类必须实现Serializable接口。
	// 实现该接口不需要重写任何方法。其只是作为可序列化的标识。
	// 通常实现该接口的类需要提供一个常量serialVersionUID，表明该类的版本。
	// 若不显式地声明，在对象序列化时也会根据当前类的各个方面计算该类的默认serialVersionUID，但不同平台编译器的实现有所不同，所以若想跨平台，都应显式地声明版本号。
	// 如果声明地类地对象序列化存到硬盘上面，之后随着需求地变化更改了类地属性，那么当反序列化时，就会出现InvalidClassException，这样会造成不兼容性地问题。
	// 但当serialVersionUID相同时，它就会将不一样地field以type地预设值反序列化，可避开不兼容性问题。
	
	// 1.4.5. 【对象流】transient关键字
	// 对象在序列化后得到的字节往往比较大，有时我们在对一个对象进行序列化时，可以忽略某些不必要的属性，从而对序列化后得到的字节序列“瘦身”。
	// transient，被该关键字修饰的属性在序列化时其值将被忽略。
	
	
	
	// 2. 【文件数据IO操作】
	// 2.1. 【Reader和Writer】
	// 2.1.1. 【Reader和Writer】字符流原理
	// Reader是字符输入流的父类，Writer是字符输出流的父类
	// 字符流是以字符（char）为单位进行读写数据的。一次处理一个unicode。
	// 字符流的底层仍然是基本的字节流。
	
	// 2.1.2. 【Reader和Writer】常用方法
	// Reader的常用方法：
	// int read()：读取一个字符，返回读取的int值“低16位”有效
	// int read(char[] chars)：从该流中读取一个字符数组的length个字符并存入该数组，返回值位实际读取到的字符量。
	// Writer的常用方法：
	// void write(int c)：写出一个字符，写出给定int值“低16”位表示的字符。
	// void write(char[] chars)：将给定字符数组中所有字符写出。
	// void write(String str)：写出给定字符串。
	// void write(char[] chars, int offset, int length)：将给定的字符数组中从offset处开始连续length个字符写出。
	
	
	// 2.2. 【转换流】
	// 2.2.1. 【转换流】字符转换流原理
	// InputStreamReader：字符输入流
	// 使用该流可以设置字符集，并按照指定的字符集从流中按照该编码将字节数据转换为字符并读取。
	// OutputStreamWriter：字符输出流
	// 使用该流可以设置字符集，并按照指定的字符集将字符转换为对应字节后通过该流写出。
	
	// 2.2.2. 【转换流】指定字符编码
	// InputStreamReader的构造方法允许我们设置字符集：
	// InputStreamReader(InputStream is, String charsetName)：基于给定的字节输入流以及字符编码创建ISR。
	// InputStreamReader(InputStream is)：该构造方法会根据系统默认字符集创建ISR。
	// OutputStreamWriter的构造方法：
	// OutputStreamReader(OutputStream os, String charsetName)：基于给定的字节输入流以及字符编码创建OSW。
	// OutputStreamReader(OutputStream os)：该构造方法会根据系统默认字符集创建OSW。
	
	// 2.2.3. 【转换流】使用OSW
	@Test
	public void testOutput() throws IOException {
		FileOutputStream fos = new FileOutputStream("demo.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");	// 在构造方法中设置字符集
		String str = "大家好！";
		osw.write(str);
		osw.close();
		
	}
	
	// 2.2.4. 【转换流】使用ISR
	@Test
	public void testInput() throws IOException {
		FileInputStream fis = new FileInputStream("demo.txt");
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		int c = -1;
		while((c = isr.read()) != -1) {
			System.out.println((char) c);
		}
		isr.close();
		
	}
}
