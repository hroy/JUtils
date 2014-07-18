import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author H. Roy
 * 
 */

public class MyGraph<AnyType> {

	HashMap<Node<AnyType>, ArrayList<Node<AnyType>>> adjList;
	Node<AnyType> root;

	public MyGraph() {
		this.root = null;
		adjList = new HashMap<Node<AnyType>, ArrayList<Node<AnyType>>>();
	}

	public void addEdge(Edge<AnyType> edge) {
		if(adjList.get(edge.startNode)==null)
		{
			ArrayList<Node<AnyType>> list = new ArrayList<Node<AnyType>>();
			list.add(edge.endNode);
			adjList.put(edge.startNode, list);
		}
		else
		{
			ArrayList<Node<AnyType>> list = adjList.get(edge.startNode);
			list.add(edge.endNode);
		}
	}

	public void dfs(Node<AnyType> r) {
		if (r == null)
			return;

		System.out.print(r.data + ",");
		r.isVisited = 1;
		ArrayList<Node<AnyType>> list = adjList.get(r);
		if(list!=null)
		{
			for (Node<AnyType> n : list) {
				if (n.isVisited == 0)
					dfs(n);
			}
		}		
		r.isVisited = 2;
	}
	
	public void bfs(Node<AnyType> r) {
		if (r == null)
			return;
		
		final MyStackQueue<Node<AnyType>> Q = new MyStackQueue<Node<AnyType>>();
		
		while(r!=null)
		{
			System.out.print(r.data + ",");
			ArrayList<Node<AnyType>> list = adjList.get(r);
			if(list!=null)
			{
				for (Node<AnyType> n : list) {
					Q.enqueue(n);
				}
			}
			r = Q.dequeue();
		}		
	}

	public static void main(String[] args) {
		// http://algs4.cs.princeton.edu/41undirected/DepthFirstSearch.java.html
		// https://gist.github.com/gennad/791932

		MyGraph<Integer> g = new MyGraph<>();
		
		Node<Integer> n0 = new Node<Integer>(0);
		Node<Integer> n1 = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(2);
		Node<Integer> n3 = new Node<Integer>(3);
		Node<Integer> n4 = new Node<Integer>(4);
		Node<Integer> n5 = new Node<Integer>(5);
		Node<Integer> n6 = new Node<Integer>(6);
		Node<Integer> n7 = new Node<Integer>(7);
		Node<Integer> n8 = new Node<Integer>(8);
		Node<Integer> n9 = new Node<Integer>(9);
		Node<Integer> n10 = new Node<Integer>(10);
		
		
		g.addEdge(new Edge<Integer>(n0, n1, ""));
		g.addEdge(new Edge<Integer>(n0, n2, ""));
		g.addEdge(new Edge<Integer>(n1, n3, ""));
		g.addEdge(new Edge<Integer>(n1, n4, ""));
		g.addEdge(new Edge<Integer>(n2, n5, ""));
		g.addEdge(new Edge<Integer>(n2, n6, ""));
		g.addEdge(new Edge<Integer>(n3, n7, ""));
		g.addEdge(new Edge<Integer>(n3, n8, ""));		
		g.addEdge(new Edge<Integer>(n4, n9, ""));
		g.addEdge(new Edge<Integer>(n4, n10, ""));
		
		g.root = n0;
		
		System.out.print("DFS visit order: ");
		g.dfs(g.root);
		System.out.println("");
		
		System.out.print("BFS visit order: ");
		g.bfs(g.root);
		System.out.println("");
	}
}

class Node<AnyType> {
	AnyType data;
	int isVisited;

	Node(AnyType d) {
		this.data = d;
		this.isVisited = 0;
	}
}

class Edge<AnyType> {
	Node<AnyType> startNode;
	Node<AnyType> endNode;
	String level;

	Edge(Node<AnyType> s, Node<AnyType> e, String lebel) {
		this.startNode = s;
		this.endNode = e;
		this.level = lebel;
	}

	Node<AnyType> getStartNode() {
		return this.startNode;
	}

	Node<AnyType> getEndNode() {
		return this.endNode;
	}
}
