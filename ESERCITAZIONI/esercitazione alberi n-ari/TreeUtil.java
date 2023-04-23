/**
 * Classe di utility
 */
public class TreeUtil {
    /**
     * Stampa un albero
     *
     * @param tree
     */
    public static void stampa(Tree<Integer> tree) {
        stampa(tree.root(), 0);
    }

    private static void stampa(Position<Integer> root, int level) {
        if (root == null) return;
        for (int i = 0; i < level - 1; i++) {
            System.out.print("   ");
        }
        if (level > 0)
            System.out.print(" |--");
        System.out.println(root.element());
        for (Position<Integer> children : root.getChildren()) {
            stampa(children, level + 1);
        }
    }
}
