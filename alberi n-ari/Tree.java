public interface Tree<E> {
	public int size();
	public int depth();
	public int maxBranchingFactor();
	public boolean isEmpty();
	public Iterable<Position<E>> positions();
	public Iterable<E> elements();	
	
	public Position<E> root();
	public Position<E> parent(Position<E> v);
	public Iterable<Position<E>> children(Position<E> v);
	
	public boolean isExternal(Position<E> v);
	public boolean isInternal(Position<E> v);
	public boolean isRoot(Position<E> v);
	
	public E replace(Position<E> v,E element);
}
