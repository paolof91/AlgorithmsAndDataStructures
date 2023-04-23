public class Combinatoria {
	public static int n = 0;
	public static void permutazioni(char[] alfabeto) {
		disposizioni(alfabeto,alfabeto.length);
	}
	
	private static void disposizioniRecursive(char[] alfabeto, char[] s,boolean[] u,int k, int level) {
		if(level==k) {
			n++;
			System.out.println(s);
			return;
		}
		for(int i=0;i<alfabeto.length;i++) {
			if(u[i]==true) continue;
			u[i]=true;
			s[level]=alfabeto[i];
			disposizioniRecursive(alfabeto,s,u,k,level+1);
			u[i]=false;			
		}
	}
	
	public static void disposizioni(char[] alfabeto, int k) {
		int length = alfabeto.length;
		if(length<=0||k>length) throw new RuntimeException("Impossibile effettuare le disposizioni per quest'oggetto");
		char[] s = new char[k];
		boolean[] u = new boolean[length];
		int level = 0;
		for(int i=0;i<length;i++) {
			u[i]=true;
			s[level]=alfabeto[i];
			disposizioniRecursive(alfabeto,s,u,k,level+1);
			u[i]=false;		
		}
	}
	
	public static void main(String[] args) {
		char[] alfabeto = {'2','3','4','5','6','7'};
		System.out.println(alfabeto);
		permutazioni(alfabeto);
		System.out.println("\n"+n+" stampe");
	
	}
}
