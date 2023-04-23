public class ArrayCompleteBPosition<E> extends MyPosition<E> {
	private int index;
	
	public ArrayCompleteBPosition(E element,int index) {
		super(element);
		this.index=index;
	}
	
	public int index() {
		return index;
	}
	
	public String toString() {
		return "<"+index+","+element()+">";
	}
}
