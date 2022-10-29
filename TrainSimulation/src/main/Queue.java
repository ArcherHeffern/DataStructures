/**
* This class provides the implementation of a generic circular first-in-first-out queue
* Known Bugs: None
*
* @author Archer Heffern
* hefferna@brandeis.edu
* 10/15/22
* COSI 21A PA1
*/

package main;

import java.util.NoSuchElementException;

public class Queue<T> {

	public T[] q;
	public int head;
	public int tail;
	public int numEntries;
	
	@SuppressWarnings("unchecked")
	public Queue(int capacity) {
		this.q = (T[]) new Object[capacity];
		head = 0;
		tail = 0;
		numEntries = 0;
	}
	
	/**
	 * adds an element at the tail of the queue
	 * @param element added to queue
	 * @throws NoSuchElementException
	 * O(1)
	 */
	public void enqueue(T element) {
		if (q.length == numEntries) {
			throw new NoSuchElementException();
		}
		q[tail] = element;
		numEntries++;
		tail = (tail + 1) % q.length;
	}
	
	/**
	 * removes the element at the head of the queue
	 * @throws NoSuchElementException if queue is empty
	 * O(1)
	 */
	public void dequeue() {
		if (head == tail) {
			throw new NoSuchElementException();
		}
		head = (head + 1) % q.length;
		numEntries--;
	}
	
	/**
	 * Gets element at front of queue
	 * @return element at the head of the queue
	 * O(1)
	 */
	public T front() {
		return q[head];
	}
	
	/**
	 * Gets the size of the queue
	 * @return the number of elements in the queue
	 * O(1)
	 */
	public int size() {
		return numEntries;
	}
	
	/**
	 * toString method
	 * @return String representation of Queue
	 * O(n)
	 */
	@Override
	public String toString() {
		String elements = "";
		for (int i = 0; i < numEntries; i++) {
			int index = (i + head) % q.length;
			elements += q[index];
			if (i != numEntries - 1) {
				elements += ", ";
			}
		}
		return "[" + elements + "]";
	}
}
