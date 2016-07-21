package test;

import java.util.*;
import NetworkElements.Edge;
import NetworkElements.Node;
import Visual.drawGraph;
public class runTest {
	Node[] nodes;
	ArrayList<Edge> edges;
	List<Integer> coordinateList;
	public runTest(){
		nodes = new Node[15];
		edges = new ArrayList<Edge>();
	}
	
	public static void main(String args[]){
		runTest test1 = new runTest();
		Test testBed = new Test();
		testBed.setRandomCoordinates(test1.nodes);
		drawGraph graph1 = new drawGraph("Test");
    	graph1.setSize(1000,1000);
    	graph1.setVisible(true);
		graph1.addNodes(test1.nodes);
		graph1.addEdges(test1.edges);
	}
}
