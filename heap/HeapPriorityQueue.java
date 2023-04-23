import java.util.Comparator;

public class HeapPriorityQueue<K,V> extends ArrayCompleteBTree<Entry<K,V>> implements PriorityQueue<K,V> {
	
	private Comparator<K> comparator = new MyComparator<K>();
	
	public HeapPriorityQueue() {
		
	}
	
	public Entry<K,V> insert(K key,V value) {
		Entry<K,V> e = new MyEntry<K,V>(key,value);
		Position<Entry<K,V>> p = add(e);
		int index = ((ArrayCompleteBPosition<Entry<K,V>>)p).index();
		upheap(index);
		return e;
		
	}
	
	private void upheap(int index) {
		if(index==1) return;
		if(comparator.compare(list.get(index).element().key(),
				list.get(index/2).element().key())<0) {
			Entry<K,V> e = list.get(index).element();
			list.set(index,new ArrayCompleteBPosition<Entry<K,V>>(
						list.get(index/2).element(),index));
			list.set(index/2,new ArrayCompleteBPosition<Entry<K,V>>(
						e,index/2));
		}
		upheap(index/2);
	}
	
	public Entry<K,V> min() {
		if(isEmpty()) throw new RuntimeException(
						"eccezione priorityQueue vuota");
						
		return list.get(1).element();
	} 
	
	public Entry<K,V> removeMin() {
		if(isEmpty()) throw new RuntimeException(
						"eccezione priorityQueue vuota");
		Entry<K,V> e = list.get(1).element();
		
		Entry<K,V> ultimo = list.get(size()).element();
		
		remove();
		
		list.set(1,new ArrayCompleteBPosition<Entry<K,V>>(ultimo,1));
		downheap(1);
		
		return e;
	}
	
	private void downheap(int index) {
		if(index*2>size()) return;
		if(index*2+1>size()) {
			if(comparator.compare(
				list.get(index*2+1).element().key(),
				list.get(index).element().key())<0)
			{

				Entry<K,V> temp = list.get(index).element();
				list.set(index,new ArrayCompleteBPosition<Entry<K,V>>(
							list.get(index*2+1).element(),index));
				list.set(index*2+1,new ArrayCompleteBPosition<Entry<K,V>>(
							temp,index*2+1));					
			}
			return;
		}
		
		boolean genitoreMaggioreDiLeft = comparator.compare (
					list.get(index).element().key(),
					list.get(index*2).element().key())>0;
		
		boolean genitoreMaggioreDiRight = comparator.compare (
					list.get(index).element().key(),
					list.get(index*2+1).element().key())>0;
					
		boolean LeftMaggioreDiRight = comparator.compare (
					list.get(index*2).element().key(),
					list.get(index*2+1).element().key())>0;
					
		if(genitoreMaggioreDiLeft&&genitoreMaggioreDiRight) {
			if(LeftMaggioreDiRight) {
				Entry<K,V> temp = list.get(index).element();
				list.set(index,new ArrayCompleteBPosition<Entry<K,V>>(
							list.get(index*2+1).element(),index));
				list.set(index*2+1,new ArrayCompleteBPosition<Entry<K,V>>(
							temp,index*2+1));
				downheap(index*2+1);
				return;
			} else {
				Entry<K,V> temp = list.get(index).element();
				list.set(index,new ArrayCompleteBPosition<Entry<K,V>>(
							list.get(index*2).element(),index));
				list.set(index*2,new ArrayCompleteBPosition<Entry<K,V>>(
							temp,index*2));
				downheap(index*2);
				return;
			}
		}
		if(genitoreMaggioreDiLeft) {
			Entry<K,V> temp = list.get(index).element();
			list.set(index,new ArrayCompleteBPosition<Entry<K,V>>(
						list.get(index*2).element(),index));
			list.set(index*2,new ArrayCompleteBPosition<Entry<K,V>>(
						temp,index*2));
			downheap(index*2);
			return;
		}
		if(genitoreMaggioreDiRight) {
			Entry<K,V> temp = list.get(index).element();
			list.set(index,new ArrayCompleteBPosition<Entry<K,V>>(
						list.get(index*2+1).element(),index));
			list.set(index*2+1,new ArrayCompleteBPosition<Entry<K,V>>(
						temp,index*2+1));						
			downheap(index*2+1);
			return;
		}
		
	}
}








