package main;
import java.util.Stack;
import ds.*;

public class RecursiveTreeLCA {
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
//		tree.left = new TreeNode(2);
//		tree.left.left = new TreeNode(3);
//		tree.left.left.left = new TreeNode(4);
//		tree.left.left.right = new TreeNode(5);
		tree.left = new TreeNode(0);
		//     1 
		//   2
		//  3  
		//4   5
		Stack<TreeNode> firstPath = get_path(tree, 1);
		Stack<TreeNode> secondPath = get_path(tree, 1);
		System.out.println(firstPath.toString());
		System.out.println(secondPath.toString());
		
		TreeNode LCA = null;
		int shortestQueue = Math.min(firstPath.size(), secondPath.size());
		for (int i = 0; i < shortestQueue; i++) {
			TreeNode first = firstPath.pop();
			TreeNode second = secondPath.pop();
			if (first.equals(second)) {
				LCA = first;
			}
		}
		System.out.println(LCA.val);
		
	}
	// 
	public static Stack<TreeNode> get_path(TreeNode T, int x) {
		if (T == null) {
			return null;		
		}
		else if (T.val == x) {
			Stack<TreeNode> q = new Stack<>();
			q.add(T);
			return q;
		}
		else {
			TreeNode[] children = new TreeNode[]{T.left, T.right}; 
			for (TreeNode node: children)  {
				Stack<TreeNode> myStack = get_path(node, x);
				if (myStack != null) {
					myStack.add(T);
					return myStack;
				}			
			}
		}
		return null;
	}
}
