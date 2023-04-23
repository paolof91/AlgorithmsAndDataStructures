public class MyBPosition<E> implements BPosition<E> {
	BPosition<E> left;
	BPosition<E> right;
	E element;
	BPosition<E> parent;
	
	public MyBPosition() {
	}
	
	public void setElement(E o) {
		this.element=o;
	}
	
	public void setParent(BPosition<E> v) {
		parent = v;
	}
	
	public BPosition<E> setRightChild(E elem) {
		right = new MyBPosition<E>();
		right.setElement(elem);
		right.setParent(this);
		return right;
	}
	
	public BPosition<E> setLeftChild(E elem) {
		left = new MyBPosition<E>();
		left.setElement(elem);
		left.setParent(this);
		return left;
	}
	
	public E getElement() {
		return element;
	}
	
	public BPosition<E> getParent() {
		return parent;
	}
	
	public BPosition<E> getRightChild() {
		return right;
	}
	
	public BPosition<E> getLeftChild() {
		return left;
	}

}
