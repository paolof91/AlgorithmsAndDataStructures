public interface PriorityQueue<K,V> {
	public Entry<K,V> min();
	public Entry<K,V> removeMin();
	public Entry<K,V> insert(K key,V value);
	public int size();
	public boolean isEmpty();
}
