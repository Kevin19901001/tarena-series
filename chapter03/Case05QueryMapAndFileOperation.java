package chapter03;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import utils.Emp;

public class Case05QueryMapAndFileOperation {

	// 1.查询表
	// 1.1.Map接口
	// 1.1.1.【Map接口】Map接口
	// Map接口定义的结合又称查找表，用于存储所谓“key-value”映射对。
	// key可以看成是value的索引，作为key的对象，在集合中不可以重复。
	// 根据内部数据结构的不同，Map接口有多种实现类。
	// 其中常用的有，内部为hash表实现的HashMap和内部为排序二叉树实现的TreeMap。
	
	// 1.1.2.【Map接口】put()方法
	// Map接口中定义了向Map中存放元素的put()方法:
	// V put(K key, V value)：将Key-Value对存入Map，
	// 如果在集合中已经包含该key，则操作将替换该Key所对应的Value，返回值为该Key原来所对应的Value，如果没有则返回null。
	
	// 1.1.3.【Map接口】get()方法
	// Map接口中定义了从Map中获取元素的get方法:
	// V get(Object key)：返回参数key所对应的value对象，如果不存在则返回null。
	
	@Test
	public void testPutAndGet() {
		Map<String, Emp> employees = new HashMap<>();
		employees.put("张三", new Emp("张三", 25, '男', 5000.00));
		employees.put("李四", new Emp("李四", 21, '女', 6000.00));
		
		System.out.println(employees);
		
		Emp emp = employees.get("张三");
		System.out.println(emp);
	}
	
	// 1.1.4.【Map接口】containsKey()方法
	// Map接口中定义了判断某个key是否在Map中存在：
	// boolean containsKey(Object key)：若Map中包含给定的key则返回true，否则返回false。
	
	@Test
	public void testContainsKey() {
		Map<String, Emp> employees = new HashMap<>();
		employees.put("张三", new Emp("张三", 25, '男', 5000.00));
		employees.put("李四", new Emp("李四", 21, '女', 6000.00));
		
		boolean has = employees.containsKey("李四");
		System.out.print("是否有员工李四：" + has);
	}
	
	
	// 1.2.HashMap
	// 1.2.1.【HashMap】Hash表原理
	
	// 1.2.2.【HashMap】hashCode方法
	// 从HashMap的原理中我们可以看到，key的hashCode方法的返回值对HashMap存储元素时，会起着很重要的作用。
	// 而hashCode()方法实际上是在Object中定义的。
	// 那么应当妥善重写该方法：
	// 对于重写了equals()方法的对象，一般要妥善地重写继承自Object类的hashCode()方法，
	// （Object提供的hashCode()方法将返回该对象所在内存地址的整数形式）。
	// 重写hashCode()方法时需注意两点：
	// 其一：与equals()方法的一致性，即equals()方法比较，返回true的两个对象，其hashCode()方法返回值应该相同；
	// 其二，hashCode()返回的数值应符合hash算法的要求，试想如果有很多对象的hashCode()方法返回值都相同，则会大大降低hash表的效率。
	// 一般情况下，可以使用IDE提供的工具自动生成hashCode()方法。
	
	// 1.2.3.【HashMap】装载因子及HashMap优化
	// Capacity：容量，Hash表里bucket的数量，也就是散列数组大小。
	// Initial capacity：初始容量，创建Hash表时，初始bucket的数量。默认构建容量是16，也可以使用特定容量。
	// Load factory：加载因子，默认值是0.75（也就是75%），当向散列增加数据时，如果size/capacity的值大于Load Factory，则发生扩容，并且重新散列（rehash）
	// 性能优化：加载因子较小时，散列查找性能会提高，同时也浪费了散列桶空间容量。
	// 0.75是性能和空间相对平衡结果。在创建散列表时指定合理容量，减少rehash提高性能。
	
	
	// 1.3.Map的遍历
	// 1.3.1.【Map的遍历】使用keySet()方法
	// Map提供了3种遍历方式：
	// -遍历所有的key
	// -遍历所有的key-value对
	// -遍历所有的value（不常用）
	// 遍历所有key的方法：
	// Set<key> keySet()：该方法会将当前Map中所有的key存入一个Set集合后返回。
	
	// 1.3.2.【Map的遍历】使用entrySet()方法
	// 遍历所有键值对的方法：
	// Set<key, value> entrySet()：该方法会将当前Map中每一组key-value对封装为一个Entry对象，并存入一个Set集合后返回。
	
	
	// 1.4.有序的Map
	// 1.4.1.【有序的Map】LinkedHashMap实现有序的Map
	// 使用Map接口的Hash表和链表实现，具有可预知的迭代顺序。此实现与HashMap的不同之处在于：
	// -LinkedHashMap维护着一个双向循环链表。此链表定义了迭代顺序，该迭代顺序通常就是存放元素的顺序。
	// 需要注意的是，如果在Map中新存入已有的key，那么key的位置不会发生改变，只是将value值替换。
	
	
	
	// 2.文件操作File
	// 2.1.创建File对象
	// 2.1.1.【创建File对象】File(String pathname)
	// java.io.File用于表示文件（目录），也就是说程序员可以通过File类在程序中操作硬盘上的文件和目录。
	// File类只用于表示文件（目录）的信息（名称、大小等），不能对文件的内容进行访问。
	// 构造方法：File(String pathname)：通过将给定路径名字符串转换成抽象路径名来创建一个新File实例。
	// 抽象路径应尽量使用相对路径，并且目录的层级分隔符不要直接写“/”或“\”，应使用File.seperator这个常量表示，以避免不同系统带来的差异。
	
	@Test
	public void testFile() {
		File file = new File("demo" + File.separator + "HelloWorld.txt");
		System.out.println(file);
	}
}
