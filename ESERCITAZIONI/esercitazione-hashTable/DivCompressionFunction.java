public class DivCompressionFunction extends CompressionFunction {
    public int compression(int completeHashCode, int n) {
		return completeHashCode%n;
	}
}
