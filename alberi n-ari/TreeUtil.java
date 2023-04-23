import java.util.Iterator;
public class TreeUtil {
	public static <E> void printTree(Tree<E> tree) {
		printTreeRecursive(tree.root(),0);
	}
	
	private static <E> void printTreeRecursive(Position<E> v, int level) {
		for(int i=0;i<level-1;i++)
			System.out.print("      ");
		if(level>0)
			System.out.print("|---- ");
		System.out.println(v.element());
		Iterator<Position<E>> i = v.children().iterator();
		while(i.hasNext())
			printTreeRecursive(i.next(),level+1);
	}
}
