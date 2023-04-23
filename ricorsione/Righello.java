public class Righello {
	public static void disegnaTrattini(int trattini,int label) {
		for(int i=0;i<trattini;i++)
			System.out.print('-');
		if(label!=-1) System.out.print(" "+label);
		System.out.println();
	}
	
	public static void disegnaRighello(int trattini) {
		if(trattini==0) return;
		disegnaRighello(trattini-1);
		disegnaTrattini(trattini,-1);
		disegnaRighello(trattini-1);
	}
	
	public static void righello(int trattini,int numero) {
		disegnaTrattini(trattini,0);
		for(int i=1;i<=numero;i++) {
			disegnaRighello(trattini-1);
			disegnaTrattini(trattini,i);
		}		
	}
	
	public static void main(String[] args) {
		int numero = Integer.parseInt(args[0]);
		int trattini = Integer.parseInt(args[1]);
		righello(trattini,numero);
	}
}
