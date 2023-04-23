public class MyTree<E> implements Tree<E> {
	private Position<E> root;
	
	public boolean isEmpty() {
		return root==null;
	}
	
	public MyTree() {
		
	}
	
	public Position<E> root() {
		return root;
	}
	
	public Position<E> setRoot(E n) {
		root = new TreeNode<E>(n);
		return root;
	}
	
	public boolean isRoot(Position<E> v) {
		return v.equals(root);
	}
	
	public Position<E> parent(Position<E> v) {
		return v.getParent();
	}
	
	public Iterable<Position<E>> children(Position<E> v) {
		return v.getChildren();
	}
	
	public E replace(Position<E> v, E e) {
		E o = v.element();
		v.setElement(e);
		return o;
	}
	
	
}
