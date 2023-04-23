public interface Position<E> {
	public void addChildren(E...elements);
	public void addChildren(Position<E>...positions);
	public void setParent(Position<E> p);
	public Iterable<Position<E>> children();
	public Position<E> parent();
	public E replace(E element);
	public E element();
}
