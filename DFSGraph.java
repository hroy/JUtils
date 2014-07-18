import java.util.ArrayList;
import java.util.HashMap;


/**
 * 
 * 
 *
 */

public class DFSGraph {
	
	HashMap<dfsNode, ArrayList<dfsNode>> adjList;
	dfsNode root;
	int numVertices = 0;
	int[][] adjMatrix;

	public DFSGraph(int n) {
		this.root = null;
		adjList = new HashMap<dfsNode, ArrayList<dfsNode>>();
		this.numVertices = n;
		this.adjMatrix = new int[n][n];
	}

	public void addEdge(dfsEdge edge) {
		if(adjList.get(edge.startNode)==null)
		{
			ArrayList<dfsNode> list = new ArrayList<dfsNode>();
			list.add(edge.endNode);
			adjList.put(edge.startNode, list);
		}
		else
		{
			ArrayList<dfsNode> list = adjList.get(edge.startNode);
			list.add(edge.endNode);
		}
		
		adjMatrix[edge.startNode.data][edge.endNode.data] = 1;
	}

	public void dfs(dfsNode r) {
		if (r == null)
			return;

		System.out.print(r.data + ",");
		r.isVisited = 1;
		ArrayList<dfsNode> list = adjList.get(r);
		if(list!=null)
		{
			for (dfsNode n : list) {
				if (n.isVisited == 0)
					dfs(n);
			}
		}		
		r.isVisited = 2;
	}
	
	public void printAdjList()
	{
		for(dfsNode n: adjList.keySet())
		{
			System.out.print("Adjacent vertices of "+n.data+": ");
			ArrayList<dfsNode> list = adjList.get(n);
			for(dfsNode l: list)
			{
				System.out.print(l.data+", ");
			}
			System.out.print("\n");
		}
	}
	
	public void printAdjMatrix()
	{
		for(int i=0;i<this.numVertices;i++)
		{
			for(int j=0;j<this.numVertices;j++)
			{
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		// http://algs4.cs.princeton.edu/41undirected/DepthFirstSearch.java.html
		// https://gist.github.com/gennad/791932

		DFSGraph g = new DFSGraph(10);
		dfsNode[] nodes = new dfsNode[g.numVertices];
		
		for(int i=0;i<g.numVertices;i++)
		{
			nodes[i] = new dfsNode(i);
		}
					
		g.addEdge(new dfsEdge(nodes[0], nodes[1], ""));
		g.addEdge(new dfsEdge(nodes[0], nodes[2], ""));
		g.addEdge(new dfsEdge(nodes[1], nodes[3], ""));
		g.addEdge(new dfsEdge(nodes[1], nodes[4], ""));
		g.addEdge(new dfsEdge(nodes[2], nodes[5], ""));
		g.addEdge(new dfsEdge(nodes[2], nodes[6], ""));
		g.addEdge(new dfsEdge(nodes[4], nodes[7], ""));
		g.addEdge(new dfsEdge(nodes[4], nodes[8], ""));		
		g.addEdge(new dfsEdge(nodes[5], nodes[9], ""));
		g.addEdge(new dfsEdge(nodes[6], nodes[9], ""));
				
		g.root = nodes[0];		
		
		System.out.println("<<<<<<<<<<<<<<Adjacency Matrix>>>>>>>>>>>>");
		g.printAdjMatrix();
		
		System.out.println("\nDFS starting node: "+g.root.data);
		
		System.out.print("\nDFS visit order: ");
		g.dfs(g.root);
		System.out.println("");
	}
}

class dfsNode {
	int data;
	int isVisited;

	dfsNode(int d) {
		this.data = d;
		this.isVisited = 0;
	}
}

class dfsEdge {
	dfsNode startNode;
	dfsNode endNode;
	String level;

	dfsEdge(dfsNode s, dfsNode e, String lebel) {
		this.startNode = s;
		this.endNode = e;
		this.level = lebel;
	}

	dfsNode getStartNode() {
		return this.startNode;
	}

	dfsNode getEndNode() {
		return this.endNode;
	}
}
