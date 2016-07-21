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
			this.nodes.add(node);
			this.repaint();
		}
		
	}
	
	public void addEdges(ArrayList<Edge> edges){
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
		int nodeHeight = Math.max(this.height, f.getHeight());
		g.setColor(Color.black);
		for(Edge e: edges){
			g.drawLine(e.getNodeOne().getX(), e.getNodeOne().getY(), e.getNodeTwo().getX(), e.getNodeTwo().getY());
		}
		for(Node n : nodes){
			int nodeWidth = Math.max(this.width, f.stringWidth(n.toString()) + width/2);
			g.setColor(Color.white);
			g.fillOval(n.getX() - nodeWidth/2, n.getY() - nodeHeight/2, nodeWidth, nodeHeight);
			g.setColor(Color.black);
			g.drawOval(n.getX()-nodeWidth/2, n.getY()-nodeHeight/2, nodeWidth, nodeHeight);
			g.drawString(n.toString(), n.getX()-f.stringWidth(n.toString())/2, n.getY()+f.getHeight()/2);
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
