import java.util.Comparator;
import java.util.ListIterator;
import java.util.LinkedList;

public class SortedPriorityQueue<K,V> extends MyPriorityQueue<K,V> implements PriorityQueue<K,V> {
	
	public SortedPriorityQueue(Comparator<K> c) {
		super(c);
	}	
	
	public Entry<K,V> min() {
		return ((LinkedList<Entry<K,V>>)list).getFirst();
	}
	
	public Entry<K,V> removeMin() {
		return ((LinkedList<Entry<K,V>>)list).remove();
	}

	
	public Entry<K,V> insert(K key,V value) {
		Entry<K,V> e = new MyEntry<K,V>(key,value);
		ListIterator<Entry<K,V>> i = list.listIterator(0);
		while(i.hasNext())
			if(comparator.compare(i.next().key(),key)>0) {
				i.previous();
				i.add(e);
				return e;
			}

		i.add(e);
		return e;
	}	
}
