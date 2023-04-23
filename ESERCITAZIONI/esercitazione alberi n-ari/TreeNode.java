import java.util.List;
import java.util.LinkedList;

public class TreeNode<E> implements Position<E> {
	
	private Position<E> parent;
	private List<Position<E>> children;
	private E element;
	
	public TreeNode(E element) {
		this.element = element;
		children = new LinkedList<Position<E>>();
	}
	
	public E element() {
		return element;
	}
	
	public Position<E> addChildren(E element) {
		Position<E> o = new TreeNode<E>(element);
		children.add(o);
		return o;
	}
	
	public List<Position<E>> getChildren() {
		return children;
	}
	
	public Position<E> getParent() {
		return parent;
	}
	
	public void setElement(E o) {
		this.element = o;
	}
	
	public void setParent(Position<E> v) {
		this.parent = v;
	}
}
