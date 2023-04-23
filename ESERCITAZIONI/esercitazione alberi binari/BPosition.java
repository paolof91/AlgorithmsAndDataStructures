import java.util.*;

/**
 * Interfaccia che definisce il nodo di un albero binario
 *
 * @author Roberto Tamassia, Michael Goodrich
 */
public interface BPosition<E> {
	/**
	 * le sottoclassi dovrebbero prendere nel costruttore
	 * il nodo Parent ed impostarlo direttamente
	 */

    /**
     * imposta il campo informazione del nodo corrente
     *
     * @param o
     */
    void setElement(E o);
	
    /**
     * modifica il parent del nodo
     *
     * @param v
     */
    void setParent(BPosition<E> v);	

    /**
     * aggiunge il figlio destro al nodo corrente, ritornando il nuovo tree node creato
     *
     * @param elem
     * @return
     */
    public BPosition<E> setRightChild(E elem);
	
    /**
     * aggiunge il figlio sinistro al nodo corrente, ritornando il nuovo tree node creato
     *
     * @param elem
     * @return
     */
    public BPosition<E> setLeftChild(E elem);	

    /**
     * Ritorna il campo "informativo" del nodo
     */
    public E getElement();
	
    /**
     * ritorna il genitore del nodo
     *
     * @return
     */
    public BPosition<E> getParent();	

    /**
     * ritorna il figlio destro (null se non esiste)
     *
     * @return
     */
    public BPosition<E> getRightChild();
	
    /**
     * ritorna il figlio sinistro (null se non esiste)
     *
     * @return
     */
    public BPosition<E> getLeftChild();	
}
