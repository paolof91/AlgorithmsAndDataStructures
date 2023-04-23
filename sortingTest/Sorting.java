import java.util.Random;

public class Sorting {		
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
	
	public static void insertionsort(int[] s) {
		if(s.length<2) return;
		int temp,temp2,toInsert;
		boolean flag=false;
		temp=temp2=toInsert=0;
		for(int i=1;i<s.length;i++) {
			toInsert = s[i];
			for(int j=0;j<=i;j++) {
				if(flag) {
					temp2=temp;
					temp=s[j];
					s[j]=temp2;
				} else {
					if(s[j]>toInsert) {
						temp = s[j];
						s[j]=toInsert;
						flag=true;
					}
				}
			}
			flag=false;
		}
	}
		
	public static void heapsort(int[] s) {
		for(int i=1;i<s.length;i++)
			upheap(s,i);
			
		
		for(int i=s.length-1;i>0;i--) {
			int temp = s[i];
			s[i]=s[0];
			s[0] = temp;
			downheap(s,0,i);
		}
	}	

	public static void mergesort(int[] s) {
		if(s.length==1) return;
		int[] temp = new int[s.length];
		
		for(int i=1;i<s.length;i*=2)
			for(int j=0;j<s.length-i;j+=2*i)
				mergeBest(s,temp,j,i);
	}

	private static void quicksort(int[] s,int a,int b) {
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
		quicksort(s,a,i-1);
		quicksort(s,i+1,b);
	}
	
	public static void quicksort(int[] s) {
		quicksort(s,0,s.length-1);

	}
	
	public static void main(String[] args) {
		
		System.out.println();
		
		int n = 100000;

		int[] s1;
		int[] s2;
		int[] s3;
		int[] s4;

		Random random = new Random();
		
		long startTime;
		long endTime;
		float difference;
		
		for(int aggiunta=0;aggiunta<20;aggiunta++) {
			
			int size = n+aggiunta*n/2;
			
			s1 = new int[size];
			s2 = new int[size];
			s3 = new int[size];
			s4 = new int[size];
			
			for(int i=0;i<size;i++)
				s1[i]=s2[i]=s3[i]=s4[i]=random.nextInt(n*15);
			
			System.out.println(size+" ELEMENTI\n");
			
			System.out.print("quicksort() lasted... ");
			startTime=System.nanoTime();
			quicksort(s4);
			endTime=System.nanoTime();
			difference=(float)(endTime-startTime)/1000000;
			System.out.println(difference+" ms");

			System.out.print("mergesortOttimizzato() lasted... ");
			startTime=System.nanoTime();
			mergesort(s1);
			endTime=System.nanoTime();
			difference=(float)(endTime-startTime)/1000000;
			System.out.println(difference+" ms");
			
			System.out.print("heapsort() lasted... ");
			startTime=System.nanoTime();
			heapsort(s2);
			endTime=System.nanoTime();
			difference=(float)(endTime-startTime)/1000000;
			System.out.println(difference+" ms");
/*
			System.out.print("insertionsort() lasted... ");
			startTime=System.nanoTime();
			insertionsort(s3);
			endTime=System.nanoTime();
			difference=(float)(endTime-startTime)/1000000;
			System.out.println(difference+" ms");
*/			
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
