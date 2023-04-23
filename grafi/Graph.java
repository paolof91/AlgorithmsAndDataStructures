import java.util.*;

public class Graph<V,E> {
	private List<Edge<E>> edges;
	private List<Vertex<V>> vertices;
	
	public Graph() {
		edges = new LinkedList<Edge<E>>();
		vertices = new LinkedList<Vertex<V>>();
	}
	
	public Vertex<V> opposite(Vertex<V> v,Edge<E> e) {
		Vertex<V>[] endVertices = e.getEndVertices();
		if(endVertices[0]==v) return endVertices[1];
		if(endVertices[1]==v) return endVertices[0];
		return null;

	}
		
	public boolean isEmpty() {
		return vertices.isEmpty();
	}

	public boolean areAdjacent(Vertex<V> u,Vertex<V> v) {
		Iterator<Edge> i1 = u.getAdjacentList().iterator();
		Iterator<Edge> i2 = v.getAdjacentList().iterator();
		
		while(i1.hasNext()&&i2.hasNext()) {
			if(opposite(u,i1.next())==v) return true;
			if(opposite(v,i2.next())==u) return true;
		}
		
		while(i1.hasNext())
			if(opposite(u,i1.next())==v) return true;
		
		while(i2.hasNext())
			if(opposite(v,i2.next())==u) return true;
			
		return false;
	}
	
	public Vertex<V>[] endVertices(Edge<E> e) {
		return e.getEndVertices();
	}
	
	public V replace(Vertex<V> v,V element) {
		V r = v.getElement();
		v.setElement(element);
		return r;
	}
	
	public E replace(Edge<E> e, E element) {
		E r = e.getElement();
		e.setElement(element);
		return r;
	}
	
	public Vertex<V> insertVertex(V element) {
		Vertex<V> v = new Vertex<V>();
		v.setElement(element);
		vertices.add(v);
		return v;
	}
	
	public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v,int element) {
		Edge<E> edge = new Edge<E>();
		edge.setWeight(element);
		Vertex<V>[] endVertices = edge.getEndVertices();
		endVertices[0]=u;
		endVertices[1]=v;
		u.getAdjacentList().add(edge);
		v.getAdjacentList().add(edge);
		edges.add(edge);
		return edge;
	}
	
	public void removeVertex(Vertex<V> v) {
		Iterator<Edge> i = v.getAdjacentList().iterator();
		while(i.hasNext())
			removeEdge(i.next());
		vertices.remove(v);		//costo addizionale dato dall'implementazione di LinkedList
	}
	
	public void removeEdge(Edge<E> e) {
		edges.remove(e);		//costo addizionale dato dall'implementazione di LinkedList
	}
	
	public Iterable<Edge<E>> incidentEdges(Vertex<V> v) {
		Iterator<Edge> i = v.getAdjacentList().iterator();
		List<Edge<E>> newList = new LinkedList<Edge<E>>();
		
		while(i.hasNext())
			newList.add(i.next());

		return newList;
	}
	
	public Iterable<Edge<E>> edges() {
		return edges;
	}
	
	public Iterable<Vertex<V>> vertices() {
		return vertices;
	}
	
}
