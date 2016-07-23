package NetworkElements;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import edu.uci.ics.jung.graph.util.Pair;
import edu.uci.ics.jung.graph.*;

public class myGraph<V,E> extends UndirectedSparseGraph<V,E> implements Cloneable{
	private int diameter;
	public myGraph(){
	}
	
	/**
	 * Copy Constructor
	 */
	public myGraph(myGraph<V,E> another){
		//this.edges = another.edges;
		this.vertices = another.vertices;
	}
	
	public int getDiameter(){
		return this.diameter;
	}
	
	public void addVertices(Node[] nodes){
		for(Node n : nodes){
			this.addVertex((V)n);					//???
		}
	}
	
	public Object clone(){  
	    try{  
	        return super.clone();  
	    }catch(Exception e){ 
	        return null; 
	    }
	}
/*	
	public boolean removeEdge(E edge){
		Edge tempEdge = (Edge)edge;
		if(this.edges.containsKey(tempEdge)){
			System.out.println("Contains Edges here=================================");
			System.out.println(this.edges.get(tempEdge));
			System.out.println(this.edges);
			return true;
		}
		return false;
	}
*/	
	public boolean removeEdge(int index){
		Iterator i = this.edges.entrySet().iterator();
		while(i.hasNext()){
			Map.Entry<Edge, Pair<Node>> next = (Map.Entry<Edge, Pair<Node>>) i.next();
			if(next.getKey().getIndex() == index){
				i.remove();
				return true;
			}
		}
		return false;
	}
}
