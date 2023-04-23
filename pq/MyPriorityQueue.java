import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Comparator;

public abstract class MyPriorityQueue<K,V> implements PriorityQueue<K,V> {
	
	protected List<Entry<K,V>> list;
	protected Comparator<K> comparator;
	
	public MyPriorityQueue(Comparator<K> c) {
		list = new LinkedList<Entry<K,V>>();
		comparator = c;
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public abstract Entry<K,V> min();
	
	public abstract Entry<K,V> removeMin();
	
	public abstract Entry<K,V> insert(K key,V value);	
	
	public String toString() {
		Iterator<Entry<K,V>> i = list.iterator();
		String s="";
		while(i.hasNext()) {
			Entry<K,V> e = i.next();
			s+=e.toString();
			s+=" ";
		}
		return s;
	}
	
}
