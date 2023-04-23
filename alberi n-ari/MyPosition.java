import java.util.List;
import java.util.LinkedList;

public class MyPosition<E> implements Position<E> {
	private E element;
	private List<Position<E>> children;
	private Position<E> parent;
	
	public MyPosition(E element) {
		this.element = element;
		children = new LinkedList<Position<E>>();
	}
	
	public MyPosition(E element,Position<E> parent) {
		this(element);
		setParent(parent);
	}
	
	public void setParent(Position<E> parent) {
		this.parent = parent;
	}
		
	public void addChildren(E...elements) {
		for(E element : elements)
			children.add(new MyPosition<E>(element));
	}
	
	public void addChildren(Position<E>...positions) {
		for(Position<E> position : positions)
			children.add(position);
	}
	
	
	public Iterable<Position<E>> children() {
		return children;
	}
	
	public Position<E> parent() {
		return parent;
	}
	
	public E element() {
		return element;
	}
	
	public E replace(E element) {
		E temp = this.element;
		this.element = element;
		return temp;
	}
}
