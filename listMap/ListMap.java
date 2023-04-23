import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

public class ListMap<K,V> implements Map<K,V> {
	private LinkedList<Entry<K,V>> list;
	
	public ListMap() {
		list = new LinkedList<Entry<K,V>>();
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public Iterable<Entry<K,V>> entries() {
		return list;
	}
	
	public Iterable<K> keys() {
		LinkedList<K> keys = new LinkedList<K>();
		Iterator<Entry<K,V>> i = list.iterator();
		while(i.hasNext())
			keys.add(i.next().key());
		return keys;
	}
	
	public Iterable<V> values() {
		LinkedList<V> values = new LinkedList<V>();
		Iterator<Entry<K,V>> i = list.iterator();
		while(i.hasNext())
			values.add(i.next().value());
		return values;
	}
	
	public V put(K key,V value) {
		ListIterator<Entry<K,V>> i = list.listIterator();
		while(i.hasNext()) {
			Entry<K,V> e = i.next();
			if(e.key().equals(key)) {
				V r = e.value();
				i.set(new MyEntry<K,V>(key,value));
				return r;
			}
		}
		list.add(new MyEntry<K,V>(key,value));
		return null;

	}
	
	public V get(K key) {
		Iterator<Entry<K,V>> i = list.iterator();
		while(i.hasNext()) {
			Entry<K,V> e = i.next();
			if(e.key().equals(key))
				return e.value();
		}
		return null;
		
	}

	public V remove(K key) {
		ListIterator<Entry<K,V>> i = list.listIterator();
		while(i.hasNext()) {
			Entry<K,V> e = i.next();
			if(e.key().equals(key)) {
				V r = e.value();
				i.remove();
				return r;
			}
		}
		return null;
		
	}
	
	public String toString() {
		return list.toString();
	}
	
}
