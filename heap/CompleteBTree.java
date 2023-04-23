public interface CompleteBTree<E> extends BTree<E> {
	public Position<E> add(E element);
	public Position<E> remove();
}
