import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Comparator;

public class Sorting {
	public static <T> void insertionSort(List<T> l) {
		PriorityQueue<T,Object> pq = new SortedPriorityQueue<T,Object>(
										new MyComparator<T>());
		while(!l.isEmpty()) {
			T t = l.remove(0);
			pq.insert(t,null);			
		}
		while(!pq.isEmpty()) {
			T t = pq.removeMin().key();
			l.add(t);			
		}
	}
	
	public static <T> void insertionSortOnPlace(ArrayList<T> l) {
		Comparator<T> c = new MyComparator<T>();

		if(l.size()<2) return;
		T temp,temp2,toInsert;
		boolean flag=false;
		temp=temp2=toInsert=null;
		for(int i=1;i<l.size();i++) {
			toInsert = l.get(i);
			for(int j=0;j<=i;j++) {
				if(flag) {
					temp2=temp;
					temp=l.get(j);
					l.set(j,temp2);
				} else {
					if(c.compare(l.get(j),toInsert)>0) {
						temp = l.get(j);
						l.set(j,toInsert);
						flag=true;
					}
				}
			}
			flag=false;
		}
	}
	
	public static <T> void selectionSort(List<T> l) {
		PriorityQueue<T,Object> pq = new UnsortedPriorityQueue<T,Object>(
										new MyComparator<T>());
		while(!l.isEmpty()) {
			T t = l.remove(0);
			pq.insert(t,null);
		}
		while(!pq.isEmpty()) {
			T t = pq.removeMin().key();
			l.add(t);			
		}
	}
	
	public static void main(String[] args) {
		System.out.println("________________________________________");
		
		Random random = new Random();
		

		long startTime,endTime;
		long media=0;
		long difference;

		for(int j=0;j<13;j++) {

			for(int i=0;i<5;i++) {
				List<Integer> l = new java.util.LinkedList<Integer>();
				for(int k=0;k<10000+100*j;k++)
					l.add(random.nextInt());
				startTime = System.nanoTime();
				insertionSort(l);
				endTime = System.nanoTime();
				difference=endTime-startTime;
				media+=difference;
			}
			media/=5000000;
			System.out.println("La media per InsertionSort() con "+(10000+100*j)+" elementi è: "+media+" ns");
			System.out.println("____________________________________");
			media=0;
		}
		
		for(int j=0;j<13;j++) {

			for(int i=0;i<5;i++) {
				ArrayList<Integer> l = new java.util.ArrayList<Integer>();
				for(int k=0;k<10000+100*j;k++)
					l.add(random.nextInt());
				startTime = System.nanoTime();
				insertionSortOnPlace(l);
				endTime = System.nanoTime();
				difference=endTime-startTime;
				media+=difference;
			}
			media/=5000000;
			System.out.println("La media per InsertionSortOnPlace() con "+(10000+100*j)+" elementi è: "+media+" ns");
			System.out.println("____________________________________");
			media=0;
		}
		
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(10);
		l.add(70);
		l.add(5);
		l.add(6);
		l.add(80);
		l.add(55);
		l.add(45);
		l.add(50);
		System.out.println("\n\n"+l);
		insertionSortOnPlace(l);
		System.out.println(l);

	}
	
}
