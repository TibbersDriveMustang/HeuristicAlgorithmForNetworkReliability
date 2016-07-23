package test;

import java.util.*;
import NetworkElements.*;
import Visual.drawGraph;
import hAlgorithms.*;
import edu.uci.ics.jung.algorithms.*;
public class runTest {
	Node[] nodes;
	ArrayList<Edge> edges;
	myGraph<Node,Edge> ShortestPathGraph;
	branchAndBound BB;
	public runTest(){
		nodes = new Node[15];
		this.ShortestPathGraph = new myGraph();
	}
	
	public static void main(String args[]){
		runTest test1 = new runTest();
		Test testBed = new Test();
		testBed.setRandomCoordinates(test1.nodes);
		drawGraph graph1 = new drawGraph("Test");
    	graph1.setSize(1000,1000);
    	graph1.setVisible(true);
		graph1.addNodes(test1.nodes);
		test1.ShortestPathGraph.addVertices(test1.nodes);
		System.out.println("Nodes added to ShortestPathGraph: " + Arrays.asList(test1.ShortestPathGraph.getVertices()));
		test1.BB = new branchAndBound(test1.ShortestPathGraph);
		test1.BB.pick();
		graph1.addEdges(test1.ShortestPathGraph.getEdges());
	}
}
