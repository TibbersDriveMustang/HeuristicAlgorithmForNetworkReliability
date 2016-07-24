package Visual;

import javax.swing.*;
import java.awt.*;

import java.util.*;
import NetworkElements.*;
public class drawGraph extends JFrame{
	int width;
	int height;
	
	ArrayList<Node> nodes;
	ArrayList<Edge> edges;
	/**
	 * Constructor
	 */
	public drawGraph(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
		width = 1000;
		height = 1000;
		this.setSize(1000,1000);
		this.setVisible(true);
	}
	/**
	 * Constructor 2
	 * @param name
	 */
	public drawGraph(String name){
		this.setTitle(name);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
		width = 1000;
		height = 1000;
		this.setSize(1000,1000);
		
	}
	/*
	 * Add all nodes to graph
	 */
	public void addNodes(Node[] nodes){
		for(Node node : nodes){
			if(this.nodes.add(node)){
				System.out.println("Node added : " + node);
			}
			this.repaint();
		}
		
	}
	
	public void addEdges(ArrayList<Edge> edges){
		for(Edge edge: edges){
			this.edges.add(edge);
			this.repaint();
		}
	}
	
	public void addEdges(Collection<Edge> edges){
		for(Edge edge: edges){
			this.edges.add(edge);
			this.repaint();
		}		
	}
	
	public void showGraph(){
		this.setVisible(true);
	}
	
	public void paint(Graphics g){
		FontMetrics f = g.getFontMetrics();
		int nodeHeight = 5;//Math.max(this.height, f.getHeight());
		g.setColor(Color.blue);
		for(Edge e: edges){
			g.drawLine(50 + e.getNodeOne().getX() * 50, 50 + e.getNodeOne().getY() * 50, 50 + e.getNodeTwo().getX() * 50, 50 + e.getNodeTwo().getY() * 50);
		}
		for(Node n : nodes){
			int nodeWidth = 5;//Math.max(this.width, f.stringWidth(n.toString()) + width/2);
			g.setColor(Color.red);
			g.fillOval(50 + n.getX() * 50 - nodeWidth/2, 50 + n.getY() * 50 - nodeHeight/2, nodeWidth, nodeHeight);
			g.setColor(Color.black);
			g.drawOval(50 + n.getX() * 50 - nodeWidth/2, 50 + n.getY() * 50 - nodeHeight/2, nodeWidth, nodeHeight);
			g.drawString("(" + n.getX() + "," + n.getY() + ")" , 50 + n.getX() * 50 - f.stringWidth(n.toString())/2, 60 + n.getY() * 50 + f.getHeight()/2);
		}
	}
/*	
	public static void main(String[] args){
		drawGraph frame = new drawGraph("Test Window");
		
		frame.setSize(1000,1000);
		frame.setVisible(true);
		//add nodes add edges
	}
*/
}
