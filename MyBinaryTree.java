/**
 * 
 * @author H. Roy
 * 
 */

public class MyBinaryTree<AnyType> {

	class TreeNode<AnyType> {
		AnyType data;
		int level=0;
		
		TreeNode<AnyType> parent;
		TreeNode<AnyType> left;
		TreeNode<AnyType> right;

		TreeNode(AnyType d) {
			this.data = d;
			left = null;
			right = null;
			parent = null;
		}
	}

	TreeNode<AnyType> root;

	public MyBinaryTree() {
		root = null;
	}

	public void insert(AnyType d)
	{
		TreeNode<AnyType> n = new TreeNode<AnyType>(d);
		
		if(root==null)
		{
			root = n;
		}
		else
		{
			TreeNode<AnyType> current = root;
			MyStackQueue<TreeNode<AnyType>> SQ = new MyStackQueue<TreeNode<AnyType>>();
			
			while(current.left!=null && current.right!=null)
			{
				SQ.enqueue(current.left);
				SQ.enqueue(current.right);
				
				current = SQ.dequeue();
			}
			if(current.left==null) current.left = n;
			else if(current.right==null) current.right = n;
		}
	}
	
	//replace by last element
	public void delete(TreeNode<AnyType> node, AnyType d)
	{
		if(node==null) return;
		if(node.data==d)
		{
			TreeNode<AnyType> current = root;
			TreeNode<AnyType> last = current;
			MyStackQueue<TreeNode<AnyType>> SQ = new MyStackQueue<TreeNode<AnyType>>();
			
			while(current!=null)
			{
				last = current;
				if(current.left!=null) SQ.enqueue(current.left);
				if(current.right!=null) SQ.enqueue(current.right);
				
				current = SQ.dequeue();
			}
			node.data = last.data;
			last.data = null;
			return;
		}
		
		delete(node.left,d);
		delete(node.right,d);
	}
	
	public void printTreePreorder(TreeNode<AnyType> current)
	{
		if(current==null) return;
		
		System.out.print(current.data+", ");
		printTreePreorder(current.left);
		printTreePreorder(current.right);
	}
	
	public void printTreeInorder(TreeNode<AnyType> current)
	{
		if(current==null) return;		
		
		printTreePreorder(current.left);
		System.out.print(current.data+", ");
		printTreePreorder(current.right);
	}
	
	public void printTreePostorder(TreeNode<AnyType> current)
	{
		if(current==null) return;		
		
		printTreePreorder(current.left);		
		printTreePreorder(current.right);
		System.out.print(current.data+", ");
	}
	
	public static void main(String[] args) {
		
		/*
		 * http://homepage.cs.uiowa.edu/~sriram/21/spring07/code/tree.java
		 * http://www.cs.dartmouth.edu/~cs10/hws/SA-7/BinaryTree.java
		 * http://cslibrary.stanford.edu/110/BinaryTrees.html 
		 */

		MyBinaryTree<Integer> intTree = new MyBinaryTree<Integer>();
		for(int i=0;i<11;i++)
		{
			intTree.insert(i);
		}
		System.out.println("Printing tree preorder...");
		intTree.printTreePreorder(intTree.root);
		System.out.println("");
		
		intTree.delete(intTree.root, 6);
		System.out.println("Printing tree preorder...");
		intTree.printTreePreorder(intTree.root);
		System.out.println("");	
	}

}
