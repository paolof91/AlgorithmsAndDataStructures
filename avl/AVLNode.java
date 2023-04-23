public class AVLNode<E> {
	private E element;
	private int key;
	private int height;
	private AVLNode<E> rightChild;
	private AVLNode<E> leftChild;
	private AVLNode<E> parent;
	
	public AVLNode(int k,E e) {
		key=k;
		element = e;
	}
		
	public E getElement() {
		return element;
	}
	
	public int getKey() {
		return key;
	}
	
	public int getHeight() {
		return height;
	}
	
	public AVLNode<E> getRightChild() {
		return rightChild;
	}
	
	public AVLNode<E> getLeftChild() {
		return leftChild;
	}
	
	public AVLNode<E> getParent() {
		return parent;
	}
	
	public void setElement(E e) {
		element = e;
	}
	
	public void setKey(int k) {
		key = k;
	}
	
	public void setHeight(int h) {
		height = h;
	}
	
	public void setRightChild(AVLNode<E> r) {
		rightChild = r;
		if(r!=null)
			rightChild.setParent(this);
	}
	
	public void setLeftChild(AVLNode<E> l) {
		leftChild = l;
		if(l!=null)
			leftChild.setParent(this);
	}
	
	private void setParent(AVLNode<E> p) {
		parent = p;
	}
	
	public String toString() {
		return "<"+key+"> h"+height;
	}
}
