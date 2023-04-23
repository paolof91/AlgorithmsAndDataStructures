public class MyTest {
	public static void main(String[] args) {
		MyCompleteBTree<String> t = new MyCompleteBTree<String>();
		t.add("Michele");
		t.add("Giammarco");
		Position<String> p = t.add("Andriulli");
		t.add("Perica");
		t.add("Flavio");
		t.add("Lino");
		t.add("Paolo");
		
		System.out.println(t+"\n\n");
		
		System.out.println(t.parent(p));
		System.out.println(t.children(p));
		System.out.println(t.left(p));
		System.out.println(t.right(p));
		

	}
}
