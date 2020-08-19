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
	
}
