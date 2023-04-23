public class MyPosition<E> implements Position<E> {
	private E element;
	
	public MyPosition(E e) {
		element = e;
	}
	
	public E element() {
		return element;
	}
}
