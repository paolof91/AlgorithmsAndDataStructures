/**
 * Interfaccia per un albero dove i nodi possono avere un numero arbitrario di figli
 *
 * @author Michael Goodrich
 */
public interface Tree<E> {
    /**
     * Ritorna un oggetto Iterable (implementato da List e Collection di JCF) dei figli
     */
    public Iterable<Position<E>> children(Position<E> v);

    /**
     * Ritorna true se l'albero e' vuoto (non ha nessun nodo)
     */
    public boolean isEmpty();

    /**
     * indica se il nodo rappresenta la radice dell'albero
     */
    public boolean isRoot(Position<E> v);


    /**
     * ritorna il genitore di un nodo
     */
    public Position<E> parent(Position<E> v);

    /**
     * Modifica il valore di un dato nodo
     */
    public E replace(Position<E> v, E e);

    /**
     * Ritorna la root dell'albero
     */
    public Position<E> root();

    /**
     * imposta la root ritornando il nodo creato
     *
     * @param n
     */
    public Position<E> setRoot(E n);
}
