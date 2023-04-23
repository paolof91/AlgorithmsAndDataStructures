public class PolinomialHashingFunction extends HashingFunction {
	public int hashing(String key) {
		return Math.abs(key.hashCode());
	}
}
