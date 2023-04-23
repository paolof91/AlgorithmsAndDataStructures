import java.util.*;

/**
 * Interfaccia che definisce il nodo dell'albero
 *
 * @author Roberto Tamassia, Michael Goodrich
 */
public interface Position<E> {
    /**
     * aggiunge un nuovo figlio al nodo corrente, ritornando il nuovo tree node creato
     *
     * @param elem
     * @return
     */
    public Position<E> addChildren(E elem);

    /**
     * Ritorna il campo "informativo" del nodo
     */
    E element();

    /**
     * ritorna una lista dei nodi figli (se non ci sono figli dovrebbe ritornare una lista vuota)
     *
     * @return
     */
    List<Position<E>> getChildren();

    /**
     * ritorna il genitore del nodo. Le sottoclassi dovrebbero prendere nel costruttore il nodo Parent ed impostarlo direttamente
     *
     * @return
     */
    Position<E> getParent();

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
    void setParent(Position<E> v);
}
