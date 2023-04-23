public class MyBSTree<E> implements BSTree<E> {
	private BSPosition<E> root;
	private int size;
	
	public MyBSTree() {
		size=0;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public boolean isLeaf(BSPosition<E> v) {
		return v.getRightChild()==null&&v.getLeftChild()==null;
	}
	
	public BSPosition<E> getRoot() {
		return root;
	}
	
	private BSPosition<E> insert(int k,E e,BSPosition<E> v) {
		if(v.getKey()==k) {
			v.setElement(k,e);
			return v;
		}
		if(v.getKey()>k) {
			if(v.getLeftChild()==null) {
				size++;
				return v.setLeftChild(k,e);
			}
			return insert(k,e,v.getLeftChild());	
		}
		else {
			if(v.getRightChild()==null) {
				size++;
				return v.setRightChild(k,e);
			}
			return insert(k,e,v.getRightChild());
		}
	}
	
	public BSPosition<E> insert(int k,E e) {
		if(size==0) {
			root = new MyBSNode<E>();
			root.setElement(k,e);
			size++;
			return root;
		}
		
		return insert(k,e,root);
	}
	
	private int n(BSPosition<E> v) {
		if(v==null) return 0;
		return 1+n(v.getLeftChild())+n(v.getRightChild());
	}
	
	public int n() {
		return n(root);
	}
	
	public BSPosition<E> remove(int k) {
		if(size==0) throw new RuntimeException("Empty BST");
		if(root.getKey()==k) {
			BSPosition<E> p = root;
			root = null;
			size--;
			return p;
		}
		BSPosition<E> v = findNode(k,root);
		if(v==null) return null;
		remove(v);
		size--;
		return v;
	}
	
	private void remove(BSPosition<E> v) {
		if(isLeaf(v)) {
			removeExternal(v);
			return;
		}
		if(v.getLeftChild()==null||v.getRightChild()==null) {
			removeNodeWithOneChild(v);
			return;
		}
		BSPosition<E> successor = v.getRightChild();
		while(successor.getLeftChild()!=null)
			successor=successor.getLeftChild();
		if(v.getParent().getLeftChild()==v) {
			v.getParent().setLeftChild(successor.getKey(),successor.getElement());
			v.getParent().getLeftChild().setLeftChild(v.getLeftChild());
			v.getParent().getLeftChild().setRightChild(v.getRightChild());
		} else {
			v.getParent().setRightChild(successor.getKey(),successor.getElement());
			v.getParent().getRightChild().setLeftChild(v.getLeftChild());
			v.getParent().getRightChild().setRightChild(v.getRightChild());
		}
		if(isLeaf(successor)) {
			removeExternal(successor);
			return;
		}
		removeNodeWithOneChild(successor);
		
	}
	
	
	private void removeNodeWithOneChild(BSPosition<E> v) {
		if(v.getLeftChild()==null) {
			BSPosition<E> parent = v.getParent();
			if(parent.getLeftChild()==v)
				parent.setLeftChild(v.getRightChild());
			else
				parent.setRightChild(v.getRightChild());
			return;
		}
		if(v.getRightChild()==null) {
			BSPosition<E> parent = v.getParent();
			if(parent.getLeftChild()==v)
				parent.setLeftChild(v.getLeftChild());
			else
				parent.setRightChild(v.getLeftChild());
			return;
		}
		
	}
	
	
	private void removeExternal(BSPosition<E> v) {
		BSPosition<E> parent = v.getParent();
		if(parent.getLeftChild()==v)
			parent.setLeftChild(null);
		else
			parent.setRightChild(null);
	}
	
	
	private BSPosition<E> findNode(int k, BSPosition<E> v) {
		if(v==null) return null;
		if(v.getKey()==k) return v;
		BSPosition<E> r;
		if(v.getKey()>k)
			return findNode(k,v.getLeftChild());
		else
			return findNode(k,v.getRightChild());
	}
	
	public E find(int k) {
		BSPosition<E> v = findNode(k,root);
		if(v!=null)
			return v.getElement();
		return null;
	}
	
	public String toString(BSPosition<E> v, int level,boolean right) {
		if(v==null) return "";
		String s="";
		if(level>0) {
			for(int i=0;i<level-1;i++)
				s+="       ";
			if(right)
				s+=" |---R ";
			else
				s+=" |---L ";
		}
		s+=v.toString()+"\n";
		s+=toString(v.getLeftChild(),level+1,false);
		s+=toString(v.getRightChild(),level+1,true);
		return s;
	}
	
	public String toString() {
		return toString(root,0,false);
	}
	
	public int size() {
		return size;
	}
}
