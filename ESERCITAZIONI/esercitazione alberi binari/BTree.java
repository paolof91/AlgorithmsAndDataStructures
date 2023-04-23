/**
 * Interfaccia per un albero dove i nodi possono avere al piu' 2 figli
 *
 * @author Michael Goodrich
 */
public interface BTree<E> {

    /**
     * Ritorna true se l'albero e' vuoto (non ha nessun nodo)
     */
    public boolean isEmpty();

    /**
     * indica se il nodo rappresenta la radice dell'albero
     */
    public boolean isRoot(BPosition<E> v);

    /**
     * imposta la root ritornando il nodo creato
     *
     * @param n
     */
    public BPosition<E> setRoot(E n);
	
    /**
     * Ritorna la root dell'albero
     */
    public BPosition<E> getRoot();	
	
    /**
     * Modifica il valore di un dato nodo
     */
    public E replace(BPosition<E> v, E e);	
}
