public class MyTest {
	static java.util.Random random = new java.util.Random();
	
	public static String randomString() {
		
		String s = "";
		int length = random.nextInt(80)+1;
		for(int i=0;i<length;i++)
			s+=(char)(random.nextInt(128));
		return s;
	}
	
	public static void main(String[] args) {
		int capacita = 24917;
		double load1,load2,load3;
		load1=0.2;
		load2=0.5;
		load3=0.9;
		BucketArray<Integer> a,b;
		
		
		a = new LinearProbingBucketArray<Integer>(new SommaHashingFunction(),capacita);
		b = new QuadraticProbingBucketArray<Integer>(new SommaHashingFunction(),capacita);
		for(int i=0;i<capacita*load1;i++) {
			String key = randomString();
			int value = random.nextInt();
			a.put(randomString(),random.nextInt());
			b.put(randomString(),random.nextInt());
		}
		
		System.out.println("\n_______________________\n\nHASHTABLE1 | probing lineare    | basso carico | funzione di hashing semplice");
		System.out.println(BucketArrayUtil.getInfo(a));
		System.out.println("\n_______________________\n\nHASHTABLE2 | probing quadratico | basso carico | funzione di hashing semplice");
		System.out.println(BucketArrayUtil.getInfo(b));
		
		a = new LinearProbingBucketArray<Integer>(new SommaHashingFunction(),capacita);
		b = new QuadraticProbingBucketArray<Integer>(new SommaHashingFunction(),capacita);
		for(int i=0;i<capacita*load2;i++) {
			String key = randomString();
			int value = random.nextInt();
			a.put(randomString(),random.nextInt());
			b.put(randomString(),random.nextInt());
		}
		
		System.out.println("\n_______________________\n\nHASHTABLE1 | probing lineare    | medio carico | funzione di hashing semplice");
		System.out.println(BucketArrayUtil.getInfo(a));
		System.out.println("\n_______________________\n\nHASHTABLE2 | probing quadratico | medio carico | funzione di hashing semplice");
		System.out.println(BucketArrayUtil.getInfo(b));

		a = new LinearProbingBucketArray<Integer>(new SommaHashingFunction(),capacita);
		b = new QuadraticProbingBucketArray<Integer>(new SommaHashingFunction(),capacita);
		for(int i=0;i<capacita*load3;i++) {
			String key = randomString();
			int value = random.nextInt();
			a.put(randomString(),random.nextInt());
			b.put(randomString(),random.nextInt());
		}
		
		System.out.println("\n_______________________\n\nHASHTABLE1 | probing lineare    | alto carico | funzione di hashing semplice");
		System.out.println(BucketArrayUtil.getInfo(a));
		System.out.println("\n_______________________\n\nHASHTABLE2 | probing quadratico | alto carico | funzione di hashing semplice");
		System.out.println(BucketArrayUtil.getInfo(b));










		
		a = new LinearProbingBucketArray<Integer>(new PolinomialHashingFunction(),capacita);
		b = new QuadraticProbingBucketArray<Integer>(new PolinomialHashingFunction(),capacita);
		for(int i=0;i<capacita*load1;i++) {
			String key = randomString();
			int value = random.nextInt();
			a.put(randomString(),random.nextInt());
			b.put(randomString(),random.nextInt());
		}
		
		System.out.println("\n_______________________\n\nHASHTABLE1 | probing lineare    | basso carico | funzione di hashing polinomiale");
		System.out.println(BucketArrayUtil.getInfo(a));
		System.out.println("\n_______________________\n\nHASHTABLE2 | probing quadratico | basso carico | funzione di hashing polinomiale");
		System.out.println(BucketArrayUtil.getInfo(b));
		
		a = new LinearProbingBucketArray<Integer>(new PolinomialHashingFunction(),capacita);
		b = new QuadraticProbingBucketArray<Integer>(new PolinomialHashingFunction(),capacita);
		for(int i=0;i<capacita*load2;i++) {
			String key = randomString();
			int value = random.nextInt();
			a.put(randomString(),random.nextInt());
			b.put(randomString(),random.nextInt());
		}
		
		System.out.println("\n_______________________\n\nHASHTABLE1 | probing lineare    | medio carico | funzione di hashing polinomiale");
		System.out.println(BucketArrayUtil.getInfo(a));
		System.out.println("\n_______________________\n\nHASHTABLE2 | probing quadratico | medio carico | funzione di hashing polinomiale");
		System.out.println(BucketArrayUtil.getInfo(b));

		a = new LinearProbingBucketArray<Integer>(new PolinomialHashingFunction(),capacita);
		b = new QuadraticProbingBucketArray<Integer>(new PolinomialHashingFunction(),capacita);
		for(int i=0;i<capacita*load3;i++) {
			String key = randomString();
			int value = random.nextInt();
			a.put(randomString(),random.nextInt());
			b.put(randomString(),random.nextInt());
		}
		
		System.out.println("\n_______________________\n\nHASHTABLE1 | probing lineare    | alto carico | funzione di hashing polinomiale");
		System.out.println(BucketArrayUtil.getInfo(a));
		System.out.println("\n_______________________\n\nHASHTABLE2 | probing quadratico | alto carico | funzione di hashing polinomiale");
		System.out.println(BucketArrayUtil.getInfo(b));


	}
}
