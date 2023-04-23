/**
 * Classe di utility
 */
public class BTreeUtil {
    /**
     * Stampa un albero
     *
     * @param tree
     */
    public static <E> void stampa(BTree<E> tree) {
        stampa(tree.getRoot(), 0);
    }

    private static <E> void stampa(BPosition<E> root, int level) {
        if  (root == null) return;
        for (int i = 0; i < level - 1; i++) {
            System.out.print("   ");
        }
        if (level > 0)
            System.out.print(" |--");
        
		System.out.println(root.getElement());
        stampa(root.getLeftChild() , level + 1);
        stampa(root.getRightChild(), level + 1);		
    }
}
