public class BucketArrayUtil {
	static class Info {
		public int correct;
		public int empty;
		public int collision;
		public int capacita;
		public int size;
		public double loadFactor;
		
		public Info() {
			correct=empty=collision=size=capacita=0;
			loadFactor=0;
		}
		
		public String toString() {
			return "collisions:\t"+collision;
/*			return "capacita:\t"+capacita+
					"\nloadFactor:\t"+loadFactor+
					"\nsize:\t\t"+size+
					"\ncorrect:\t"+correct+
					"\ncollision:\t"+collision+
					"\nempty:\t\t"+empty+"\n";
*/		}
	}
	
	public static Info getInfo(BucketArray b) {
		Info info = new Info();
		for(int i=0;i<b.getCapacita();i++) {
			if(b.isEmpty(i)) {
				info.empty++;
				continue;
			}
			if(b.isCollision(i)) {
				info.collision++;
				continue;
			}
			info.correct++;
		}
		info.capacita=b.getCapacita();
		
        int s = 0;
        if(b instanceof LinearProbingBucketArray)
			s = (((LinearProbingBucketArray)b).size());
        if(b instanceof QuadraticProbingBucketArray)
			s = (((QuadraticProbingBucketArray)b).size());
		info.size=s;
		info.loadFactor=((double)(info.size))/info.capacita;
		return info;
		
	}
	
}
