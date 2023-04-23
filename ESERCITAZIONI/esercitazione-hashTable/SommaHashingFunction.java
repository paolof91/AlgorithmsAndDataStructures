public class SommaHashingFunction extends HashingFunction {
	public int hashing(String key) {
		int sum = 0;
		for(int i=0;i<key.length();i++)
			sum+=key.charAt(i);
		return sum;
	}
}
