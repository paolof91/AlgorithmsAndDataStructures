public class MyComparator<T> implements java.util.Comparator<T> {
	public int compare(T o1, T o2) {
		if(o1 instanceof Integer)
			return ((Integer)o1).compareTo((Integer)o2);
		if(o1 instanceof String)
			return ((String)o1).compareTo((String)o2);
		
		return 0;
	}
}
