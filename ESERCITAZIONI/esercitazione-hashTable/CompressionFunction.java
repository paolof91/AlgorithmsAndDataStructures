/**
 * Classe per l'hashing
 */
public abstract class CompressionFunction {

    /**
     * comprime l'hashcode in modo da essere compreso tra 0 e n-1
     *
     * @param completeHashCode hashcode generico
     * @param n                dimensione array
     * @return hashcode normalizzato
     */
    protected abstract int compression(int completeHashCode, int n);

}
