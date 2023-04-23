import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
public class MyTree<E> implements Tree<E> {
	private Position<E> root;

	public MyTree(E element) {
		this.root = new MyPosition<E>(element);		
	}
	
	private int sizeRecursive(Position<E> v) {
		if(isExternal(v)) return 1;
		int sum = 1;
		Iterator<Position<E>> i = v.children().iterator();
		while(i.hasNext())
			sum+=sizeRecursive(i.next());
		return sum;
	}
	
	public int size() {
		return sizeRecursive(root);
	}
	
	public boolean isEmpty() {
		return root==null;
	}
	
	private int maxBranchingFactorRecursive(Position<E> v) {
		if(isExternal(v)) return 0;
		int max = 0;
		int numChildren = 0;
		Iterator<Position<E>> i = v.children().iterator();
		
		while(i.hasNext()) {
			numChildren++;
			int temp = maxBranchingFactorRecursive(i.next());
			if(temp>max) max = temp;
		}
		
		return (max>numChildren)? max : numChildren;
		
		
	}
	
	public int maxBranchingFactor() {
		return maxBranchingFactorRecursive(root);
	}
	
	private int depthRecursive(Position<E> v) {
		if(isExternal(v)) return 0;
		int maxDepth = 0;
		Iterator<Position<E>> i = v.children().iterator();
		while(i.hasNext()) {
			int temp = depthRecursive(i.next());
			if(temp>maxDepth)
				maxDepth=temp;
		}
		return 1+maxDepth;
	}
	
	public int depth() {
		return depthRecursive(root);
	}
	
	private void positionRecursive(List<Position<E>> positions,Position<E> v) {
		positions.add(v);
		Iterator<Position<E>> i = v.children().iterator();
		while(i.hasNext())
			positionRecursive(positions,i.next());
	}
	
	public Iterable<Position<E>> positions() {
		List<Position<E>> positions = new LinkedList<Position<E>>();
		positionRecursive(positions,root);
		return positions;
	}
	
	public Iterable<E> elements() {
		Iterator<Position<E>> i = positions().iterator();
		List<E> l = new LinkedList<E>();
		while(i.hasNext())
			l.add(i.next().element());
		return l;
	}
	
	public Position<E> root() {
		return root;
	}
	
	public Position<E> parent(Position<E> p) {
		return p.parent();
	}
	
	public Iterable<Position<E>> children(Position<E> p) {
		return p.children();
	}
	
	public boolean isInternal(Position<E> v) {
		return v.children().iterator().hasNext();
	}
	
	public boolean isExternal(Position<E> v) {
		return !isInternal(v);
	}
	
	public boolean isRoot(Position<E> v) {
		return v.equals(root);
	}
	
	public E replace(Position<E> v, E element) {
		return v.replace(element);
	}
}
