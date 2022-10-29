package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.DoubleLinkedList;

class StudentDLLTest {

	@Test
	public void testBasicConstructor() {
		DoubleLinkedList<Integer> LL = new DoubleLinkedList<>();
		assertEquals("[]", LL.toString().toLowerCase());
	}

	@Test
	public void testGetFirstEmptyList() {
		DoubleLinkedList<Integer> LL = new DoubleLinkedList<>();
		assertEquals(null, LL.getFirst());
	}
	
	@Test
	public void testGetFirstNode() {
		DoubleLinkedList<Integer> LL = new DoubleLinkedList<>();
		LL.insert(4);
		assertEquals("[4]", LL.toString().toLowerCase());
	}
	
	@Test
	public void testInsertNodes() {
		DoubleLinkedList<Integer> LL = new DoubleLinkedList<>();
		LL.insert(1);
		LL.insert(2);
		LL.insert(3);
		assertEquals("[1, 2, 3]", LL.toString().toLowerCase());
	}
	
	@Test
	public void testDeleteFirstNodeLLOfLengthOne() {
		DoubleLinkedList<Integer> LL = new DoubleLinkedList<>();
		LL.insert(1);
		LL.delete(1);
		assertEquals("[]", LL.toString().toLowerCase());
	}
	
	@Test
	public void testDeleteNodes() {
		DoubleLinkedList<Integer> LL = new DoubleLinkedList<>();
		LL.insert(1);
		LL.insert(2);
		LL.insert(3);
		LL.delete(2);
		assertEquals("[1, 3]", LL.toString().toLowerCase());
	}
	
	@Test
	public void testGetNode() {
		DoubleLinkedList<Integer> LL = new DoubleLinkedList<>();
		LL.insert(1);
		LL.insert(2);
		LL.insert(3);
		
		assertEquals(2, LL.get(2));		
	}
	
	@Test
	public void testGetNodeEdge() {
		DoubleLinkedList<Integer> LL = new DoubleLinkedList<>();
		LL.insert(1);
		LL.insert(2);
		LL.insert(3);
		LL.get(4);
		assertEquals("[1, 2, 3]", LL.toString().toLowerCase());		
	}
	
	@Test
	public void testGetSizeOfEmptyList() {
		DoubleLinkedList<Integer> LL = new DoubleLinkedList<>();
		assertEquals(0, LL.size());		
	}
	
	@Test
	public void testGetSize() {
		DoubleLinkedList<Integer> LL = new DoubleLinkedList<>();
		LL.insert(1);
		LL.insert(2);
		LL.insert(3);
		assertEquals(3, LL.size());		
	}
}

