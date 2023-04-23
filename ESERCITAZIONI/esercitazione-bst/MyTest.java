public class MyTest {
	
	static java.util.Random random = new java.util.Random();
	
	public static String randomString() {
		
		String s = "";
		int length = random.nextInt(9)+2;
		for(int i=0;i<length;i++)
			s+=(char)(random.nextInt(56)+65);
		return s;
	}
		
	public static void main(String[] args) {
		BSTree<String> bst = new MyBSTree<String>();
		for(int i=0;i<5000;i++)
			bst.insert(random.nextInt(500000)+1,randomString());
		
		
		System.out.println(bst);
		System.out.println(bst.size()+" "+bst.n());
		
		
	}
}
