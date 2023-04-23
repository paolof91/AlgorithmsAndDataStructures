import java.util.*;

public class MyBTree<E> implements BTree<E> {
	private BPosition<E> root;
	
	public MyBTree() {
	}
	
	private int height(BPosition<E> v) {
		BPosition<E> l = v.getLeftChild();
		BPosition<E> r = v.getRightChild();
		if(l==null&&r==null) return 0;
		int a,b;
		a=b=0;
		if(l!=null)
			a = height(v.getLeftChild());
		if(r!=null)
			b = height(v.getRightChild());
		return a>b?(a+1):(b+1);
	}
	
	private boolean isHeapOrdered(BPosition<E> v,Comparator<E> c) {
		if(v==null) return true;
		boolean temp = c.compare(v.getElement(),v.getParent().getElement())>=0;
		return temp && isHeapOrdered(v.getLeftChild(),c) && isHeapOrdered(v.getRightChild(),c);
		
	}
	
	public boolean isHeapOrdered(Comparator<E> comparator) {
		return isHeapOrdered(root.getLeftChild(),comparator)&&isHeapOrdered(root.getRightChild(),comparator);
	}
	
	public int depth() {
		return height(root);
	}
	
	private void riempiListLevel(List<E>[] l,BPosition<E> v,int level) {
		if(v==null) return;
		l[level].add(v.getElement());
		riempiListLevel(l,v.getLeftChild(),level+1);
		riempiListLevel(l,v.getRightChild(),level+1);
	}
	
	public List<E>[] listLevel() {
		List<E>[] listLevel = new List[depth()+1];
		for(int i=0;i<listLevel.length;i++)
			listLevel[i] = new LinkedList<E>();
		riempiListLevel(listLevel,root,0);
		return listLevel;

	}
	
	private int size(BPosition<E> v) {
		if(v==null) return 0;
		return 1+size(v.getLeftChild())+size(v.getRightChild());
	}
	
	public int size() {
		return size(root);
	}
	
	public boolean isEmpty() {
		return root==null;
	}
	
	public boolean isRoot(BPosition<E> v) {
		return v==root;
	}
	
	public BPosition<E> setRoot(E n) {
		root = new MyBPosition<E>();
		root.setElement(n);
		return root;
	}
	
	public BPosition<E> getRoot() {
		return root;
	}

    public E replace(BPosition<E> v, E e) {
		E temp = v.getElement();
		v.setElement(e);
		return temp;
	}
	
	private void printPreorderRecursive(BPosition<E> v) {
		if(v==null) return;
		System.out.println(v.getElement());
		printPreorderRecursive(v.getLeftChild());
		printPreorderRecursive(v.getRightChild());
	}
	
	private void postorderRecursive(BPosition<E> v,List<E> l) {
		if(v==null) return;
		postorderRecursive(v.getLeftChild(),l);
		postorderRecursive(v.getRightChild(),l);
		l.add(v.getElement());		
	}
	
	public List<E> postorder() {
		List<E> l = new LinkedList<E>();
		postorderRecursive(root,l);
		return l;		
	}
	
	public void printPreorder()	{
		printPreorderRecursive(root);
	}
	
}


