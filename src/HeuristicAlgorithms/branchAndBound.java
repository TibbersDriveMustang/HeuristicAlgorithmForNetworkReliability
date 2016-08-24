package HeuristicAlgorithms;

import NetworkElements.*;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;


import java.util.*;

public class branchAndBound {
	public myGraph<Node,Edge> ShortestPathGraph;
	DijkstraShortestPath<Node,Edge> DSP;
	float totalGeometricCost;	
		
	/**
	 * for each node, pick its 3 least cost outgoing edges, added to graph, then set this node as fixed, going to next node
	 */
	public void pick(){
		List<Node> temp = new ArrayList<Node>(this.ShortestPathGraph.getVertices());
		Collections.shuffle(temp);
		for(Node node1: temp/*this.ShortestPathGraph.getVertices()*/){
			LinkedHashMap<Float,Node> stack = new LinkedHashMap<Float,Node>();
			System.out.println("==========For Node : " + node1 + "============== degree" + node1.getDegree() );
			float threshold = 0;
			if(node1.getDegree() < 3){
				for(Node node2: this.ShortestPathGraph.getVertices()){
					if( node1 != node2){
						float distance = this.getGeometricDistance(node1, node2);
						if(node1.getDegree() < 3){
							stack.put(distance, node2);
							Edge edge = new Edge(node1,stack.get(distance),distance);
							this.ShortestPathGraph.addEdge(edge, node1, stack.get(distance));
							if(!checkDiameter(node1)){			//check diameter , from node1 to all others
								//this.ShortestPathGraph.removeEdge(edge);
								System.out.println("Edge adding will lead to diameter > 4, cancel adding action");
								this.ShortestPathGraph.removeEdge(edge);
								stack.remove(distance);
								continue;
							}
							this.ShortestPathGraph.removeEdge(edge);
							if(distance > threshold){
								threshold = distance;
							}
							node1.increaseDegree();
							node2.increaseDegree();
						}
						else if(distance < threshold){
							//stack.get(threshold).dercreaseDegree();
							Edge edge = new Edge(node1,node2,distance);
							this.ShortestPathGraph.addEdge(edge, node1, node2);
							if(!checkDiameter(node1)){			//check diameter , from node1 to all others
								//this.ShortestPathGraph.removeEdge(edge);
								System.out.println("Edge adding will lead to diameter > 4, cancel adding action");
								this.ShortestPathGraph.removeEdge(edge);
								continue;
							}
							this.ShortestPathGraph.removeEdge(edge);
							stack.remove(threshold);
							stack.put(distance, node2);
							threshold = distance;
						}
					}
				}
			}
			//Create 3 minimun cost edges insert to graph
			for(float key : stack.keySet()){
				this.totalGeometricCost += key;   					//add to total cost
				Edge edge = new Edge(node1,stack.get(key),key);
				this.ShortestPathGraph.addEdge(edge, node1, stack.get(key));
			}

		}
		System.out.println("Branch and Bound Total Geometric Cost: " + this.totalGeometricCost);
		//System.out.println("Edges : " + Arrays.asList(this.ShortestPathGraph.getEdges()));
	}
	
	
	private void resetEdges(){
		for(Edge edge : this.ShortestPathGraph.getEdges()){
			this.ShortestPathGraph.removeEdge(edge);
		}
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
