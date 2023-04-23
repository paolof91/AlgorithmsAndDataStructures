import java.util.*;

public class ArrayCompleteBTree<E> implements CompleteBTree<E> {
	protected ArrayList<Position<E>> list;
	
	public ArrayCompleteBTree() {
		list = new ArrayList<Position<E>>();
		list.add(null);
	}
	
	public Iterable<Position<E>> positions() {
		ArrayList<Position<E>> cl = ((ArrayList<Position<E>>)(list.clone()));
		cl.remove(0);
		return cl;
	}
	
	public Iterable<E> elements() {
		ArrayList<E> elementsList = new ArrayList<E>();
		Iterator<Position<E>> i = list.iterator();
		
		if(i.hasNext()) i.next();
		
		while(i.hasNext())
			elementsList.add(i.next().element());
		
		return elementsList;
		
	}
	
	public int size() {
		return list.size()-1;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public boolean isExternal(Position<E> p) {
		return !isInternal(p);
	}
	
	public boolean isInternal(Position<E> p) {
		int index = ((ArrayCompleteBPosition<E>)p).index();
		return 2*index<=size();
	}
	
	public boolean isRoot(Position<E> p) {
		return ((ArrayCompleteBPosition<E>)p).index() == 1;
	}
	
	public Position<E> root() {
		return list.get(1);
	}
	
	public Iterable<Position<E>> children(Position<E> p) {
		int index = ((ArrayCompleteBPosition<E>)p).index();
		List<Position<E>> l = new ArrayList<Position<E>>();
		l.add(list.get(index*2));
		l.add(list.get(index*2+1));
		return l;
	}
	
	public Position<E> parent(Position<E> p) {
		int index = ((ArrayCompleteBPosition<E>)p).index();
		return list.get(index);
	}
	
	public Position<E> replace(Position<E> p,E element) {
		int index = ((ArrayCompleteBPosition<E>)p).index();
		Position<E> n = new ArrayCompleteBPosition<E>(element,index); 
		list.set(index,n);
		return n;
	}
	
	public Position<E> left(Position<E> p) {
		int index = ((ArrayCompleteBPosition<E>)p).index();
		if(2*index<=size())
			return list.get(2*index);
		else 
			return null;
		
	}
	public Position<E> right(Position<E> p) {
		int index = ((ArrayCompleteBPosition<E>)p).index();
		if(2*index+1<=list.size())
			return list.get(2*index+1);
		else 
			return null;
	}
	
	public boolean hasLeft(Position<E> p) {
		return 2*((ArrayCompleteBPosition<E>)p).index()<=size();
	}
	
	public boolean hasRight(Position<E> p) {
		return 2*((ArrayCompleteBPosition<E>)p).index()+1<=size();
	}
	
	public Position<E> add(E element) {
		Position<E> n = new ArrayCompleteBPosition(element,size()+1);
		list.add(n);
		return n;
	}
	
	public Position<E> remove() {
		return list.remove(size());
	}
	
	private String toStringRecursive(int index,int level) {
		if(index>size()) return "";
		String s="";
		
		if(level>0) {
			for(int j = 0;j<level-1;j++)
				s+="       ";
			s+=" |\n";
			for(int j = 0;j<level-1;j++)
				s+="       ";
			s+=" |---- ";
		}
		s+=list.get(index).toString();
		s+="\n";
		s+=toStringRecursive(index*2,level+1);
		s+=toStringRecursive(index*2+1,level+1);
		return s;
	}
	
	public String toString() {
		return "\n"+toStringRecursive(1,0);
	}

}
