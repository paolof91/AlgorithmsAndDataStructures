public class MyComparator<K> implements java.util.Comparator<K> {
	public int compare(K o1,K o2) {
		if(o1 instanceof Integer && o2 instanceof Integer)
			return ((Integer)o1).compareTo((Integer)o2);
		if(o1 instanceof String && o2 instanceof String)
			return ((String)o1).compareTo((String)o2);
		throw new RuntimeException("Tipi non confrontabili");
	}
}
