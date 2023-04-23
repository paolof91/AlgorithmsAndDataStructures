import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		Tree<Integer> t = new MyTree<Integer>(1);

		Position<Integer> p32 = new MyPosition<Integer>(8);
		p32.addChildren(9,11,12,45,57);
		Position<Integer> p324 = new MyPosition<Integer>(433);
		p324.addChildren(123,124);
		p32.addChildren(p324);
		Position<Integer> p3 = new MyPosition<Integer>(5);
		p3.addChildren(new MyPosition<Integer>(1),p32);
		p3.addChildren(6,65,67,68,69);
		Position<Integer> p1 = new MyPosition<Integer>(2);
		p1.addChildren(1,2,3);
		Position<Integer> p2 = new MyPosition<Integer>(3);
		Position<Integer> p21 = new MyPosition<Integer>(6);
		p21.addChildren(56,61);
		p2.addChildren(p21);
		t.root().addChildren(p1,p2,p3);
	
		TreeUtil.printTree(t);
		
		System.out.println();
		System.out.println("Size:\t"+t.size());
		System.out.println("Depth:\t"+t.depth());
		System.out.println("Max Branching Factor:\t"+t.maxBranchingFactor());
		
		
	}
}

