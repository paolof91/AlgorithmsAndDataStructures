import java.util.*;

public class Mergesort {

//*********************************************************
//***************mergesort ottimizzazione3 iterativo ******		
	
	private static void mergesortBest(int[] s) {
		if(s.length==1) return;
		int[] temp = new int[s.length];
		
		for(int i=1;i<s.length;i*=2)
			for(int j=0;j<s.length-i;j+=2*i)
				mergeBest(s,temp,j,i);
	}

	private static void mergeBest(int[] s,int[] temp,int start,int length) {
		int k = start;
		int end1 = start + length;
		int j= 	start + length;
		int end2;
		if(start+2*length>s.length)
			end2=s.length;
		else
			end2=start+2*length;	
		int i=start;
		
		while(i!=end1&&j!=end2) {
			if(s[i]<s[j]) {
				temp[k]=s[i];
				i++;
			} else {
				temp[k]=s[j];
				j++;
			}
			k++;
		}
		
		int kk=k;
		for(;i<end1;i++,k++)
			s[k]=s[i];
			
		for(j=start;j<kk;j++)
			s[j]=temp[j];
			
	}
	
//*********************************************************
//***************mergesort ottimizzazione2 iterativo ******		
	
	private static void mergesort(int[] s) {
		if(s.length==1) return;
		int[] temp = new int[s.length];
		
		for(int i=1;i<s.length;i*=2)
			for(int j=0;j<s.length-i;j+=2*i)
				merge(s,temp,j,i);
			
	}
	
	private static void merge(int[] s,int[] temp,int start,int length) {
		int k = start;
		int end1 = start + length;
		int j= 	start + length;
		int end2;
		if(start+2*length>s.length)
			end2=s.length;
		else
			end2=start+2*length;	
		int i=start;
		
		while(i!=end1&&j!=end2) {
			if(s[i]<s[j]) {
				temp[k]=s[i];
				i++;
			} else {
				temp[k]=s[j];
				j++;
			}
			k++;
		}
		
		for(;i<end1;i++,k++)
			temp[k]=s[i];
			
		for(;j<end2;j++,k++)
			temp[k]=s[j];
			
		for(i=start;i<end2;i++)
			s[i]=temp[i];
			
	}
	

//*********************************************************
//***************mergesort ottimizzazione1 con array ******		
	
	private static void mergesort(int[] s,int[] temp,int a,int b) {
		if(b<=a) return;
		mergesort(s,temp,a,(a+b)/2);
		mergesort(s,temp,(a+b)/2+1,b);
		merge(s,temp,a,(a+b)/2+1,b);
	}
	
	private static void merge(int[] s,int[] temp, int a , int m , int b) {
		int i=a;
		int j=m;
		int k=a;
		
		while(i!=m&&j!=b+1) {
			if(s[i]<s[j]) {
				temp[k]=s[i];
				k++;
				i++;
			} else {
				temp[k]=s[j];
				k++;
				j++;
			}
		}
		
		for(;i<m;i++,k++)
			temp[k]=s[i];

		for(;j<=b;j++,k++)
			temp[k]=s[j];
			
		for(i=a;i<=b;i++)
			s[i]=temp[i];
			
	}
	
	
//*********************************************************
//***************mergesort non ottimizzato con ArrayList***	

	private static List<Integer> mergesort(ArrayList<Integer> s,int a,int b) {
		if(b<=a) {
			List<Integer> r = new LinkedList<Integer>();
			r.add(s.get(a));
			return r;
		}
		List<Integer> s1 = mergesort(s,a,(a+b)/2);
		List<Integer> s2 = mergesort(s,(a+b)/2+1,b);
		return merge(s1,s2);
	}
	
	private static List<Integer> merge(List<Integer> s1, List<Integer> s2) {
		List<Integer> s = new LinkedList<Integer>();

		while(!s1.isEmpty()&&!s2.isEmpty())
			if(s1.get(0)<s2.get(0))
				s.add(s1.remove(0));
			else
				s.add(s2.remove(0));
		
		while(!s1.isEmpty())
			s.add(s1.remove(0));
		
		while(!s2.isEmpty())
			s.add(s2.remove(0));
			
		return s;

	}
	
//********************************************************
//************metodi pubblici*****************************

	public static int[] mergesortIterativoOttimizzazione3(int[] s) {
		int[] ss = new int[s.length];
		System.arraycopy(s,0,ss,0,s.length);
		mergesortBest(ss);
		return ss;
	}

	public static int[] mergesortIterativoOttimizzazione2(int[] s) {
		int[] ss = new int[s.length];
		System.arraycopy(s,0,ss,0,s.length);
		mergesort(ss);
		return ss;
	}

	public static int[] mergesortRicorsivoOttimizzazione1(int[] s) {
		int[] ss = new int[s.length];
		int[] temp = new int[s.length];
		System.arraycopy(s,0,ss,0,s.length);
		mergesort(ss,temp,0,s.length-1);
		return ss;
	}
	
 	public static List<Integer> mergesortRicorsivoSequence(ArrayList<Integer> s) {
		return mergesort(s,0,s.size()-1);
	}	
	
	
//*******************************************************
//*************MAIN**************************************	
	
	public static void main(String[] args) {
		
		System.out.println();
		
		int n = 100000;
		ArrayList<Integer> s0;
		int[] s1;
		int[] s2;
		int[] s3;

		Random random = new Random();
		
		long startTime;
		long endTime;
		float difference;
		
		for(int aggiunta=0;aggiunta<7;aggiunta++) {
			
			int size = n+aggiunta*n/20;
			
			s0 = new ArrayList<Integer>(size);
			s1 = new int[size];
			s2 = new int[size];
			s3 = new int[size];
			
			for(int i=0;i<size;i++) {
				s1[i]=s2[i]=s3[i] = random.nextInt(n*15);
				s0.add(s1[i]);
			}
			
			System.out.println(size+" ELEMENTI\n");
			
			System.out.print("mergesortRicorsivoSequence() lasted... ");
			startTime=System.nanoTime();
			mergesortRicorsivoSequence(s0);
			endTime=System.nanoTime();
			difference=(float)(endTime-startTime)/1000000;
			System.out.println(difference+" ms");
			
			System.out.print("mergesortRicorsivoOttimizzazione1() lasted... ");
			startTime=System.nanoTime();
			mergesortRicorsivoOttimizzazione1(s1);
			endTime=System.nanoTime();
			difference=(float)(endTime-startTime)/1000000;
			System.out.println(difference+" ms");

			System.out.print("mergesortIterativoOttimizzazione2() lasted... ");
			startTime=System.nanoTime();
			mergesortIterativoOttimizzazione2(s2);
			endTime=System.nanoTime();
			difference=(float)(endTime-startTime)/1000000;
			System.out.println(difference+" ms");
			
			System.out.print("mergesortIterativoOttimizzazione3() lasted... ");
			startTime=System.nanoTime();
			mergesortIterativoOttimizzazione3(s3);
			endTime=System.nanoTime();
			difference=(float)(endTime-startTime)/1000000;
			System.out.println(difference+" ms");
			
			System.out.println("_________________________________\n");
			
		}				
		
	}	
	
	public static void print(int[] s) {
		System.out.print("[");
		for(int i=0;i<s.length-1;i++)
			System.out.print(s[i]+",");
		System.out.println(s[s.length-1]+"]");
	}
}
