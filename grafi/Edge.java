public class Edge<E> implements Position<E> {
	private E element;
	private String label;
	private int weight;
	private Vertex[] endVertices;
	
	public Vertex[] getEndVertices() {
		return endVertices;
	}
	
	public void setWeight(int w) {
		weight=w;
	}
	
	public int weight() {
		return weight;
	}
	
	public Edge() {
		endVertices = new Vertex[2];
	}
		
	public void setElement(E e) {
		element = e;
	}
	
	public void setLabel(String s) {
		label = s;
	}
	
	public E getElement() {
		return element;
	}
		
	public String getLabel() {
		return label;
	}
	
	public String toString() {
		return (new Integer(weight)).toString();
	}
}
