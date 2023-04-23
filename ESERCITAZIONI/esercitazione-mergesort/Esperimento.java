
import java.io.*;

public class Esperimento {

    private static String nomeFile = "ris.dat";
	private static int n		   = 20;
	private static int o		   = 0;	

	public static void main(String[] args) {
	
	    if (args.length > 0)			
			n = Integer.parseInt(args[0]);	
	    if (args.length > 1)
			o = Integer.parseInt(args[1]);	
	    if (args.length > 2)
			nomeFile = args[2];			
	    cancellaRisultati();
		
		Integer[] pluto = ArrayUtil.getRandomArray(n, n, o);
			
		ArrayUtil.stampa(pluto);
		
		System.out.println("sort di " + n + " interi... ");
		long prima = System.currentTimeMillis();
		//Ordinamento.selectionSort(pluto);		
		//Ordinamento.insertionSort(pluto);
		//Ordinamento.quickSort(pluto);
		//Ordinamento.heapSort(pluto);
		Ordinamento.mergeSort(pluto);
		long dopo = System.currentTimeMillis();		
		
		int min, sec, msec;
		
		min  = (int) Math.floor((dopo-prima)/(1000*60));
		sec  = (int) Math.floor((dopo-prima)/1000) % 60;		
		msec = (int) (dopo-prima)%1000;				
		salvaRisultati("Insertion Sort", n, min, sec, msec);
		
		System.out.println("risultati inseriti.");
		
	}
	
    private static void salvaRisultati(String alg, int n, int min, int sec, int msec) {
		try	{
			FileWriter fw = new FileWriter(nomeFile, true);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter outFile = new PrintWriter (bw);
			outFile.println(alg+" su "+n+" elementi "+min+":"+sec+":"+msec+"."); 
			outFile.close();
		}
		catch (FileNotFoundException exception){
			System.out.println("file di salvataggio inesistente!");		
		}
		catch (IOException exception){
			System.out.println("errore nel salvataggio dei risultati!");		
		}		
	}
	
	private static void cancellaRisultati() {
		File f = new File(nomeFile); 
		if(f.exists()) {
			if(f.delete()) 
				System.out.println("risultati eliminati!");
		}
		else {
			System.out.println("errore nell'eliminazione dei risultati!");
		}
	}	

}