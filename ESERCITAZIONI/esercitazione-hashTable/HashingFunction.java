/**
 * Classe per l'hashing
 */
public abstract class HashingFunction {
    
    /**
     * calcola l'hashing della stringa
     *
     * @param key stringa
     * @return hashcode
     */
    protected abstract int hashing(String key);
}
