package chapter03;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

/**
 * 4.集合框架：Collection，Iterator，泛型机制
 *   集合操作：线性表，List，List排序，队列和栈
 * @author HuanQing
 * @since 2020-08-12
 */
public class CollectionFrame {

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
		c1.add("php");
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
	
}
