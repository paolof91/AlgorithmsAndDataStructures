public interface Tree<E> {
	public int size();
	public boolean isEmpty();
	public Iterable<E> elements();
	public Iterable<Position<E>> positions();
	
	public boolean isExternal(Position<E> p);
	public boolean isInternal(Position<E> p);
	public boolean isRoot(Position<E> p);
	
	public Position<E> root();
	public Iterable<Position<E>> children(Position<E> p);
	public Position<E> parent(Position<E> p);
	
	public Position<E> replace(Position<E> p,E element);
	
}
