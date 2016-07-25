package test;

import java.util.*;

import HeuristicAlgorithms.*;
import NetworkElements.*;
import Visual.drawGraph;
import edu.uci.ics.jung.algorithms.*;
public class runTest {
	private Node[] nodes;
	private ArrayList<Edge> edges;
	//private myGraph<Node,Edge> ShortestPathGraph;
	branchAndBound BB;
	public runTest(){
		nodes = new Node[15];
		edges = new ArrayList();
		this.BB = new branchAndBound();
	}
	
	public static void main(String args[]){
		
		Test testBed = new Test();
		Node[] nodes = new Node[15];//testBed.setRandomCoordinates();
		//(0,1), (6,9), (3,8), (3,9), (7,9), (7,4), (1,7), (8,3), (5,9), (2,4), (9,5), (2,6), (9,1), (9,0), (3,0)
		nodes[0] = new Node(0,1);
		nodes[1] = new Node(6,9);
		nodes[2] = new Node(3,8);
		nodes[3] = new Node(3,9);
		nodes[4] = new Node(7,9);
		nodes[5] = new Node(7,4);
		nodes[6] = new Node(1,7);
		nodes[7] = new Node(8,3);
		nodes[8] = new Node(5,9);
		nodes[9] = new Node(2,4);
		nodes[10] = new Node(9,5);
		nodes[11] = new Node(2,6);
		nodes[12] = new Node(9,1);
		nodes[13] = new Node(9,0);
		nodes[14] = new Node(3,0);
	
		runTest test1 = new runTest();
		runTest test2 = new runTest();
		drawGraph graph1 = new drawGraph("Test1");
		drawGraph graph2 = new drawGraph("Test2");
		
		graph1.setSize(1000,1000);
		graph1.setVisible(true);
		graph1.addNodes(nodes);
		test1.BB.ShortestPathGraph = new myGraph();
		test1.BB.ShortestPathGraph.addVertices(nodes);
		System.out.println("Nodes added to ShortestPathGraph: " + Arrays.asList(test1.BB.ShortestPathGraph.getVertices()));
		test1.BB.pick();
		//graph1.addEdges(test1.BB.ShortestPathGraph.getEdges());
		
		greedyLocalSearch GLS = new greedyLocalSearch(nodes);
		graph1.addEdges(GLS.getShortestPathGraph().getEdges());
/*	
		graph2.setSize(1000,1000);
		graph2.setVisible(true);
		graph2.addNodes(nodes);
		test2.BB.ShortestPathGraph = new myGraph();
		test2.BB.ShortestPathGraph.addVertices(nodes);
		System.out.println("Nodes added to ShortestPathGraph: " + Arrays.asList(test2.BB.ShortestPathGraph.getVertices()));
		test2.BB.pick();
		graph2.addEdges(test2.BB.ShortestPathGraph.getEdges());
*/		
		
	}
}
