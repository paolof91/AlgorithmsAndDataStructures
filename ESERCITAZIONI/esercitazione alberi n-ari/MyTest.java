public class MyTest {
	public static void main(String[] args) {
		MyTree<Integer> tree = new MyTree<Integer>();
		tree.setRoot(3);
		tree.root().addChildren(5);
		tree.root().addChildren(7);
		tree.root().addChildren(4);
		Position<Integer> p = tree.root();
		
		for(int i=0;i<4;i++) {
			Iterator<Position<Integer>> iterator = tree.getChildren(p).iterator();
		}
	}
}
