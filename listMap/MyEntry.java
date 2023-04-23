public class MyEntry<K,V> implements Entry<K,V> {
	private K key;
	private V value;
	
	public MyEntry(K k,V v) {
		key=k;
		value=v;
	}
	
	public K key() {
		return key;
	}
		
	public V value() {
		return value;
	}
	
	public String toString() {
		return "<"+key+","+value+">";
	}
}
