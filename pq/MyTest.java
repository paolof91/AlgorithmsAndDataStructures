public class MyTest {
	public static void main(String[] args) {
		PriorityQueue<Integer,String> spq = new SortedPriorityQueue<Integer,String>(new MyComparator<Integer>());
		PriorityQueue<Integer,String> upq = new UnsortedPriorityQueue<Integer,String>(new MyComparator<Integer>());
		
		spq.insert(50,"Franco");
		spq.insert(60,"Ilenia");		
		spq.insert(10,"Ciccio");
		spq.insert(30,"Mimmo");
		spq.insert(20,"Mario");		
		spq.insert(60,"Ilenia");
		spq.insert(80,"Fabrizio");
		spq.insert(70,"Margherita");
		spq.insert(40,"Michele");
		spq.insert(70,"Margherita");
		spq.insert(80,"Fabrizio");
		
		upq.insert(50,"Franco");
		upq.insert(60,"Ilenia");		
		upq.insert(10,"Ciccio");
		upq.insert(30,"Mimmo");
		upq.insert(20,"Mario");		
		upq.insert(60,"Ilenia");
		upq.insert(80,"Fabrizio");
		upq.insert(70,"Margherita");
		upq.insert(40,"Michele");
		upq.insert(70,"Margherita");
		upq.insert(80,"Fabrizio");
		
		System.out.println(spq+"\n\n");
		System.out.println(upq+"\n\n");
		
		while(!upq.isEmpty()) {
			System.out.println(upq.removeMin());
		}
		
		
	}
}
