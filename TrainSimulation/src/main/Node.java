/**
* This class provides the implementation of a doubly linked list node. 
* These nodes have a pointer to the next node, a pointer to the previous node, and data.
* Known Bugs: None
*
* @author Archer Heffern
* hefferna@brandeis.edu
* 10/15/22
* COSI 21A PA1
*/

package main;

public class Node<T> {
	
	private T data;
	private Node<T> next;
	private Node<T> prev;
	
	/**
	 * constructs a doubly linked list node that holds a data field but does not point to any other nodes.
	 * @param data The data stored in Node
	 */
	public Node(T data) {
		this.data = data;
	}
	
	/**
	 * sets the data field of this node
	 * @param data
	 * O(1)
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * sets the next pointer of this node
	 * @param next Node: New next Pointer of node
	 * O(1)
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	/**
	 * sets the previous pointer of this node
	 * @param prev Node: New Previous Pointer of node
	 * O(1)
	 */
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	
	/**
	 * Gets next node this node points to
	 * @return the node
	 * O(1)
	 */
	public Node<T> getNext() {
		return next;
	}
	
	/**
	 * Gets the previous node this node points to
	 * @return the node
	 * O(1)
	 */
	public Node<T> getPrev() {
		return prev;
	}
	
	/**
	 * Gets data stored in node
	 * @return T object: data stored in this node
	 * O(1)
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * toString method
	 * @return String representation of this Node
	 * O(1)
	 */
	@Override
	public String toString() {
		return "[ " + prev + ", " + data + ", " + next + "]";
	}
}
