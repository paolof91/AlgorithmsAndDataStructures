public class MyTest {
	public static void main(String[] args) {
		HeapPriorityQueue<Integer,String> heap = new HeapPriorityQueue();
		heap.insert(21,"Rossini");
		heap.insert(6,"Verdi");
		heap.insert(5,"Bohemien");
		heap.insert(2,"Tosca");
		heap.insert(23,"Piccirillo");
		heap.insert(56,"Verdognolo");
		heap.insert(30,"Rigagnolo");
		heap.insert(12,"Forse");
		heap.insert(20,"Giammai");
		
		heap.insert(51,"Barbuto");
		heap.insert(3,"Trac");
		heap.insert(16,"Abbastanza");
		heap.insert(34,"No grazie");
		
		System.out.println(heap+"\n____________________");
		
		System.out.println("removeMin() = "+heap.removeMin());
		
		System.out.println(heap+"\n____________________");
		
		System.out.println("removeMin() = "+heap.removeMin());

		System.out.println(heap+"\n____________________");
		
		System.out.println("removeMin() = "+heap.removeMin());
		

		System.out.println(heap+"\n____________________");
		
		System.out.println("removeMin() = "+heap.removeMin());
		
		System.out.println(heap+"\n____________________");
		
	}
}
