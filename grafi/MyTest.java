import java.util.*;

public class MyTest {
	public static void main(String[] args) {
//		DirectedGraph<String,Integer> g = new DirectedGraph<String,Integer>();
		Graph<String,Integer> g = new Graph<String,Integer>();

		Vertex<String> firenze = g.insertVertex("Fir");
		Vertex<String> milano = g.insertVertex("Mil");
		Vertex<String> napoli = g.insertVertex("Nap");
		Vertex<String> roma = g.insertVertex("Rom");
		Vertex<String> ancona = g.insertVertex("Anc");
		Vertex<String> genova = g.insertVertex("Gen");
		Vertex<String> bari = g.insertVertex("Bar");
		Vertex<String> torino = g.insertVertex("Tor");
		Vertex<String> venezia = g.insertVertex("Ven");
		
		
		g.insertEdge(roma,milano,400);
		g.insertEdge(milano,napoli,700);
		g.insertEdge(roma,napoli,250);
		g.insertEdge(napoli,ancona,550);
		g.insertEdge(ancona,genova,500);
		g.insertEdge(genova,bari,1050);
		g.insertEdge(bari,napoli,350);
		g.insertEdge(genova,napoli,600);
		g.insertEdge(ancona,roma,250);
		
		g.insertEdge(venezia,torino,400);
		g.insertEdge(torino,roma,650);
		g.insertEdge(milano,torino,250);
		g.insertEdge(ancona,venezia,150);
		
		g.insertEdge(ancona,bari,400);
		g.insertEdge(ancona,firenze,300);
		g.insertEdge(firenze,genova,220);		
		
		
//		DirectedGraph<String,String> g1 = new DirectedGraph<String,String>();
/*		Graph<String,String> g1 = new Graph<String,String>();
		
		Vertex<String> a = g1.insertVertex("A");
		Vertex<String> b = g1.insertVertex("B");
		Vertex<String> c = g1.insertVertex("C");
		Vertex<String> d = g1.insertVertex("D");
		Vertex<String> e = g1.insertVertex("E");
		Vertex<String> f = g1.insertVertex("F");
		g1.insertEdge(a,b,"AB");
		g1.insertEdge(a,c,"AC");
		g1.insertEdge(b,d,"BD");
		g1.insertEdge(c,d,"CD");
		g1.insertEdge(b,e,"BE");
		g1.insertEdge(c,f,"CF");
		g1.insertEdge(d,e,"DE");
		g1.insertEdge(d,f,"DF");
*/		
/*		System.out.println("\n-----Leggenda------"+
							"\nUNEXPLORED:\tblack"+
							"\nDISCOVERY:\tblue"+
							"\nCROSS:\t\tgreen"+
							"\nBACK:\t\tpink"+
							"\nFORWARD:\tdark gray");
*/		
		GraphUtil.minimumPath(g,milano,firenze);
		GraphFrame.show(g,"Dijkstra minimum path from "+milano+" to "+firenze);
		
		System.out.println("\n-----Leggenda------"+
							"\nDIJKSTRA TREE:\blue"+
							"\nDIJKSTRA PATH:\tred");

		
	}
	
	public static void print(LinkedList<LinkedList<Vertex>> l) {
		Iterator<LinkedList<Vertex>> i = l.iterator();
		while(i.hasNext())
			System.out.println(i.next());
	}
	
	
}

