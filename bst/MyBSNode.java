public class MyBSNode<E> implements BSPosition<E> {
	private E element;
	private int key;
	private BSPosition<E> parent;
	private BSPosition<E> rightChild;
	private BSPosition<E> leftChild;
	
	public MyBSNode() {
		
	}
	
	public void setElement(int k,E e) {
		key=k;
		element = e;
	}
	
	public void setParent(BSPosition<E> v) {
		parent = v;
	}
	
	public BSPosition<E> setRightChild(int k,E e) {
		rightChild = new MyBSNode<E>();
		rightChild.setElement(k,e);
		rightChild.setParent(this);
		return rightChild;
	}
	
	public void setRightChild(BSPosition<E> b) {
		rightChild=b;
		if(b!=null)
			rightChild.setParent(this);

	}
	
	public BSPosition<E> setLeftChild(int k,E e) {
		leftChild = new MyBSNode<E>();
		leftChild.setElement(k,e);
		leftChild.setParent(this);
		return leftChild;
	}
	
	public void setLeftChild(BSPosition<E> b) {
		leftChild = b;
		if(b!=null)
			leftChild.setParent(this);
		
		
	}
	
	public E getElement() {
		return element;
	}
	
	public int getKey() {
		return key;
	}
	
	public BSPosition<E> getParent() {
		return parent;
	}
	
	public BSPosition<E> getLeftChild() {
		return leftChild;
	}
	
	public BSPosition<E> getRightChild() {
		return rightChild;
	}

	public String toString() {
		return "<"+key+","+element+">";
	}
}
