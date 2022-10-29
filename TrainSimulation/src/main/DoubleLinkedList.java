/**
* This class provides the implementation of a generic non-circular doubly linked list.
* Known Bugs: None
*
* @author Archer Heffern
* hefferna@brandeis.edu
* 10/15/22
* COSI 21A PA1
*/

package main;

public class DoubleLinkedList<T> {
	
	private Node<T> head;
	private Node<T> tail;

	/**
	 * initializes a doubly linked list to have 0 elements
	 */
	public DoubleLinkedList() {
		head = null;
		tail = null;
	}
	
	/**
	 * Gets the first node in the linked list
	 * @return Node first node in the list or null if one does not exist
	 * O(1)
	 */
	public Node<T> getFirst() {
		return head;
	}
	
	/**
	 * adds an element to the end of this list
	 * @param element
	 * O(1)
	 */
	public void insert(T element) {
		Node<T> node = new Node<T>(element);
		node.setNext(null);
		// insert at front
		if (head == null) {
			node.setPrev(null);
			head = node;
		}
		// insert elsewhere
		else {
			tail.setNext(node);
			node.setPrev(tail);
		}
		tail = node;

	}
	
	/**
	 * deletes the first element from this list that matches the provided key. If the provided key does not exist in the list, return null.
	 * @param key
	 * @return first element that matches key, or null
	 * O(n)
	 */
	public T delete(T key) {
		Node<T> curr = head;
		while (curr != null) {
			T currData = curr.getData();
			if (currData.equals(key)) {
				// delete login
				if (curr.getPrev() != null) {
					curr.getPrev().setNext(curr.getNext());
				}
				else {
					head = curr.getNext();
				}
				if (curr.getNext() != null) {
					curr.getNext().setPrev(curr.getPrev());
				}
				else {
					tail = curr.getPrev();
				}
				return currData;
			}
			curr = curr.getNext();
		}
		return null;
	}
	
	/**
	 * gets the first element in the list that matches the provided key
	 * @param key
	 * @return T the first element in the list that matches key
	 * O(n)
	 */
	public T get(T key) {
		Node<T> curr = head;
		while (curr != null) {
			T currData = curr.getData();
			if (currData.equals(key)) {
				return currData;
			}
			curr = curr.getNext();
		}
		return null;
	}
	
	/**
	 * gets length of list
	 * @return int number of elements in the list
	 * O(n)
	 */
	public int size() {
		Node<T> curr = head;
		int length = 0;
		while (curr != null) {
			length++;
			curr = curr.getNext();
		}
		return length;
	}
	
	/**
	 * toString method
	 * @return representation of linked list
	 * O(n)
	 */
	@Override
	public String toString() {
		String elements = "";
		Node<T> curr = head;
		while (curr != null) {
			elements += curr.getData();
			if (curr.getNext() != null) {
				elements += ", ";
			}
			curr = curr.getNext();
		}
		return "[" + elements + "]";
		}
	}


