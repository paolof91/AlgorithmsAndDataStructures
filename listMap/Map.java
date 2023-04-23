public interface Map<K,V> {
	public V put(K key,V value);
	public V get(K key);
	public V remove(K key);
	public int size();
	public boolean isEmpty();
	public Iterable<K> keys();
	public Iterable<V> values();
	public Iterable<Entry<K,V>> entries();
}
