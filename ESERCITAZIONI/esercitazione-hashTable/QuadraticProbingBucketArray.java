public class QuadraticProbingBucketArray<V> extends BucketArray<V> {
	private int size;
	
	public QuadraticProbingBucketArray(HashingFunction hashingFunction,int capacita) {
		super(hashingFunction,new DivCompressionFunction(),capacita);
		size=0;
	}
	
	public int size() {
		return size;
	}
	
	public V remove(String key) {
		int code = hashCode(key,capacita);
		for(int n=0;n<capacita;n++) {
			if(array[(code+n*n)%capacita]==null) return null;
			if(array[(code+n*n)%capacita].getKey().equals(key)) {
				V v = array[(code+n*n)%capacita].getValue();
				array[(code+n*n)%capacita]=null;
				size--;
				return v;
			}
		}
		return null;
		
	}
	
	public void put(String key,V value) {
		int code = hashCode(key,capacita);
		for(int n=0;n<capacita;n++) {
			if(array[(code+n*n)%capacita]==null) {
				array[(code+n*n)%capacita]=new BucketEntry<V>(key,value);
				size++;
				return;
			}
			if(array[(code+n*n)%capacita].getKey().equals(key)) {
				V v = array[(code+n*n)%capacita].getValue();
				array[(code+n*n)%capacita]=new BucketEntry<V>(key,value);
				return;
			}
		}
		throw new RuntimeException("hashTable piena");
	}
	
	public V get(String key) {
		int code = hashCode(key,capacita);

		for(int n=0;n<capacita;n++) {
			if(array[(code+n*n)%capacita]==null)
				return null;
			if(array[(code+n*n)%capacita].getKey().equals(key))
				return array[(code+n*n)%capacita].getValue();
		}
		return null;
	}
}
