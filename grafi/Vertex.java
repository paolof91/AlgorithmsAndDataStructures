import java.util.*;

public class Vertex<V> implements Position<V> {
	private V element;
	private String label;
	private List<Edge> adjacentList;
	private int firstMark=0;
	private int secondMark=0;
	private int distance=0;
	private int index=0;
	private Edge dijkstraEdge;
	
	public Vertex() {
		adjacentList = new LinkedList<Edge>();
	}
	
	public Edge getDijkstraEdge() {
		return dijkstraEdge;
	}
	
	public void setDijkstraEdge(Edge d) {
		dijkstraEdge = d;
	}

	public void setIndex(int i) {
		index=i;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setDistance(int d) {
		distance = d;
	}
	
	public int distance() {
		return distance;
	}
	
	public void setFirstMark(int a) {
		firstMark=a;
	}
	
	public int getFirstMark() {
		return firstMark;
	}
	
	public void setSecondMark(int a) {
		secondMark=a;
	}
	
	public int getSecondMark() {
		return secondMark;
	}

	public List<Edge> getAdjacentList() {
		return adjacentList;
	}
	
	public void setElement(V e) {
		element = e;
	}
	
	public void setLabel(String s) {
		label = s;
	}
	
	public V getElement() {
		return element;
	}
	
	public String getLabel() {
		return label;
	}
	
	public String toString() {
		return "("+element.toString()+","+distance+")";
	}
	
	
}
