public class AVL<E> {
	private AVLNode<E> root;
	private int size;
	
	public AVL() {
		size=0;
	}
	
	private AVLNode<E> insertBST(int k,E e,AVLNode<E> v) {
		if(v.getLeftChild()==null&&v.getKey()>k) {
			v.setLeftChild(new AVLNode<E>(k,e));
			return v.getLeftChild();
		}
		if(v.getRightChild()==null&&v.getKey()<=k) {
			v.setRightChild(new AVLNode<E>(k,e));
			return v.getRightChild();
		}
		if(v.getKey()<=k)
			return insertBST(k,e,v.getRightChild());
		return insertBST(k,e,v.getLeftChild());
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	private void setHeight(AVLNode<E> p) {
		if(p==null) return;
		AVLNode<E> l = p.getLeftChild();
		AVLNode<E> r = p.getRightChild();
		if(l==null&&r==null) {
			p.setHeight(0);
			return;
		}
		if(l==null) {
			p.setHeight(1+r.getHeight());
			return;
		}
		if(r==null) {
			p.setHeight(1+l.getHeight());
			return;
		}
		if(r.getHeight()>l.getHeight()) {
			p.setHeight(1+r.getHeight());
		} else {
			p.setHeight(1+l.getHeight());
			return;
		}
	}
	
	private boolean isBalanced(AVLNode<E> p) {
		if(p.getHeight()<2) return true;

		AVLNode<E> l = p.getLeftChild();
		AVLNode<E> r = p.getRightChild();
		
		if(l==null||r==null) return false;
		
		return r.getHeight()-l.getHeight()<2&&
				r.getHeight()-l.getHeight()>-2;
	}
	
	private AVLNode<E> tallerChild(AVLNode<E> p) {
		AVLNode<E> l = p.getLeftChild();
		AVLNode<E> r = p.getRightChild();
		
		if(l==null)
			return r;
		if(r==null)
			return l;
		if(r.getHeight()>l.getHeight())
			return r;
		return l;
	}
	
	private AVLNode<E> restructure(AVLNode<E> x,AVLNode<E> y,AVLNode<E> z) {
		
		System.out.println("x = "+x+"\ty = "+y+"\tz = "+z);
		boolean left2 = y.getLeftChild()==x;
		boolean left1 = z.getLeftChild()==y;
		if(left1) {
			if(left2)
				return restructureLeftLeft(x,y,z);
			else
				return restructureLeftRight(x,y,z);
		} else {
			if(left2)
				return restructureRightLeft(x,y,z);
			else
				return restructureRightRight(x,y,z);
		}
	}
	
	private AVLNode<E> restructureLeftLeft(AVLNode<E> x,AVLNode<E> y,AVLNode<E> z) {
		return null;
	}
	
	private AVLNode<E> restructureLeftRight(AVLNode<E> x,AVLNode<E> y,AVLNode<E> z) {
		return null;
	}

	private AVLNode<E> restructureRightLeft(AVLNode<E> x,AVLNode<E> y,AVLNode<E> z) {
		return null;
	}

	private AVLNode<E> restructureRightRight(AVLNode<E> x,AVLNode<E> y,AVLNode<E> z) {
		z.setRightChild(y.getLeftChild());
		if(z.getParent()==null) {
			root=y;
		} else {
			if(z.getParent().getLeftChild()==z)
				z.getParent().setLeftChild(y);
			else
				z.getParent().setRightChild(y);
		}
		y.setLeftChild(z);
		return y;
	}
	
	
	private void rebalance(AVLNode<E> z) {
		AVLNode<E> x = z;
		setHeight(x);
		AVLNode<E> y = x.getParent();
		setHeight(y);
		
		z=z.getParent();
		while(z!=null) {
			setHeight(z);
			if(!isBalanced(z)) {
				z=restructure(x,y,z);
			}
			z=z.getParent();
			y=y.getParent();
			x=x.getParent();
			
		}
	}
	
	public AVLNode<E> insert(int k,E e) {
		if(isEmpty()) {
			root = new AVLNode<E>(k,e);
			size++;
			setHeight(root);
			return root;
		}
		AVLNode<E> newNode = insertBST(k,e,root);
		rebalance(newNode);
		System.out.println(this);
		size++;
		
		
		return newNode;
		
	}
	
	public AVLNode<E> findNode(AVLNode<E> v,int k) {
		if(v==null) return null;
		if(k==v.getKey())
			return v;
		if(k<v.getKey())
			return v.getLeftChild();
		else return v.getRightChild();
	}
	
	public E find(int k) {
		return findNode(root,k).getElement();
	}
	
	private String toString(AVLNode<E> v,int level,boolean left) {
		if(v==null) return "";
		String s="";
		if(level>0) {
			for(int i=0;i<level-1;i++)
				s+="       ";
			if(left)
				s+=" |---L ";
			else
				s+=" |---R ";
		}
		s+=v.toString()+"\n";
		s+=toString(v.getLeftChild(),level+1,true);
		s+=toString(v.getRightChild(),level+1,false);
		return s;
	}
	
	public String toString() {
		return toString(root,0,false);
	}
}
