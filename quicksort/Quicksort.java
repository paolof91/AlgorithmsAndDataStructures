import java.util.LinkedList;
import java.util.Random;

public class Quicksort {
	
	private static Random random = new Random();
	
	private static void quicksortRicorsivo(int[] s,int a,int b) {
		if(a>=b) return;
		int pivot = s[b];
		
		int i=a;
		int j=b-1;
		
		while(i<=j) {
			while(i<=j&&s[i]<=pivot)
				i++;
			while(i<=j&&s[j]>=pivot)
				j--;
			if(i<j) {
				int temp = s[i];
				s[i]=s[j];
				s[j]=temp;
			}
		}

		int temp= s[i];
		s[i]=s[b];
		s[b]=temp;
		quicksortRicorsivo(s,a,i-1);
		quicksortRicorsivo(s,i+1,b);
	}
	
	public static void quicksortRicorsivo(int[] s) {
		quicksortRicorsivo(s,0,s.length-1);

	}
	
	public static LinkedList<Integer> quicksortRicorsivoSequence(LinkedList<Integer> S) {
		if(S.size()==0) return new LinkedList<Integer>();
		if(S.size()==1) return S;
		LinkedList<Integer> L = new LinkedList<Integer>();
		LinkedList<Integer> E = new LinkedList<Integer>();
		LinkedList<Integer> G = new LinkedList<Integer>();
		
		int pivot = S.remove();
		E.add(pivot);
		
		while(!S.isEmpty())
			if(S.getFirst()<pivot)
				L.add(S.remove());
			else if(S.getFirst()==pivot)
				E.add(S.remove());
			else
				G.add(S.remove());
		
		LinkedList<Integer> sortedS = new LinkedList<Integer>();
		sortedS.addAll(quicksortRicorsivoSequence(L));
		sortedS.addAll(E);
		sortedS.addAll(quicksortRicorsivoSequence(G));
		
		return sortedS;
	}
	
	
	public static void main(String[] args) {
		int n = 150;
		
		int[] l = new int[n];
		
		for(int i=0;i<n;i++)
			l[i] = random.nextInt(n*15);
			
		print(l);
		quicksortRicorsivo(l);
		print(l);
	}
	
	public static void print(int[] l) {
		for(int i : l)
			System.out.print(i+" ");
		System.out.println();
	}
}
