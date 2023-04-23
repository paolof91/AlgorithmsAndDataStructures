/**
 * BucketArray che contiene una chiave di tipo BucketKey ed un valore
 */
public abstract class BucketArray<V> {
    protected final BucketEntry<V>[] array;
    protected final int capacita;
    protected final HashingFunction hashing;
    private final CompressionFunction compression;

    /**
     * costruisce un bucket array di dimensione n e basato sulla funzione di hashing specificata
     *
     * @param hashing
     * @param capacita
     */
    @SuppressWarnings("unchecked")
    public BucketArray(HashingFunction hashing, CompressionFunction compression, int capacita) {
        this.compression = compression;
        this.capacita = capacita;
        this.hashing = hashing;
        array = new BucketEntry[capacita];
    }

    /**
     * size totale
     *
     * @return site totale
     */
    public int getCapacita() {
        return capacita;
    }

    public HashingFunction getHashing() {
        return hashing;
    }

    /**
     * restituisce il bucket entry associato alla chiave oppure null
     *
     * @param key chiave
     * @return entry se presente
     */
    public abstract V get(String key);

    /**
     * controlla se l'elemento e' una collisione
     *
     * @param i indice
     * @return true se l'elemento e' nullo
     */
    public boolean isCollision(int i) {
        if (array[i] == null) return false;
        final int hh = hashCode(array[i].getKey(), capacita);
        return hh != i;
    }

    /**
     * @param key
     * @param n
     * @return
     */
    public final int hashCode(String key, int n) {
        final int code = compression.compression(hashing.hashing(key), n);
        if (code < 0 || code >= n) throw new IllegalArgumentException("Invalid hashing " + code);
        return code;
    }

    /**
     * controlla se l'elemento e' vuoto
     *
     * @param i indice
     * @return true se l'elemento e' nullo
     */
    public boolean isEmpty(int i) {
        return array[i] == null;
    }

    /**
     * prova ad inserire la coppia nella posizione specificata.
     *
     * @param key   chiave
     * @param value valore
     */
    public abstract void put(String key, V value);

    /**
     * rimove la entry associata alla chiave e restituisce il valore se presente
     *
     * @param key chiave
     * @return valore eliminato
     */
    public abstract V remove(String key);

    /**
     * ritorna il numero di elementi inseriti nel bucket
     *
     * @return numero elementi
     */
    public abstract int size();
}
