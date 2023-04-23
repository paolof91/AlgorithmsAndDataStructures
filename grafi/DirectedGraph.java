import java.util.*;

public class DirectedGraph<V,E> {
	private List<Edge<E>> edges;
	private List<Vertex<V>> vertices;
	
	public DirectedGraph() {
		edges = new LinkedList<Edge<E>>();
		vertices = new LinkedList<Vertex<V>>();
	}
	
	public Vertex<V> opposite(Vertex<V> v,Edge<E> e) {
		Vertex<V>[] endVertices = e.getEndVertices();
		if(endVertices[0]==v) return endVertices[1];
		return null;
	}
	
	public boolean isEmpty() {
		return vertices.isEmpty();
	}

	public boolean areDirectedAdjacent(Vertex<V> u,Vertex<V> v) {
		Iterator<Edge> i1 = u.getAdjacentList().iterator();
		
		while(i1.hasNext()) {
			if(opposite(u,i1.next())==v) return true;
		}
		
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
	
	public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v,E element) {
		Edge<E> edge = new Edge<E>();
		edge.setElement(element);
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
		
		while(i.hasNext()) {
			Edge edge = i.next();
			Vertex[] endVertices = edge.getEndVertices();
			if(endVertices[0]==v)
				newList.add(edge);
		}

		return newList;
	}
	
	public Iterable<Edge<E>> edges() {
		return edges;
	}
	
	public Iterable<Vertex<V>> vertices() {
		return vertices;
	}
	
	
}
