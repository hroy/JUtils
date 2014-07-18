
/**
 *
 * @author H. Roy
 *
 */

public class MyStackQueue<AnyType> {
	
	class Element<AnyType> {

		AnyType data;
		Element<AnyType> Next = null;
		
		public Element(AnyType data)
		{
			this.data = data;
		}		
	}

	Element<AnyType> top = null;
	Element<AnyType> first=null, last;
	
	//using linked list
	public void push(AnyType d)
	{
		Element<AnyType> n = new Element<AnyType>(d);
		n.Next = top;
		top = n;
	}
	
	//using linked list
	public AnyType pop()
	{
		if(top!=null)
		{
			AnyType ret = top.data;
			top = top.Next;
			return ret;
		}
		return null;
	}
	
	public AnyType peek()
	{
		if(top!=null)
		{
			AnyType ret = top.data;
			return ret;
		}
		return null;
	}
	
	public boolean isStackEmpty()
	{
		if(top==null) return true;
		else return false;
	}
	
	public void printStack()
	{
		System.out.println("Printing Stack...");
		Element<AnyType> temp = top;
		while(temp!=null)
		{
			System.out.print(temp.data + ", ");
			temp = temp.Next;
		}
		System.out.println("");
	}
	
	public void enqueue(AnyType d)
	{
		Element<AnyType> n = new Element<AnyType>(d);
		if(first==null)
		{
			first = n;
			last = n;
		}
		else
		{
			last.Next = n;
			last = last.Next;
		}
	}
	
	public AnyType dequeue()
	{
		if(first!=null)
		{
			AnyType ret = first.data;
			first = first.Next;
			return ret;
		}
		
		return null;
	}
	
	public void printQueue()
	{
		System.out.println("Printing Queue...");
		
		Element<AnyType> temp = first;
		while(temp!=null)
		{
			System.out.print(temp.data + ", ");
			temp = temp.Next;
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		
		MyStackQueue<Integer> intSQ = new MyStackQueue<Integer>();
		for(int i=0;i<11;i++)
		{
			intSQ.push(i);			
		}		
		intSQ.printStack();
		intSQ.pop();
		intSQ.pop();
		intSQ.printStack();		
		
		for(int i=0;i<11;i++)
		{
			intSQ.enqueue(i);			
		}		
		intSQ.printQueue();
		intSQ.dequeue();
		intSQ.dequeue();
		intSQ.printQueue();
		
		MyStackQueue<Double> dblSQ = new MyStackQueue<Double>();
		for(double i=0.5;i<11.5;i++)
		{
			dblSQ.push(i);			
		}		
		dblSQ.printStack();
		dblSQ.pop();
		dblSQ.pop();
		dblSQ.printStack();		
		
		for(double i=0.5;i<11.5;i++)
		{
			dblSQ.enqueue(i);			
		}		
		dblSQ.printQueue();
		dblSQ.dequeue();
		dblSQ.dequeue();
		dblSQ.printQueue();
	}
}
