package main;

import ds.MyLinkedList;
import ds.Node;

public class RecursiveLinkedListMinValue {
	
	public static void main(String[] args) {
		
		// Write a recursive function linked_list_min that finds the minimum element in
		// a singly linked list. What is the running time of your algorithm?
		
		MyLinkedList LL = new MyLinkedList();
		LL.head = new Node(1);
		
		// should be 4
//		int first = linked_list_min(LL.head);
//		System.out.println(first);
		
		LL.head.next = new Node(1);
		LL.head.next.next = new Node(1);
		LL.head.next.next.next = new Node(1);
		
		// should be 2
		int second = linked_list_min(LL.head);
		System.out.println(second);
		 
//		LL.head.next.next.next.next = new Node(2);
//		LL.head.next.next.next.next.next = new Node(7);
//		LL.head.next.next.next.next.next.next = new Node(-1);
//		LL.head.next.next.next.next.next.next.next = new Node(2);
//		LL.head.next.next.next.next.next.next.next.next = new Node(2);
		
		// should be -1
//		int third = linked_list_min(LL.head);
//		System.out.println(third);
	}
	
	public static int linked_list_min(Node L) {
		if (L == null) return 10000000;
		else if (L.next == null) return L.data;
		else return Math.min(L.data, linked_list_min(L.next));
	}
	
	
}
