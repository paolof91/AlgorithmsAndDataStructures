/**
 * Entry di un bucket array con chiave di tipo string
 */
public final class BucketEntry<V> {
    /**
     * chiave
     */
    protected final String key;

    /**
     * valore
     */
    protected final V value;

    public BucketEntry(String key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * chiave
     *
     * @return chiave
     */
    public String getKey() {
        return key;
    }

    /**
     * valore
     *
     * @return valore
     */
    public V getValue() {
        return value;
    }
}
