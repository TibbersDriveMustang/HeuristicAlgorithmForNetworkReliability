package hAlgorithms;

import NetworkElements.*;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;


import java.util.*;

public class branchAndBound {
	myGraph<Node,Edge> ShortestPathGraph;
	DijkstraShortestPath<Node,Edge> DSP;
	float totalGeometricCost;
	
	public branchAndBound(myGraph<Node,Edge> ShortestPathGraph){
		this.ShortestPathGraph = ShortestPathGraph;
	}
	
	public void pick(){
		for(Node node1: this.ShortestPathGraph.getVertices()){
			LinkedHashMap<Float,Node> stack = new LinkedHashMap<Float,Node>();
			System.out.println("==========For Node : " + node1 + "==============");
			float threshold = 0;
			//if(!node1.isFixed()){
			if(node1.getDegree() < 3){
				//node1.setFixed();
				for(Node node2: this.ShortestPathGraph.getVertices()){
					//if(!node2.isFixed() && node1 != node2){
					if( node1 != node2){
						float distance = this.getGeometricDistance(node1, node2);
						if(node1.getDegree() < 3){
							stack.put(distance, node2);
							if(distance > threshold){
								threshold = distance;
							}
							node1.increaseDegree();
							node2.increaseDegree();
						}
						else if(distance < threshold){
							stack.get(threshold).dercreaseDegree();
							stack.remove(threshold);
							stack.put(distance, node2);
							threshold = distance;
						}
						System.out.println("Nodes in Stack to be connected: " + stack);
					}
				}
			}
			//Create 3 minimun cost edges insert to graph
			for(float key : stack.keySet()){
				this.totalGeometricCost += key;   					//add to total cost
				Edge edge = new Edge(node1,stack.get(key),key);
				this.ShortestPathGraph.addEdge(edge, node1, stack.get(key));
				if(!checkDiameter(node1)){			//check diameter , from node1 to all others
					//this.ShortestPathGraph.removeEdge(edge);
					System.out.println("Edge adding will lead to diameter > 4, cancel adding action");
					this.ShortestPathGraph.removeEdge(edge);
				}
				else{
					//stack.get(key).increaseDegree();
					System.out.println("Edge Added : " + edge);
				}
			}

		}
		System.out.println("Total Cost: " + this.totalGeometricCost);
		//System.out.println("Edges : " + Arrays.asList(this.ShortestPathGraph.getEdges()));
	}
	/**
	 * Check diameter start from node one, if diameter <= 4, return true
	 * @param one
	 * @return
	 */
	private boolean checkDiameter(Node one){
		this.DSP = new DijkstraShortestPath<Node,Edge>(this.ShortestPathGraph);
		for(Node node: this.ShortestPathGraph.getVertices()){
			if(node != one){
				List<Edge> tempList = this.DSP.getPath(one, node);
				if(tempList.size() > 4){
					return false;
				}
			}
		}
		return true;
	}
	
	private float getGeometricDistance(Node one, Node two){
		return (float) Math.sqrt( Math.pow(one.getX() - two.getX(), 2) + Math.pow(one.getY() - two.getY(), 2) );
	}
}
