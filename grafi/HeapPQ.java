import java.util.ArrayList;

public class HeapPQ {
	private ArrayList<Vertex> array;
	
	public HeapPQ() {
		array = new ArrayList<Vertex>(16);
		array.add(null);
	}
	
	public boolean isEmpty() {
		return array.size()==1;
	}
	
	public void insert(Vertex v) {
		if(array.size()==1) {
			array.add(v);
			v.setIndex(1);
			return;
		}
		array.add(v);
		v.setIndex(array.size()-1);
		upheap(array.size()-1);
	}
	
	public Vertex min() {
		return array.get(1);
	}
	
	public void reload(int index) {
		if(isEmpty()) return;
		Vertex v = array.get(index);
		if(index*2<array.size())
			downheap(index);
		if(v.getIndex()==index)
			upheap(v.getIndex());
	}
	
	private void downheap(int i) {
		if(i*2>=array.size())
			return;
		if(i*2==array.size()-1) {
			if(array.get(i).distance()>array.get(i*2).distance()) {
				Vertex temp = array.get(i);
				array.set(i,array.get(i*2));
				array.set(i*2,temp);
				array.get(i).setIndex(i);
				array.get(i*2).setIndex(i*2);
			}
			return;
		}
		
		if(array.get(i).distance()>array.get(i*2).distance() ||
					array.get(i).distance()>array.get(i*2+1).distance()) {
			if(array.get(i*2).distance()>array.get(i*2+1).distance()) {
				Vertex temp = array.get(i);
				array.set(i,array.get(i*2+1));
				array.set(i*2+1,temp);
				array.get(i).setIndex(i);
				array.get(i*2+1).setIndex(i*2+1);
				downheap(i*2+1);
			} else {
				Vertex temp = array.get(i);
				array.set(i,array.get(i*2));
				array.set(i*2,temp);
				array.get(i).setIndex(i);
				array.get(i*2).setIndex(i*2);
				downheap(i*2);
			}
		}
	}

	public Vertex removeMin() {
		if(isEmpty()) throw new RuntimeException("PQ vuota");
		Vertex min = array.get(1);
		array.set(1,array.get(array.size()-1));
		array.remove(array.size()-1);
		if(array.size()==2) {
			array.get(1).setIndex(1);
		}
		downheap(1);
		return min;
	}
	
	private void upheap(int i) {
		if(i<2) return;
		if(array.get(i).distance()<array.get(i/2).distance()) {
			Vertex temp = array.get(i);
			array.set(i,array.get(i/2));
			array.set(i/2,temp);
			array.get(i).setIndex(i);
			array.get(i/2).setIndex(i/2);
			
			upheap(i/2);
		}
	}
	
	public String toString(int index,int level) {
		if(index>array.size()-1) return "";
		String s = "";
		if(index>1) {
			for(int i=0;i<level-1;i++) 
				s+="      ";
			s+=" |--- ";
		}
		s+=array.get(index).toString()+"\n";
		s+=toString(index*2,level+1);
		s+=toString(index*2+1,level+1);
		return s;
		
		
	}
	
	public String toString() {
		return toString(1,0);
	}

}
