public class Problema {
	
	private static int[] trovaNumeri(int N,int n,int[] S,int level) {
		if(level==S.length) {
			int prodotto = 1;
			for(int i : S)
				prodotto*=i;
			if(prodotto==N) return S;
			return null;
		}
		
		for(int i=2;i<=n;i++) {
			if(level>0) {
				if(i<S[level-1])
					continue;
			}
			if(n%i!=0) continue;
			S[level]=i;
			int[] ris = trovaNumeri(N,n/i,S,level+1);
			if(ris!=null) return ris;
		}
		return null;
	}
	
	public static int[] trovaNumeri(int n,int k) {
		if(k>n) return null;
		int[] S = new int[k];
		return trovaNumeri(n,n,S,0);
	}
	
	
	public static void main(String[] args) {
		print(trovaNumeri(Integer.parseInt(args[0]),
							Integer.parseInt(args[1])));
	}
	
	public static void print(int[] array) {
		if(array==null) {
			System.out.println("null");
			return;
		}
		for(int i : array)
			System.out.print(i+" ");
		System.out.println();
	}
}
