package chapter03;

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
	
}
