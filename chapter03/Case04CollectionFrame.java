package chapter03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

/**
 * 4.集合框架：Collection，Iterator，泛型机制
 *   集合操作：线性表，List，List排序，队列和栈
 * @author HuanQing
 * @since 2020-08-12
 */
public class Case04CollectionFrame {

	// 1.集合框架
	// 1.1.Collection
	// 1.1.1.addAll、containsAll
	// boolean addAll(Collection<?extends E> c)
	// 该方法需要我们传入一个集合，并将该集合中的所有元素添加大当前集合中。
	// 如果此Collection由于调用而发生更改，则返回true
	
	// boolean containsAll(Collection<?> c)
	// 该方法用于判断当前集合是否包含给定集合中的所有元素，若包含，则返回true
	
	@Test
	public void testAddAllAndContainsAll() {
		Collection<String> c1 = new ArrayList<String>();
		c1.add("java");
		c1.add("c#");
		c1.add("php");
		c1.add("cpp");
		c1.add("objective-c");
		System.out.println(c1);
		
		Collection<String> c2 = new ArrayList<String>();
		c2.addAll(c1);
		System.out.println(c2);
		
		Collection<String> c3 = new ArrayList<String>();
		c3.add("java");
		c3.add("c#");
		System.out.println(c3);
		
		System.out.println(c1.containsAll(c3));
	}
	
	
	// 1.2.Iterator
	// 1.2.1.【Iterator】hasNext、next方法
	// hasNext、next
	// 迭代器用于遍历集合元素。获取迭代器可以使用Collection定义的方法：Iterator iterator()
	// 迭代器Iterator是一个接口。集合在重写Collection的iterator()方法时，利用内部类提供了迭代器的实现。
	// Iterator提供了统一的遍历集合的方式，其提供了用于遍历集合的两个方法：
	// boolean hasNext()：判断集合是否还有元素可以遍历
	// E next()：返回迭代的下一个元素
	
	@Test
	public void testHasNextAndNext() {
		Collection<String> c = new ArrayList<String>();
		c.add("apple");
		c.add("orange");
		c.add("banana");
		
		Iterator<String> it = c.iterator();
		while(it.hasNext()) {
			String fruit = it.next();
			System.out.println(fruit);
		}
	}
	
	// 1.2.2.【Iterator】remove方法
	// 在使用迭代器遍历集合时，不能通过集合的remove方法删除集合元素，否则会抛出并发更改异常，我们可以通过迭代器自身提供的remove方法
	// 来删除通过next()迭代出的元素
	// 迭代器的删除方法是在原集合中删除元素
	// 这里需要注意的是，在调用remove()方法之前必须通过迭代器的next()方法迭代过元素，那么删除的就是这个元素。
	// 并且不能再次调用remove()方法，除非再次调用next()后，方可再次调用。
	
	@Test
	public void testRemove() {
		Collection<String> c = new ArrayList<String>();
		c.add("Subway");
		c.add("Car");
		c.add("Airplane");
		c.add("Bus");
		
		System.out.println(c);
		
		Iterator<String> it = c.iterator();
		
		while(it.hasNext()) {
			String trafficTool = it.next();
			if(trafficTool.indexOf('C') != -1) {
				it.remove();
			}
		}
		
		System.out.println(c);
	}
	
	// 1.2.2.【Iterator】增强for循环
	// Java 5.0之后推出了一个新的特性，增强for循环，也称新循环，该循环不通用于传统循环的工作，其只用于遍历集合或数组。
	// 新循环并非新的语法，而是在编译过程中，编译器会将新循环转换为迭代器模式。所以新循环本质上是迭代器。
	
	@Test
	public void testForEach() {
		Collection<String> c = new ArrayList<>();
		c.add("Car");
		c.add("Bus");
		c.add("Railway");
		c.add("Airplane");
		
		System.out.println(c);
		
		for(String trafficTool : c) {
			System.out.print(trafficTool.toUpperCase() + " ");
		}
	}
}
