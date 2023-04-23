public class MyTest {
	public static void main(String[] args) {
		Map<String,String> map = new ListMap<String,String>();
		
		System.out.println("Inserimenti: ");
		
		System.out.println(map.put("Forni","Paolo"));
		System.out.println(map.put("Forni","Fulvio"));
		System.out.println(map.put("Rullo","Pierpaolo"));
		System.out.println(map.put("Verde","Annamaria"));
		System.out.println(map.put("Ta","Annamaria"));
		System.out.println(map.put("Cipollone","Sandro"));
		System.out.println(map.put("Cipollone","Andrea"));
		System.out.println(map.put("Rullo","Michele"));
		
		
		System.out.println("\n"+map);
		
		System.out.println("Remove Verde: "+ map.remove("Verde"));
		System.out.println("\n"+map);

		System.out.println("Remove Negro: "+ map.remove("Negro"));


		System.out.println("Remove Forni: "+ map.remove("Forni"));
		System.out.println("\n"+map);


		
		
	}
}
