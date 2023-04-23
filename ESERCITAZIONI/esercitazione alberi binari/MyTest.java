import java.util.List;

public class MyTest {
	public static void main(String[] args) {
/*		BTree<String> tree = new MyBTree<String>();
		BPosition<String> root = tree.setRoot("Galilei");
		BPosition<String> r = root.setRightChild("Leonardo");
		BPosition<String> l = root.setLeftChild("Gaspare");
		BPosition<String> ll = l.setLeftChild("Michelangelo");
		BPosition<String> lr = l.setRightChild("Caravaggio");
		BPosition<String> lrl= lr.setLeftChild("Virgilio");
		BPosition<String> lrr = lr.setRightChild("Enea");
		BPosition<String> lrrl = lrr.setLeftChild("Ulisse");
		BPosition<String> lrrr = lrr.setRightChild("Penelope");
		BPosition<String> rl = r.setLeftChild("Telemaco");
		BPosition<String> rll = rl.setLeftChild("Minerva");
		BPosition<String> rlr = rl.setRightChild("Giunone");
*/		
		

		BTree<Integer> tree = new MyBTree<Integer>();
		BPosition<Integer> root = tree.setRoot(2);
		BPosition<Integer> r = root.setRightChild(3);
		BPosition<Integer> rl = r.setLeftChild(2);
		BPosition<Integer> rr = r.setRightChild(6);
		BPosition<Integer> rrr = rr.setRightChild(8);
		BPosition<Integer> rrl = rr.setLeftChild(9);
		BPosition<Integer> l = root.setLeftChild(13);
		BPosition<Integer> lr = l.setRightChild(14);		
		BPosition<Integer> ll = l.setLeftChild(15);
		
		BTreeUtil.stampa(tree);
		
		System.out.println(((MyBTree<Integer>)tree).isHeapOrdered(new MyComparator<Integer>()));



	}
}
