package test;
import java.util.*;
import NetworkElements.*;
import Visual.drawGraph;
public class Test {
	drawGraph frame;
	
	public Test(){
	}
	/**
	 * Assign random coordinates for all nodes and avoid duplicate
	 * @param nodes
	 * arrays for all nodes
	 */
	public void setRandomCoordinates(Node[] nodes){
		//x and y
		//from 0 to 9
		HashSet<Node> temp = new HashSet<Node>();
		for(int i = 0 ; i < nodes.length; i ++){
			int x = (int)(Math.random() * 10);
			int y = (int)(Math.random() * 10);
			while(!temp.add(new Node(x,y))){
				x = (int)(Math.random() * 10);
				y = (int)(Math.random() * 10);
				System.out.println("Not add");
			}
			nodes[i] = new Node(x * 100,y * 100);
			System.out.println("" + x + " " + y);
		}
	} 
}
