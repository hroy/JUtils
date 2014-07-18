import java.util.ArrayList;
import java.util.List;

import com.sun.jndi.toolkit.ctx.HeadTail;


/**
 *
 * @author H. Roy
 *
 */

public class MyLinkedList<AnyType> {
	
	class Node<AnyType> {

		AnyType data;
		Node<AnyType> Next = null;
		
		public Node(AnyType data)
		{
			this.data = data;
		}		
	}
	
	Node<AnyType> head = null;
	
	public void appendToTail(AnyType d)
	{
		Node<AnyType> end = new Node<AnyType>(d);
		Node<AnyType> n = head;
		
		if(n!=null)
		{
			while(n.Next!=null)
			{
				n = n.Next;
			}
			n.Next = end;
		}
		else
		{
			head = end;
		}
	}
	
	public void removeDuplicates(Node<AnyType> headNode, int method)
	{
		if(method==1)
		{
			ArrayList<AnyType> list = new ArrayList<AnyType>();
			Node<AnyType> prev = null;
			
			while(headNode!=null)
			{
				if(list.contains(headNode.data))
				{
					prev.Next = headNode.Next;
				}
				else
				{
					prev = headNode;
					list.add(headNode.data);									
				}
				headNode = headNode.Next;
			}
		}
		else if(method==2)
		{
			if(headNode==null) return;
			
			Node<AnyType> prev = headNode;
			Node<AnyType> current = headNode.Next;
			
			while(current!=null)
			{
				Node<AnyType> runner = headNode;
				while(runner!=current)
				{
					if(runner.data==current.data)
					{
						Node<AnyType> tmp = current.Next;
						prev.Next = tmp;
						current = tmp;
						break;
					}
					runner = runner.Next;
				}
				if(runner==current)
				{
					prev = current;
					current = current.Next;
				}
			}
		}
	}
	
	public AnyType nthLastElement(Node<AnyType> headNode, int n)
	{
		Node<AnyType> tail = headNode;
		Node<AnyType> current = headNode;
		
		while(n>=2 && tail!=null)
		{
			tail = tail.Next;
			n--;
		}
		
		if(tail==null) return null;
		
		while(tail.Next!=null)
		{
			current = current.Next;
			tail = tail.Next;
		}		
		
		return current.data;
	}

	public void printLinkedList()
	{
		System.out.println("Printing Linked List...");
		
		Node<AnyType> temp = head;
		while(temp!=null)
		{
			System.out.print(temp.data+", ");
			temp = temp.Next;
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		
//		LinkedList<Integer> intLinkList = new LinkedList<Integer>();		
//		for(int i=0;i<11;i++)
//		{
//			intLinkList.appendToTail(i);
//		}
//		intLinkList.printLinkedList();
		
//		LinkedList<Double> dblLinkList = new LinkedList<Double>();		
//		for(double i=0.5;i<11.5;i++)
//		{
//			dblLinkList.appendToTail(i);
//		}
//		dblLinkList.printLinkedList();
		
//		LinkedList<Integer> intLinkList = new LinkedList<Integer>();		
//		for(int i=0;i<11;i+=2)
//		{
//			intLinkList.appendToTail(i);
//		}		
//		for(int i=0;i<11;i++)
//		{
//			intLinkList.appendToTail(i);
//		}		
//		intLinkList.printLinkedList();
//		
//		intLinkList.removeDuplicates(intLinkList.head, 2);
//		intLinkList.printLinkedList();
		
//		LinkedList<Integer> intLinkList = new LinkedList<Integer>();
//		for(int i=0;i<11;i++)
//		{
//			intLinkList.appendToTail(i);
//		}		
//		intLinkList.printLinkedList();		
//		System.out.println("nth: " + intLinkList.nthLastElement(intLinkList.head, 5));
	}

}
