import java.util.*;

public class Inverti {
	public static void inverti(ListIterator<Integer> iteratore) {
		if(!iteratore.hasNext()) return;
		Integer temp = iteratore.next();
		iteratore.remove();
		inverti(iteratore);
		iteratore.add(temp);
	}
	
	public static void main(String[] args) {
		List<Integer> l = new LinkedList<Integer>();
		for(String s : args)
			l.add(Integer.parseInt(s));
		System.out.println(l);
		inverti(l.listIterator());
		System.out.println(l);
		
	}
}
