package HeuristicAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import NetworkElements.Edge;
import NetworkElements.Node;
import NetworkElements.myGraph;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;

/**
 * 
 * @author Tibbers
 * For each round, we iterate through all nodes, each node select its minimum cost edge(if not been selected), after 3 round, each node
 * will have a degree of 3, then we check if the graph`s diameter is no more than 4, if yes, iterate one more round, each time add one 
 * edge and check the diameter, until it meets the requirement 
 */
public class greedyLocalSearch {
	private myGraph<Node,Edge> ShortestPathGraph;
	private DijkstraShortestPath<Node,Edge> DSP;
	private float totalGeometricCost;
	private List<Node> nodes;
	
	public greedyLocalSearch(Node[] nodes){
		this.ShortestPathGraph = new myGraph<Node,Edge>();
		this.nodes = Arrays.asList(nodes);
		this.nextRound();
		this.nextRound();
		this.nextRound();
		this.overallDiameter();
		System.out.println("Greedy Local Search Total GeometricCost: " + this.totalGeometricCost);
	}
	public myGraph<Node,Edge> getShortestPathGraph(){
		return this.ShortestPathGraph;
	}
	/**
	 * run 3 rounds to see if all nodes has degree >= 3, and the diameter <= 4
	 */
	public void nextRound(){
		List<Node> tempNodes = new ArrayList(Arrays.asList(nodes));
		Collections.shuffle(tempNodes);
		for(int i = 0; i < nodes.size(); i++){
			float nextMin = Float.MAX_VALUE;
			Node index = null;
			for(int j = i + 1; j < nodes.size(); j++){
				float distance = this.getGeometricDistance(nodes.get(i),nodes.get(j));
				if(distance <= nextMin && distance > nodes.get(i).getDistanceThreshold()){
					index = nodes.get(j);
					nextMin = distance;
				}
			}
			if(index != null){
				nodes.get(i).setDistanceThreshold(nextMin);
				Edge edge = new Edge(nodes.get(i),index,nextMin);
				this.ShortestPathGraph.addEdge(edge, nodes.get(i), index);
				this.totalGeometricCost += nextMin;
			}
		}
	}
	
	private void overallDiameter(){
		for(Node one : this.nodes){
			float min = Float.MAX_VALUE;
			Node temp = null;
			if(!checkDiameter(one)){
				for(Node two : nodes){
					if(one == two){
						continue;
					}
					if(this.getGeometricDistance(one, two) < min){
						Edge edge = new Edge(one,two,this.getGeometricDistance(one, two));
						if(!this.ShortestPathGraph.containsEdge(edge)){
							min = this.getGeometricDistance(one, two);
							temp = two;
						}
					}
				}
			}
			if(temp != null){
				Edge edge = new Edge(one,temp,this.getGeometricDistance(one, temp));
				this.ShortestPathGraph.addEdge(edge, one, temp);
				this.totalGeometricCost += this.getGeometricDistance(one, temp);
			}
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
