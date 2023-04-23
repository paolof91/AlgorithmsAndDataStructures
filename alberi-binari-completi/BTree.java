public interface BTree<E> extends Tree<E> {
	public Position<E> left(Position<E> p);
	public Position<E> right(Position<E> p);
	public boolean hasLeft(Position<E> p);
	public boolean hasRight(Position<E> p);
	
}
