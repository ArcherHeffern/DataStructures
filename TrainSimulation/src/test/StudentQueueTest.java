package test;

import main.Queue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class StudentQueueTest {

	@Test
	public void testConstructor() {
		Queue<Integer> q = new Queue<>(10);
		assertEquals("[]", q.toString().toLowerCase());
	}
	
	@Test
	public void testEnqueue() {
		Queue<Integer> q = new Queue<>(10);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		assertEquals("[1, 2, 3]", q.toString().toLowerCase());
	}
	
	@Test
	public void testEnqueueError() {
		Queue<Integer> q = new Queue<>(1);
		q.enqueue(2);
		assertThrows(NoSuchElementException.class , () -> q.enqueue(2));
	}
	
	@Test
	public void testDequeue() {
		Queue<Integer> q = new Queue<>(10);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		assertEquals("[2, 3]", q.toString().toLowerCase());
	}
	
	@Test
	public void testDequeueError() {
		Queue<Integer> q = new Queue<>(1);
		assertThrows(NoSuchElementException.class , () -> q.dequeue());
	}
	
	@Test
	public void testFront() {
		Queue<Integer> q = new Queue<>(10);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		assertEquals(1, q.front());
	}
	
	public void testSize() {
		Queue<Integer> q = new Queue<>(10);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		assertEquals(5, q.size());
	}

}
