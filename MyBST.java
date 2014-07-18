/**
 * 
 * @author H. Roy
 * 
 */

public class MyBST {

	class TreeNode {
		int data;
		int level = 0;

		TreeNode parent;
		TreeNode left;
		TreeNode right;

		TreeNode(int d) {
			this.data = d;
			left = null;
			right = null;
			parent = null;
		}
	}

	TreeNode root;

	public MyBST() {
		root = null;
	}

	public void insert(int d) {
		TreeNode n = new TreeNode(d);

		if (root == null) {
			root = n;
		} else {
			TreeNode current = root;
			TreeNode parent = current;
			while (current != null) {
				parent = current;
				if (d < current.data) {
					current = current.left;
					if (current == null) {
						parent.left = n;
						return;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = n;
						return;
					}
				}
			}
		}
	}

	public TreeNode insert(TreeNode rt, int d) {
		if (rt == null) {
			rt = new TreeNode(d);
		} else {
			if (d < rt.data)
				rt.left = insert(rt.left, d);
			else
				rt.right = insert(rt.right, d);
		}

		return rt;
	}

	public TreeNode insert(int d, boolean isRecursive) {
		if (isRecursive)
			root = insert(root, d);
		else
			insert(d);

		return root;
	}

	public boolean find(TreeNode root, int d) {
		if (root == null)
			return false;

		if (root.data == d)
			return true;
		else if (d < root.data)
			return find(root.left, d);
		else
			return find(root.right, d);
	}

	public boolean find(int d) {
		return find(root, d);
	}

	/**
	 * Returns the number of nodes in the tree. Uses a recursive helper that
	 * recurs down the tree and counts the nodes.
	 */
	public int size() {
		return (size(root));
	}

	private int size(TreeNode node) {
		if (node == null)
			return (0);
		else {
			return (size(node.left) + 1 + size(node.right));
		}
	}

	/**
	 * Returns the max root-to-leaf depth of the tree. Uses a recursive helper
	 * that recurs down to find the max depth.
	 */
	public int maxDepth() {
		return (maxDepth(root));
	}

	private int maxDepth(TreeNode node) {
		if (node == null) {
			return (0);
		} else {
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			return (Math.max(lDepth, rDepth) + 1);
		}
	}

	/**
	 Changes the tree into its mirror image.

	 So the tree...
	       4
	      / \
	     2   5
	    / \
	   1   3

	 is changed to...
	       4
	      / \
	     5   2
	        / \
	       3   1

	 Uses a recursive helper that recurs over the tree,
	 swapping the left/right pointers.
	*/ 
	
	public void mirror() {
		mirror(root);
	}

	private void mirror(TreeNode node) {
		if (node != null) {
			mirror(node.left);
			mirror(node.right);

			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
	}

	/**
	 Changes the tree by inserting a duplicate node
	 on each nodes's .left.

	 So the tree...
	    2
	   / \
	  1   3

	 Is changed to...
	       2
	      / \
	     2   3
	    /   /
	   1   3
	  /
	 1

	 Uses a recursive helper to recur over the tree
	 and insert the duplicates.
	*/
	public void doubleTree() {
		doubleTree(root);
	}

	private void doubleTree(TreeNode node) {
		TreeNode oldLeft;
		if (node == null)
			return;

		doubleTree(node.left);
		doubleTree(node.right);

		oldLeft = node.left;
		node.left = new TreeNode(node.data);
		node.left.left = oldLeft;
	}
	
	/**
	 * Tests if a tree meets the conditions to be a binary search tree (BST).
	 * Uses the efficient recursive helper.
	 */
	public boolean isBST() {
		return (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	/**
	 * Efficient BST helper -- Given a node, and min and max values, recurs down
	 * the tree to verify that it is a BST, and that all its nodes are within
	 * the min..max range. Works in O(n) time -- visits each node only once.
	 */
	private boolean isBST(TreeNode node, int min, int max) {
		if (node == null) {
			return (true);
		} else {
			boolean leftOk = isBST(node.left, min, node.data);
			if (!leftOk)
				return (false);
			
			boolean rightOk = isBST(node.right, node.data + 1, max);
			return (rightOk);
		}
	}
	
	public void printTreePreorder(TreeNode current) {
		if (current == null)
			return;

		System.out.print(current.data + ", ");
		printTreePreorder(current.left);
		printTreePreorder(current.right);
	}

	public void printTreeInorder(TreeNode current) {
		if (current == null)
			return;

		printTreePreorder(current.left);
		System.out.print(current.data + ", ");
		printTreePreorder(current.right);
	}

	public void printTreePostorder(TreeNode current) {
		if (current == null)
			return;

		printTreePreorder(current.left);
		printTreePreorder(current.right);
		System.out.print(current.data + ", ");
	}

	public static void main(String[] args) {

		MyBST bstTree = new MyBST();
		for (int i = 0; i < 11; i += 2) {
			bstTree.insert(i, true);
		}

		for (int i = 1; i < 11; i += 2) {
			bstTree.insert(i, true);
		}
		System.out.println("Printing tree preorder...");
		bstTree.printTreePreorder(bstTree.root);
		System.out.println("");

		System.out.println("max depth: " + bstTree.maxDepth());
	}

}
