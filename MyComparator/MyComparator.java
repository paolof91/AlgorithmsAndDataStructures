public class MyComparator<T> implements java.util.Comparator<T> {
	public int compare(T o1, T o2) {
		if(o1 instanceof Integer && o2 instanceof Integer)
			return ((Integer)o1).compareTo((Integer)o2);
		if(o1 instanceof String && o2 instanceof String)
			return ((String)o1).compareTo((String)o2);
		throw new RuntimeException("Classe diversa da quella riconosciuta");
		
	}
	
	public static void main(String[] args) {
		System.out.println((new MyComparator<Integer>()).compare(Integer.parseInt(args[0]),
								Integer.parseInt(args[1])));
		System.out.println((new MyComparator<String>()).compare(args[2],args[3]));
	}
}
