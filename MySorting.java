import java.util.ArrayList;
import java.util.Random;


/**
 * 
 * @author H. Roy
 *
 */

public class MySorting<AnyType extends Comparable<AnyType>> {
	
	public int compareTo(AnyType t1, AnyType t2)
	{
		return t1.compareTo(t2);
	}
	
	public void BubbleSort(ArrayList<AnyType> list)
	{
		for(int i=list.size()-1;i>=0;i--)
		{
			for(int j=1;j<=i;j++)
			{
				if(list.get(j-1).compareTo(list.get(j))>0)
				{
					AnyType temp = list.get(j-1);
					list.set(j-1,list.get(j));
					list.set(j, temp);
				}
			}
		}
	}
	
	public void SelectionSort(ArrayList<AnyType> list)
	{
		for(int i=0;i<list.size()-1;i++)
		{
			int low = i;
			for(int j=i;j<list.size();j++)
			{
				if(list.get(j).compareTo(list.get(low))<0) low = j;
			}
			AnyType temp = list.get(i);
			list.set(i,list.get(low));
			list.set(low, temp);
		}
	}
	
	public void InsertionSort(ArrayList<AnyType> list)
	{
		for(int i=1;i<list.size();i++)
		{
			AnyType margin = list.get(i);
			int j = i;
			while(j>0 && list.get(j-1).compareTo(margin)>0)
			{
				list.set(j, list.get(j-1));
				j--;
			}
			list.set(j, margin);
		}
	}
	
	public ArrayList<AnyType> MergeSort(ArrayList<AnyType> list)
	{
		if(list==null) return null;
		if(list.size()<=1) return list;
		
		int middle = list.size()/2;
		ArrayList<AnyType> left = new ArrayList<AnyType>();
		ArrayList<AnyType> right = new ArrayList<AnyType>();
		
		for(int i=0; i<list.size();i++)
		{
			if(i>=middle) right.add(list.get(i));
			else left.add(list.get(i));
		}
		
		left = MergeSort(left);
		right = MergeSort(right);
		
		printList(Merge(left, right));
		return Merge(left, right);
	}
	
	public ArrayList<AnyType> Merge(ArrayList<AnyType> list1, ArrayList<AnyType> list2)
	{
		int i=0;
		int j=0;
		ArrayList<AnyType> merged = new ArrayList<AnyType>();
		
		while(i<list1.size() || j<list2.size())
		{
			if(i<list1.size() && j<list2.size())
			{
				if(list1.get(i).compareTo(list2.get(j))<=0)
				{
					merged.add(list1.get(i));
					i++;
				}
				else
				{
					merged.add(list2.get(j));
					j++;
				}
			}
			else if(i<list1.size())
			{				
				for(int m=i;m<list1.size();m++)
				{
					merged.add(list1.get(m));
				}
			}
			else if(j<list2.size())
			{
				for(int m=j;m<list2.size();m++)
				{
					merged.add(list2.get(m));
				}
			}
		}
		return merged;
	}
	
	public void QuickSort(ArrayList<AnyType> list)
	{}
	
	public void BucketSort(ArrayList<AnyType> list)
	{}
	
	public void HeapSort(ArrayList<AnyType> list)
	{}

	public void printList(ArrayList<AnyType> list)
	{
		System.out.print("List: ");
		for(int i=0;i<list.size();i++)
		{
			System.out.print(list.get(i) + ", ");
		}
		System.out.println("");
	}
	
	public void append(ArrayList<AnyType> list, ArrayList<AnyType> newlist, int index)
	{
		for(int i=index;i<newlist.size();i++)
		{
			list.add(newlist.get(i));
		}
	}
	
	public static void main(String[] args) {
		// https://www.cs.cmu.edu/~adamchik/15-121/lectures/Sorting%20Algorithms/sorting.html
		// http://thilinasameera.wordpress.com/2011/06/01/sorting-algorithms-sample-codes-on-java-c-and-matlab/
		
		MySorting<Integer> sort = new MySorting<Integer>();
		
		ArrayList<Integer> list = new ArrayList<Integer>();		
		for(int i=0;i<10;i++)
		{
			Random r = new Random();
			int v = r.nextInt(20);
			list.add(v);
		}
		
		sort.printList(list);
//		sort.BubbleSort(list);
//		sort.SelectionSort(list);
//		sort.InsertionSort(list);
		list = sort.MergeSort(list);
		sort.printList(list);
	}

}
