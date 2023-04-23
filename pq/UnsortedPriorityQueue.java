import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class UnsortedPriorityQueue<K,V> extends MyPriorityQueue<K,V> implements PriorityQueue<K,V> {
	
	public UnsortedPriorityQueue(Comparator<K> c) {
		super(c);
	}	
	
	public Entry<K,V> min() {
		if(isEmpty()) throw new EmptyPriorityQueueException("Coda di priorità vuota");
		
		K minKey = ((LinkedList<Entry<K,V>>)list).getFirst().key();
		int minIndex = 0;
		int j = 0;
		
		Iterator<Entry<K,V>> i = list.iterator();
		
		while(i.hasNext()) {
			Entry<K,V> e = i.next();
			if(comparator.compare(e.key(),minKey)<0) {
				minKey=e.key();
				minIndex=j;
			}
			j++;	
		}
		
		return list.get(minIndex);
		
	}
	
	public Entry<K,V> removeMin() {
		if(isEmpty()) throw new EmptyPriorityQueueException("Coda di priorità vuota");
		
		K minKey = ((LinkedList<Entry<K,V>>)list).getFirst().key();
		int minIndex = 0;
		int j = 0;
		
		Iterator<Entry<K,V>> i = list.iterator();
		
		while(i.hasNext()) {
			Entry<K,V> e = i.next();
			if(comparator.compare(e.key(),minKey)<0) {
				minKey=e.key();
				minIndex=j;
			}
			j++;
		}
		
		return list.remove(minIndex);
	}

	
	public Entry<K,V> insert(K key,V value) {
		Entry<K,V> e = new MyEntry<K,V>(key,value);
		list.add(e);
		
		return e;
	}	
}
