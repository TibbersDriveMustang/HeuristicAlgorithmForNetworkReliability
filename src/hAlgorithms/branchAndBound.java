package hAlgorithms;

import NetworkElements.*;
import java.util.*;

public class branchAndBound {
	myGraph<Node,Edge> ShortestPathGraph;
	public branchAndBound(myGraph<Node,Edge> ShortestPathGraph){
		this.ShortestPathGraph = ShortestPathGraph;
	}
	
	public void pick(){
		for(Node node1: this.ShortestPathGraph.getVertices()){
			LinkedHashMap<Float,Node> stack = new LinkedHashMap<Float,Node>();
			float threshold = Float.MAX_VALUE;
			int count = 0;
			if(!node1.isFixed()){
				node1.setFixed();
				for(Node node2: this.ShortestPathGraph.getVertices()){
					if(!node2.isFixed() && node1 != node2){
						float distance = this.getGeometricDistance(node1, node2);
						if(count < 3){
							stack.put(distance, node2);
						}
						else if(distance < threshold){
							stack.remove(threshold);
							stack.put(distance, node2);
							threshold = distance;
						}
					}
				}
			}

			System.out.println(Arrays.asList(stack));
			//Create 3 minimun cost edges insert to graph
			for(float key : stack.keySet()){
				Edge edge = new Edge(node1,stack.get(key),key);
				this.ShortestPathGraph.addEdge(edge, node1, stack.get(key));
			}
		}
		System.out.println("Edges : " + Arrays.asList(this.ShortestPathGraph.getEdges()));
	}
	
	private float getGeometricDistance(Node one, Node two){
		return (float) Math.sqrt( Math.pow(one.getX() - two.getX(), 2) + Math.pow(one.getY() - two.getY(), 2) );
	}
}
