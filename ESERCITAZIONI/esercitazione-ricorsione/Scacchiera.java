

import java.util.*;

/**
 * Classe di supporto per la risoluzione del problema delle k regine
 */
public class Scacchiera {
    public int getK() {
        return k;
    }

    private final int k;

    private final int[] matrice;

    /**
     * crea una scacchiera N x N e posiziona tutte le regine sulla prima riga
     *
     * @param k
     */
    public Scacchiera(int k) {
        this.k = k;
        matrice = new int[k];
        for (int i = 0; i < k; matrice[i++] = 0) ;
    }

    /**
     * stampa la scacchiera su console
     * @return
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        final Formatter formatter = new Formatter();
        for (int j = 0; j < k; j++) {
            formatter.format("%4d", j);
        }
        sb.append(formatter).append("\n");
        sb.append("+");
        for (int j = 0; j < k; j++) {
            sb.append("---+");
        }
        sb.append("\n");

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                final int regina = dammiRegina(i, j);
                sb.append("|");
                if (regina == -1)
                    sb.append("   ");
                else
                    sb.append(" " + "*" + " ");
            }
            sb.append("|\n+");
            for (int j = 0; j < k; j++) {
                sb.append("---+");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * restituisce il numero della regina presente nella scacchiera nella posizione (riga,colonna)
     * oppure -1 se non c'e' alcuna regina.
     * NB: il numero di colonna corrisponde implicitamente al numero di regina
     * in quanto su una stessa colonna puo' esserci una sola regina
     *
     * @param riga
     * @param colonna
     * @return
     */
    public int dammiRegina(int riga, int colonna) {
        checkRiga(riga);
        checkColonna(colonna);
        return matrice[colonna] == riga ? colonna : -1;
    }

    private void checkRiga(int numeroRiga) {
        if (numeroRiga < 0 || numeroRiga >= k)
            throw new IndexOutOfBoundsException("Numero di riga " + numeroRiga + " non corretto");
    }

    /**
     * controlla la correttezza del numero di colonna
     *
     * @param numeroColonna
     */
    private void checkColonna(int numeroColonna) {
        if (numeroColonna < 0 || numeroColonna >= k)
            throw new IndexOutOfBoundsException("Numero di colonna " + numeroColonna + " non corretto");
    }

    /**
     * ritorna il numero di riga in cui e' posizionata la regina specificata
     *
     * @param numeroRegina
     * @return
     */
    public int dammiRiga(int numeroRegina) {
        return matrice[numeroRegina];
    }

    public static void main(String[] args) {
        final int N = 5;
        Scacchiera s = new Scacchiera(N);
        s.impostaRegina(0, 3);
        s.impostaRegina(2, 1);
        s.impostaRegina(3, 4);
        System.out.println(s);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && s.sottoMinaccia(i, j)) {
                    System.out.print(" (" + i + "," + j + ")");
                }
            }
        }
    }

    /**
     * imposta la regina specificata sul numero di riga indicato
     *
     * @param numeroRegina numero regina (tra 0 e n-1)
     * @param numeroRiga   numero riga (tra 0 e n-1)
     * @throws IndexOutOfBoundsException rilancia una eccezione se il numero di regina o la riga non sono corretti
     */
    public void impostaRegina(int numeroRegina, int numeroRiga) throws IndexOutOfBoundsException {
        checkRiga(numeroRiga);
        checkRegina(numeroRegina);
        matrice[numeroRegina] = numeroRiga;
    }

    /**
     * ritorna true se la regina 'numRegina1' minaccia la regina 'numRegina2'
     *
     * @param numRegina1
     * @param numRegina2
     * @return
     */
    public boolean sottoMinaccia(int numRegina1, int numRegina2) {
        checkRegina(numRegina1);
        checkRegina(numRegina2);

        final int riga1 = matrice[numRegina1];
        final int riga2 = matrice[numRegina2];
        if (riga1 == riga2) return true;

        //se stessa diagonale principale (dal basso a sx all'alto a dx)
        if (riga1 + numRegina1 == riga2 + numRegina2) return true;

        //se stessa diagonale secondaria (dall'alto a sx al basso a dx)
        if (riga1 - numRegina1 == riga2 - numRegina2) return true;

        return false;
    }

    private void checkRegina(int numeroRegina) {
        if (numeroRegina < 0 || numeroRegina >= k)
            throw new IndexOutOfBoundsException("Indice regina " + numeroRegina + " non corretto");
    }
}
