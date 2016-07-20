package test;
import java.util.*;
import NetworkElements.*;
public class Test {
	Node[] nodes;
	List<Edge> edges;
	List<Integer> coordinateList;
	
	public Test(){
		//15 nodes
		nodes = new Node[15];
		
		coordinateList = new ArrayList<Integer>();
		coordinateList.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9));
	}
	
	public void setRandomCoordinates(Node[] nodes){
		//x and y
		//from 0 to 9
		HashSet<Node> temp = new HashSet<Node>();
		for(Node node : nodes){
			int x = (int)(Math.random() * 10);
			int y = (int)(Math.random() * 10);
			while(!temp.add(new Node(x,y))){
				x = (int)(Math.random() * 10);
				y = (int)(Math.random() * 10);
				System.out.println("Not add");
			}
			node = new Node(x,y);
			System.out.println("" + x + " " + y);
		}
	} 
	
	
	public static void main(String args[]){
		Test test = new Test();
		test.setRandomCoordinates(test.nodes);
	}
}
