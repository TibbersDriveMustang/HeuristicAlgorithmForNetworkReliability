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
    	test1.nodes[0] = new Node(1,2);//manual added
    	graph1.setVisible(true);
		graph1.addNodes(test1.nodes);
		graph1.addEdges(test1.edges);
    	
		
		System.out.println(Arrays.asList(test1.nodes));//null null null null

		
	}
}
