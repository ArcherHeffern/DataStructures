package main;
import ds.*;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class NonRecursiveInorderTraversal {
	public static void main(String[] args) {
		int size = 7;
		TreeNode head = new TreeNode(4);
		head.left = new TreeNode(2);
		head.left.left = new TreeNode(1);
		head.left.right = new TreeNode(3);
		head.right = new TreeNode(6);
		head.right.left = new TreeNode(5);
		head.right.right = new TreeNode(7);
		
		int[] lakjkdfj = non_recursive_inorder_traversal(head, size);
		System.out.println(Arrays.toString(lakjkdfj));
		
	}
	
	public static int[] non_recursive_inorder_traversal(TreeNode head, int size) {
		int[] traversalArray = new int[size];
		
		TreeNode node = head;
		
		int counter = 0;
		
		Stack<TreeNode> s = new Stack<>();
		
		while (node != null || s.size() > 0) {
			while (node != null) {
				s.push(node);
				node = node.left;
			}
			node = s.pop();
			traversalArray[counter] = node.val;
			counter++;
			node = node.right;				
		}
		
		
		return traversalArray;
	}
	
}
