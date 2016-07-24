package test;

import java.util.*;

import HeuristicAlgorithms.*;
import NetworkElements.*;
import Visual.drawGraph;
import edu.uci.ics.jung.algorithms.*;
public class runTest {
	private Node[] nodes;
	private ArrayList<Edge> edges;
	private myGraph<Node,Edge> ShortestPathGraph;
	private branchAndBound BB;
	public runTest(){
		nodes = new Node[15];
		edges = new ArrayList();
		this.ShortestPathGraph = new myGraph();
	}
	
	public static void main(String args[]){
		
		Test testBed = new Test();
		Node[] nodes = testBed.setRandomCoordinates();
		runTest test1 = new runTest();
		runTest test2 = new runTest();
		drawGraph graph1 = new drawGraph("Test1");
		drawGraph graph2 = new drawGraph("Test2");
		
			graph1.setSize(1000,1000);
			graph1.setVisible(true);
			graph1.addNodes(nodes);
			test1.ShortestPathGraph.addVertices(nodes);
			System.out.println("Nodes added to ShortestPathGraph: " + Arrays.asList(test1.ShortestPathGraph.getVertices()));
			test1.BB = new branchAndBound(test1.ShortestPathGraph);
			test1.BB.pick();
			graph1.addEdges(test1.ShortestPathGraph.getEdges());
		
			//graph2.setSize(1000,1000);
			//graph2.setVisible(true);
			//graph2.addNodes(nodes);
			//test2.ShortestPathGraph.addVertices(nodes);
/*		
			graph2.setSize(1000,1000);
			graph2.setVisible(true);
			graph2.addNodes(nodes);
			test2.ShortestPathGraph.addVertices(nodes);
			System.out.println("Nodes added to ShortestPathGraph: " + Arrays.asList(test2.ShortestPathGraph.getVertices()));
			test2.BB = new branchAndBound(test2.ShortestPathGraph);
			test2.BB.pick();
			graph2.addEdges(test2.ShortestPathGraph.getEdges());
*/		
		
	}
}
