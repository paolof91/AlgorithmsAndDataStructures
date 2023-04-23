import java.util.*;

public class Heapsort {
	
	private static void upheap(int[] s,int i) {
		if(i==0) return;
		if(s[i]>s[(i-1)/2]) {
			int temp = s[i];
			s[i]=s[(i-1)/2];
			s[(i-1)/2]=temp;
		}
		upheap(s,(i-1)/2);		
	}
	
	private static void downheap(int[] s, int i,int length) {
		if(2*i+2>=length&&2*i+1>=length) return;
		if(2*i+2>=length) {
			if(s[i]<s[2*i+1]) {
				int temp = s[i];
				s[i] = s[2*i+1];
				s[2*i+1]=temp;
				return;
			}
		}
		
		
		
		if(s[i]<s[2*i+1]&&s[i]<s[2*i+2]) {
			if(s[2*i+1]>s[2*i+2]) {
				int temp = s[i];
				s[i] = s[2*i+1];
				s[2*i+1]=temp;
				downheap(s,2*i+1,length);
				return;
			} else {
				int temp = s[i];
				s[i] = s[2*i+2];
				s[2*i+2]=temp;
				downheap(s,2*i+2,length);
				return;
			}
		}
		
		if(s[i]<s[2*i+1]) {
				int temp = s[i];
				s[i] = s[2*i+1];
				s[2*i+1]=temp;
				downheap(s,2*i+1,length);
				return;			
		}
		
		if(s[i]<s[2*i+2]) {
				int temp = s[i];
				s[i] = s[2*i+2];
				s[2*i+2]=temp;
				downheap(s,2*i+2,length);
				return;			
		}
		
	}
	
	public static void heapsort(int[] s) {
	//1 fase GENERAZIONE DELL'HEAP
		for(int i=1;i<s.length;i++)
			upheap(s,i);
			
		printHeap(s);
		
		for(int i=s.length-1;i>0;i--) {
			int temp = s[i];
			s[i]=s[0];
			s[0] = temp;
			downheap(s,0,i);
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		int n=19;
		int[] s = new int[n];
		for(int i=0;i<n;i++)
			s[i] = random.nextInt(200);

		print(s);
		
		heapsort(s);
		
		print(s);
	}
	
	private static void printHeapRecursive(int[] s, int i,int level) {
		if(i>=s.length) return;
		if(level>0) {
			for(int j=0;j<level-1;j++)
				System.out.print("      ");
			System.out.print(" |--- ");
		}
		System.out.println(s[i]);
		printHeapRecursive(s,2*i+1,level+1);
		printHeapRecursive(s,2*i+2,level+1);
	}
	
	public static void printHeap(int[] s) {
		printHeapRecursive(s,0,0);
	}
	
	public static void print(int[] s) {
		for(int i:s)
			System.out.print(i+" ");
		System.out.println();
	}
}
