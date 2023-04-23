/**
 * Interfaccia per un albero binario di ricerca
 *
 * @author Michael Goodrich
 */
public interface BSTree<E> {

    /**
     * Ritorna true se l'albero e' vuoto (non ha nessun nodo)
	 *
     * @return	 
     */
    public boolean isEmpty();

    /**
     * indica se il nodo e' una foglia dell'albero
	 *
	 * @param v
     * @return	 
     */
    public boolean isLeaf(BSPosition<E> v);	
	
    /**
     * ritorna la radice dell'albero
	 *
     * @return	 
     */
    public BSPosition<E> getRoot();		
	
    /**
     * inserisce un nuovo valore ritornando il nodo creato
     *
     * @param k, e
     * @return	 
     */
    public BSPosition<E> insert(int k, E e);
	
    /**
     * rimuove un nodo (se esiste) ritornando il nodo rimosso
     *
     * @param k
	 * @return     
	 */
    public BSPosition<E> remove(int k);
	
	/**
     * cerca il nodo con chiave k e ritorna il valore associato
     *
     * @param k, e
     * @return	 
     */
    public E find(int k);
  
    public int size();
    public int n();

}
