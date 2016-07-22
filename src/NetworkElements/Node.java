package NetworkElements;

public class Node {
	private int id;
	private int x;
	private int y;
	private int degree;
	public Node(int id){
		this.id = id;
	}
	public Node(int index,int x, int y){
		this.id = index;
		this.x = x;
		this.y = y;
	}
	
	public Node(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getID(){
		return this.id;
	}
	
	public void increaseDegree(){
		this.degree++;
	}
	
	public int getDegree(){
		return this.degree;
	}
	
	@Override public int hashCode(){
		return this.x * 10 + this.y;
	}
	@Override public boolean equals(Object obj){
		if(((Node)obj).hashCode() == this.hashCode())
			return true;
		return false;
	}
	
	@Override public String toString(){
		return "(" + x + "," + y + ")";
	}
}
