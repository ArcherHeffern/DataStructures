package ds;

public class NaryTreeLCA {
	
	//  Definition for a binary tree node.
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	    // works for an n-ary tree
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if (root == null || root.equals(p) || root.equals(q)) {
	            return root;
	        }
	        TreeNode first = null;
	        TreeNode second = null;
	        TreeNode[] nodes = {root.left, root.right};
	        for (TreeNode node: nodes) {
	            TreeNode temp = lowestCommonAncestor(node, p, q);
	            if (first == null) {
	                first = temp;
	            }
	            else {
	                second = temp;
	            }
	        }
	// two ancestors were found
	        if (second != null) {
	            return root;
	        }
	// one ancestor was found
	        else if (first != null) {
	            return first;
	        }
	        // no ancestor was found
	        else return null;

	    }
	}
