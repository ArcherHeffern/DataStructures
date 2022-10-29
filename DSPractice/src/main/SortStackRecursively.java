package main;

import java.util.Stack;

public class SortStackRecursively {

	public static void main(String[] args) {
		// Write a recursive function sort_stack that sorts 
		// a given stack in ascending order. Equivalent elements
		// of the stack must retain their original ordering. What is 
		// the running time of your algorithm?
		
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(4);
		s.push(4);
		s.push(1);
		s.push(4);
		s.push(4);
		s.push(4);
		
		sort_stack(s);
		
		System.out.println(s);
		
		// Before: [1, 2, 3, 4, 5, 6, 7]
		// After : [7, 6, 5, 4, 3, 2, 1]
	}
	
	public static <T> void sort_stack(Stack<Integer> s) {
		
		// put everything into the call stack
		if (!s.isEmpty()) {
			int x = s.pop();
			
			sort_stack(s);
			// recursively sort
			recursive_insertion(s, x);
		}
	}
	
	public static void recursive_insertion(Stack<Integer> s, int x) {
		
		// edge case
		
		if (s.isEmpty()) {
			s.push(x);
		}
		else {
			
			int valBelow = s.peek();
			
			// if don't need swap, just insert and exit
			if (valBelow < x) {
				s.push(x);
			}
			else {
				
				s.pop();
				recursive_insertion(s, x);
				s.push(valBelow);
			}
			// if do need swap, swap, then recurse downward
		}
	}

}
