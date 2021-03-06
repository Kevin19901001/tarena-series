﻿package chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import org.junit.Test;

import utils.Cell;

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
	
	
	
	// 2.集合操作--线性表
	// 2.1.List
	// 2.1.1.ArrayList和LinkedList
	// List接口是Collection的子接口，用于定义线性表数据结构。
	// 可以将List理解为存放对象的数组，只不过其元素的个数可以动态地增加或减少。
	// List接口的2个常见实现类为ArrayList和LinkedList，分别用动态数组和链表方式实现了List接口。
	// 可以认为ArrayList和LinkedList的方法在逻辑上完全一样，只是在性能上有一定的差别。
	// Arrayist更适合于随机访问，而LinkedList更适合于插入和删除。
	// 在性能要求不是特别苛刻的情形下，可以忽略这个差别。
	
	// 2.1.2.get和set
	// ArrayList除了继承Collection定义的方法外，还根据其线性表的数据结构定义了一系列方法，其中最常用的就是基于下标的get和set方法。
	// E get(int index)：获取集合中给定下标对应的元素，下标从0开始。
	// E set(int index, E element)：将给定的元素存入给定位置，并将原位置的元素返回。
	
	@Test
	public void testGetAndSet() {
		List<String> list = new ArrayList<>();
		list.add("java");
		list.add("cpp");
		list.add("php");
		list.add("c#");
		list.add("objective-c");
		
		System.out.println(list);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		list.set(1, "c++");			// 将第2个元素设置为c++
		
		System.out.println(list);
		
		list.set(1, list.set(3, list.get(1)));	// 将第2个和第4个元素换位置
		
		System.out.println(list);
	}
	
	// 2.1.3.插入和删除
	// List根据下标的操作还支持插入和删除操作。
	// void add(int index, E element)：将给定的元素插入到指定位置，原位置及后续元素都顺序向后移动。
	// E remove(int index)：删除给定位置的元素，并将被删除的元素返回。
	
	@Test
	public void testAddAndRemove() {
		List<String> list = new ArrayList<>();
		list.add("java");
		list.add("c#");
		
		System.out.println(list);
		
		list.add(1, "cpp");
		System.out.println(list);		// [java, cpp, c#]
		
		list.remove(2);
		System.out.println(list);		// [java, cpp]
	}
	
	// 2.1.4【List】subList
	// List的subList方法用于获取子List
	// 需要注意的是，subList获取的List与原List占有相同的存储空间，对子List的操作会影响原List。
	// List<E> subList(fromIndex, toIndex)
	// fromIndex和toIndex是获取子List的首尾下标（前包括，后不包括）
	
	@Test
	public void testSubList() {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		System.out.println(list);						// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		
		List<Integer> subList = list.subList(3, 8);
		System.out.println(subList);						// [3, 4, 5, 6, 7]
		
		// subist(fromIndex, toIndex)截取的子List和原List占有相同的存储空间
		for(int i = 0; i < subList.size(); i++) {
			subList.set(i, subList.get(i)*10);
		}
		
		System.out.println(list);						// [0, 1, 2, 30, 40, 50, 60, 70, 8, 9]
		
		// 连续删除元素
		list.subList(3, 8).clear();
		System.out.println(list);						// [0, 1, 2, 8, 9]
	}
	
	// 2.1.5【List】List转换为数组
	// List的toArray方法用于将集合转换为数组，但实际上该方法是在Collection中定义的，所以所有的集合都具备这个功能。
	// 其有两个方法：
	// Object[] toArray()
	// <T> T[] toArray(T[] a)：该方法教常用，传入一个指定类型的数组，该数组的元素类型应该与集合的元素类型一致。
	// 返回值则是转换后的数组，该数组会保留集合中所有的元素。
	
	@Test
	public void testListToArray() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		String[] strArr = list.toArray(new String[] {});
		
		System.out.println(Arrays.toString(strArr));
	}
	
	// 2.1.6.【List】数组转换为List
	// Arrays类提供了一个静态方法asList，使用该方法我们可以将一个数组转换为对应的List集合。
	// static <T>List<T> asList<T...a>
	// 返回的List的集合元素类型由传入的数组元素类型决定。
	// 并且要注意的是，返回的集合，我们不能对其增删元素，否则会抛出异常。
	// 并且对集合的元素进行修改，会影响数组对应的元素。
	
	@Test
	public void testArrayToList() {
		String[] strArr = {"A", "B", "C"};
		List<String> list = Arrays.asList(strArr);
		System.out.println(list);
		System.out.println(list.getClass().getName());
		//list.add("D");			// UnsupportedOperationException
		
		List<String> list1 = new ArrayList<>();
		list1.addAll(Arrays.asList(strArr));
		System.out.println(list1);
		
		list1.add("D");
		System.out.println(list1);		// [A, B, C, D]
	}
	
	
	// 2.2.List排序
	// 2.2.1.【List排序】Collections.sort方法实现排序
	// Collections是集合的工具类，它提供了很多便于我们操作集合的方法，其中就有用于集合排序的sort方法。
	// void sort(List<T> list)：对给定的结合元素进行自然排序
	
	@Test
	public void testSort() {
		List<Integer> list = new ArrayList<>();
		Random r = new Random(1);
		for(int i = 0; i < 10; i++) {
			list.add(r.nextInt(100));
		}
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
	}
	
	// 2.2.2【List排序】Comparable
	// Collections的sort方法是对集合元素进行自然排序，那么两个元素对象之间就一定要有大小之分。
	// 这个大小之分是如何界定的？实际上，在使用Collections的sort方法排序的集合元素都必须是Comparable接口的实现类。
	// 该接口表示其子类是可比较的，因为实现该接口必须实现抽象方法int compareTo(T t)。该方法用于使当前对象与给定对象进行比较。
	// 若当前对象大于给定对象，那么返回值应为大于0的整数；
	// 若小于给定对象，那么返回值应为小于0的整数；
	// 若两个对象相等，则应返回0
	
	@Test
	public void testComparable() {
		List<Cell> cells = new ArrayList<Cell>();
		cells.add(new Cell(2, 3));
		cells.add(new Cell(5, 1));
		cells.add(new Cell(3, 2));
		Collections.sort(cells);
		System.out.println(cells);
	}
	
	// 2.2.3.【List排序】Comparator
	// 一旦java类实现了Comparable接口，其比较逻辑就已经确定；如果希望在排序的操作中临时指定比较规则，可以采用Comparator接口回调的方式。
	// Comparator接口要求实现类必须重写其定义的方法：int compare(T o1, T o2)
	// 该方法的返回值要求：若o1>o2则返回值应>0；若o1<o2则返回值应<0；若o1==o2则返回值应为0
	
	@Test
	public void testCmparator() {
		List<Cell> cells = new ArrayList<>();
		cells.add(new Cell(2, 3));
		cells.add(new Cell(5, 1));
		cells.add(new Cell(3, 2));
		Collections.sort(cells, new Comparator<Cell>() {
			@Override
			public int compare(Cell o1, Cell o2) {
				// TODO Auto-generated method stub
				return o1.getCol() - o2.getCol();
			}
		});
		System.out.println(cells);
	}
	
	
	// 2.3.队列和栈
	// 2.3.1.【队列和栈】Queue
	// 队列（Queue）是常用的数据结构，可以将队列看成特殊的线性表，队列限制了对线性表的访问方式：
	// 只能从线性表的一段添加（offer）元素，从另一端取出（poll）元素。
	// 队列遵循先进先出的原则。
	// JDK中提供了Queue接口，同时使得LinkedList实现了该接口，
	// 选择LinkedList实现Queue的原因在于Queue经常要进行添加或删除操作，而LinkedList在这方面效率较高。
	// Queue接口中的主要方法：
	// boolean offer(E e)：将一个对象添加至队尾，如果添加成功则返回true；
	// E poll()：从队首删除并返回一个元素
	// E peek()：返回队首的元素（但并不删除）
	
	@Test
	public void testQueue() {
		Queue<String> queue = new LinkedList<>();
		queue.offer("a");
		queue.offer("b");
		queue.offer("c");
		System.out.println(queue);		// [a, b, c]
		
		String str = queue.peek();
		System.out.println(str);		// a
		
		while(queue.size() > 0) {
			str = queue.poll();
			System.out.print(str + " ");	// a b c 
		}
	}
	
	// 2.3.2【队列和栈】Deque
	// Deque是Queue的字接口，定义了所谓“双端队列”即从队列的两端分别可以入队和出队，LinkedList实现了该接口。
	// 如果将Deque限制为只能从一段入队和出队，则可实现“栈”（stack）的数据结构，对于栈而言，入栈称之为push，出栈称之为pop。
	// 栈遵循“先进后出”的原则。
	
	@Test
	public void testStack() {
		Deque<String> deque = new LinkedList<>();
		deque.push("a");
		deque.push("b");
		deque.push("c");
		System.out.println(deque);		// [c, b, a]
		
		String str = deque.peek();
		System.out.println(str);		// c
		
		while(deque.size() > 0) {
			str = deque.pop();
			System.out.print(str + " ");	// c b a 
		}
	}
}
