public class Combinatoria {
	
	public static int n = 0;
	
	public static void combinazioni(char[] alfabeto,int classe) {
		int length = alfabeto.length;
		boolean[] u = new boolean[length];
		char[] s = new char[classe];
		for(int i=0;i<length;i++) {
			if(u[i]==true) continue;
			u[i]=true;
			s[0]=alfabeto[i];
			combinazioni(alfabeto,classe,u,s,1);
			
		}
	}
	
	private static void permutazioni(char[] alfabeto,boolean[] u, char[] s,int h) {
		if(h==alfabeto.length) {
			System.out.println(s);
			n++;
			return;
		}
		for(int i=0;i<alfabeto.length;i++) {
			if(u[i]==true) continue;
			u[i]=true;
			s[h]=alfabeto[i];
			permutazioni(alfabeto,u,s,h+1);
			u[i]=false;
		}
	}
	
	public static void permutazioni(char[] alfabeto) {
		int length = alfabeto.length;
		boolean[] u = new boolean[length];
		char[] s = new char[length];
		for(int i=0;i<length;i++) {
			if(u[i]==true) continue;
			u[i]=true;
			s[0]=alfabeto[i];
			permutazioni(alfabeto,u,s,1);
			u[i]=false;			
		}
	}
	
	private static void disposizioni(char[] alfabeto, int classe,
									char[] s, boolean[] u,int level)
	{
		if(level==classe) {
			System.out.println(s);
			n++;
			return;
		}
		for(int i=0;i<alfabeto.length;i++) {
			if(u[i]==true) continue;
			u[i]=true;
			s[level]=alfabeto[i];
			disposizioni(alfabeto,classe,s,u,level+1);
			u[i]=false;
		}
		
	}
	
	public static void disposizioni(char[] alfabeto, int classe) {
		int length = alfabeto.length;
		boolean[] u = new boolean[length];
		char[] s = new char[classe];
		for(int i=0;i<length;i++) {
			if(u[i]==true) continue;
			u[i]=true;
			s[0]=alfabeto[i];
			disposizioni(alfabeto,classe,s,u,1);
			u[i]=false;
			
		}
	}
	
	public static void main(String[] args) {
		char[] alfabeto = {'a','b','c','d','e','f'};
		int classe = Integer.parseInt(args[0]);
		combinazioni(alfabeto,classe);
		System.out.println(n);
	}
}
