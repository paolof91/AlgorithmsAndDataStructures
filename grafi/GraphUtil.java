import java.util.*;

public class GraphUtil {
	private static int visitNumber=1;
	private static int leaveNumber=1;

	public static LinkedList<Position> minimumPath(Graph graph, Vertex source,Vertex destination) {
		Iterator<Vertex> i = graph.vertices().iterator();
		HeapPQ heap = new HeapPQ();
		
		while(i.hasNext()) {
			Vertex v = i.next();
			if(v==source) {
				v.setDistance(0);
			} else {
				v.setDistance(Integer.MAX_VALUE);
			}
			heap.insert(v);
		}

		while(!heap.isEmpty()) {
			Vertex v = heap.removeMin();
			Iterator<Edge> j = graph.incidentEdges(v).iterator();
			while(j.hasNext()) {
				Edge edge = j.next();
				Vertex w = graph.opposite(v,edge);
				if(w.distance()>v.distance()+edge.weight()) {
					w.setDistance(v.distance()+edge.weight());
					w.setDijkstraEdge(edge);
					heap.reload(w.getIndex());
				}
			
			}
			
		}

		i = graph.vertices().iterator();
		while(i.hasNext()) {
			Vertex v = i.next();
			if(v==source) continue;
			v.getDijkstraEdge().setLabel("DIJKSTRA");
		}
		
		LinkedList<Position> minimumPath = new LinkedList<Position>();
		Vertex p = destination;
		
		while(p!=source) {
			minimumPath.addFirst(p);
			p.setLabel("DIJKSTRA PATH");
			if(p.getDijkstraEdge()!=null) {
				minimumPath.addFirst(p.getDijkstraEdge());
				p.getDijkstraEdge().setLabel("DIJKSTRA PATH");
			}
			p=graph.opposite(p,p.getDijkstraEdge());
		}
		
		return minimumPath;

	}

	public static LinkedList<LinkedList<Vertex>> BFS(Graph graph) {
		Iterator<Vertex> i = graph.vertices().iterator();
		Iterator<Edge> j = graph.edges().iterator();
		
		while(i.hasNext()) {
			Vertex v = i.next();
			v.setLabel("UNEXPLORED");
			v.setDistance(0);
		}
		
		while(j.hasNext())
			j.next().setLabel("UNEXPLORED");
			
		i = graph.vertices().iterator();
		
		LinkedList<LinkedList<Vertex>> l = new LinkedList<LinkedList<Vertex>>();
		
		while(i.hasNext()) {
			Vertex v = i.next();
			if(v.getLabel().equals("UNEXPLORED"))
				l.addAll(BFS(graph,v));

		}
		
		return l;
		
	}
	
	private static LinkedList<LinkedList<Vertex>> BFS(Graph graph,Vertex source) {
		LinkedList<LinkedList<Vertex>> listBFS = new LinkedList<LinkedList<Vertex>>();
		LinkedList<Vertex> l0 = new LinkedList<Vertex>();
		LinkedList<Vertex> l1 = new LinkedList<Vertex>();
		int distance = 0;
		source.setLabel("VISITED");
		source.setDistance(distance++);
		l0.add(source);
		
		while(!l0.isEmpty()) {
			Iterator<Vertex> i = l0.iterator();
			while(i.hasNext()) {
				Vertex v = i.next();
				Iterator<Edge> j = graph.incidentEdges(v).iterator();
				while(j.hasNext()) {
					Edge e = j.next();
					if(e.getLabel().equals("UNEXPLORED")) {
						Vertex w = graph.opposite(v,e);
						if(w.getLabel().equals("UNEXPLORED")) {
							l1.add(w);
							e.setLabel("DISCOVERY");
							w.setLabel("VISITED");
							w.setDistance(distance);
						} else
							e.setLabel("CROSS");
					}
				}
			}
			listBFS.add(l0);
			l0=l1;
			l1 = new LinkedList<Vertex>();
			distance++;
		}
		
		return listBFS;
	}
	
	public static <V,E> void DFS(Graph<V,E> graph) {
		Iterator<Vertex<V>> i = graph.vertices().iterator();
		
		while(i.hasNext()) {
			Vertex<V> v = i.next();
			v.setLabel("UNEXPLORED");
		}
		
		Iterator<Edge<E>> j = graph.edges().iterator();
		
		while(j.hasNext()) {
			Edge<E> v = j.next();
			v.setLabel("UNEXPLORED");
		}
		
		i = graph.vertices().iterator();
		
		while(i.hasNext()) {
			Vertex<V> v = i.next();
			if(v.getLabel().equals("UNEXPLORED"))
				DFS(graph,v);
		}
		
	}

	private static <V,E> void DFS(Graph<V,E> graph, Vertex<V> v) {
		Iterator<Edge<E>> incidentEdgeIterator = graph.incidentEdges(v).iterator();
		
		v.setLabel("VISITED");
		
		while(incidentEdgeIterator.hasNext()) {
			Edge<E> incidentEdge = incidentEdgeIterator.next();
			if(incidentEdge.getLabel().equals("UNEPLORED")) {
				Vertex<V> opposite = graph.opposite(v,incidentEdge);

				if(opposite.getLabel().equals("UNEXPLORED")) {
					incidentEdge.setLabel("DISCOVERY");
					DFS(graph,opposite);
				} else
					incidentEdge.setLabel("BACK");
			}
			
		}
	}
	
	public static LinkedList<Position> pathDFS(Graph graph,Vertex v,Vertex z) {
		Iterator<Vertex> i = graph.vertices().iterator();
		while(i.hasNext())
			i.next().setLabel("UNEXPLORED");
		Iterator<Edge> j = graph.edges().iterator();
		while(j.hasNext())
			j.next().setLabel("UNEXPLORED");
		LinkedList<Position> list = new LinkedList<Position>();
		pathDFS(graph,v,z,list);
		return list;
	}

	private static boolean pathDFS(Graph graph, Vertex v, Vertex z, LinkedList<Position> S) {
		Iterator<Edge> i = graph.incidentEdges(v).iterator();
		v.setLabel("VISITED");
		if(v==z) {
			S.add(v);
			return true;
		}
		while(i.hasNext()) {
			Edge e = i.next();
			if(e.getLabel().equals("UNEXPLORED")) {
				Vertex w = graph.opposite(v,e);
				if(w.getLabel().equals("UNEXPLORED")) {
					e.setLabel("DISCOVERY");
					S.addLast(v);
					S.addLast(e);
					if(!pathDFS(graph,w,z,S)) {
						S.removeLast();
						S.removeLast();
					} else 
						return true;	
				} else
					e.setLabel("BACK");
			}
		}
		return false;
	}

	public static boolean isStrongConnected(DirectedGraph graph) {
		
		//DFS SUL PRIMO NODO V
		Iterator<Vertex> i = graph.vertices().iterator();
		Iterator<Edge> j = graph.edges().iterator();
		
		while(i.hasNext())
			i.next().setLabel("UNEXPLORED");
	
		while(j.hasNext())
			j.next().setLabel("UNEXPLORED");
		
		i = graph.vertices().iterator();

		if(i.hasNext()) {
			Vertex v = i.next();
			DFS(graph,v);
		}
		
		i = graph.vertices().iterator();

		while(i.hasNext())
			if(i.next().getLabel().equals("UNEXPLORED"))
				return false;


		DirectedGraphFrame.show(graph,"DFS su graph diretto");
		javax.swing.JOptionPane.showInputDialog("Premi invio");
		
		//TRASPOSIZIONE
		trasposeGraph(graph);

		//DFS SUL PRIMO NODO V CON GRAPH TRASPOSTO
		i = graph.vertices().iterator();
		j = graph.edges().iterator();
		
		while(i.hasNext()) {
			Vertex v = i.next();
			v.setLabel("UNEXPLORED");
			v.setFirstMark(0);
			v.setSecondMark(0);
		}
		
		visitNumber=1;
		leaveNumber=1;
	
		while(j.hasNext())
			j.next().setLabel("UNEXPLORED");
			
		i = graph.vertices().iterator();

		if(i.hasNext())
			DFS(graph,i.next());
		
		DirectedGraphFrame.show(graph,"DFS su graph diretto");

		i = graph.vertices().iterator();
		
		while(i.hasNext())
			if(i.next().getLabel().equals("UNEXPLORED"))
				return false;
		
		DirectedGraphFrame.show(graph,"DFS su graph invertito da v");

		return true;
	}

	private static void DFS(DirectedGraph graph, Vertex v) {
		v.setLabel("VISITED");
		v.setFirstMark(visitNumber++);
		
		Iterator<Edge> i = graph.incidentEdges(v).iterator();
		
		while(i.hasNext()) {
			Edge edge = i.next();
			if(edge.getLabel().equals("UNEXPLORED")) {
				Vertex w = graph.opposite(v,edge);
				if(w.getLabel().equals("UNEXPLORED")) {
					edge.setLabel("DISCOVERY");
					DFS(graph,w);
				} else {
					if(w.getSecondMark()==0)//nodo non ancora abbandonato 
						edge.setLabel("BACK");
					else if(w.getFirstMark()>v.getFirstMark())
						edge.setLabel("FORWARD");
					else
						edge.setLabel("CROSS");
				}
			}
		}
		v.setSecondMark(leaveNumber++);
	}

	public static void DFS(DirectedGraph graph) {
		Iterator<Vertex> i = graph.vertices().iterator();
		Iterator<Edge> j = graph.edges().iterator();
		
		while(i.hasNext())
			i.next().setLabel("UNEXPLORED");
	
		while(j.hasNext())
			j.next().setLabel("UNEXPLORED");
		
		i = graph.vertices().iterator();
		
		while(i.hasNext()) {
			Vertex v = i.next();
			if(v.getLabel().equals("UNEXPLORED")) {
				DFS(graph,v);
			}
		}
	}

	public static void trasposeGraph(DirectedGraph graph) {
		Iterator<Edge> i = graph.edges().iterator();
		
		while(i.hasNext()) {
			Vertex[] endVertices = i.next().getEndVertices();
			Vertex temp = endVertices[0];
			endVertices[0]=endVertices[1];
			endVertices[1]=temp;
		}
	}

	public static void chiusuraTransitivaFloydWarshall(DirectedGraph graph) {
		Iterator<Vertex> i = graph.vertices().iterator();
		Iterator<Vertex> j = graph.vertices().iterator();
		Iterator<Vertex> k = graph.vertices().iterator();
		
		while(i.hasNext()) {
			j = graph.vertices().iterator();
			Vertex u = i.next();
			while(j.hasNext()) {
				Vertex v = j.next();
				if(v==u) continue;
				k = graph.vertices().iterator();
				
				while(k.hasNext()) {
					
					Vertex w = k.next();
					if(w==u||w==v) continue;
					if(graph.areDirectedAdjacent(u,w) &&
							graph.areDirectedAdjacent(w,v))
						graph.insertEdge(u,v,null);
				}
			}
		}
	}

	public static LinkedList<Vertex> topologicalSort(DirectedGraph graph) {
		leaveNumber = ((List<Vertex>)(graph.vertices())).size();
		visitNumber = 1;
		Iterator<Vertex> i = graph.vertices().iterator();
		Iterator<Edge> j = graph.edges().iterator();
		
		while(i.hasNext()) {
			Vertex v = i.next();
			v.setLabel("UNEXPLORED");
			v.setFirstMark(0);
			v.setSecondMark(0);
		}
			
		while(j.hasNext())
			j.next().setLabel("UNEXPLORED");
		
		i = graph.vertices().iterator();
		
		LinkedList<Vertex> S = new LinkedList<Vertex>();
		
		while(i.hasNext()) {
			Vertex v = i.next();
			if(v.getLabel().equals("UNEXPLORED"))
					topologicalDFS(graph,v,S);
		}
		
		return S;
			
	}
	
	private static void topologicalDFS(DirectedGraph graph,Vertex v,LinkedList<Vertex> S) {
		v.setLabel("VISITED");
		v.setFirstMark(visitNumber++);
		
		Iterator<Edge> i = graph.incidentEdges(v).iterator();
		
		while(i.hasNext()) {
			Edge e = i.next();
			if(e.getLabel().equals("UNEXPLORED")) {
				Vertex w = graph.opposite(v,e);
				if(w.getLabel().equals("UNEXPLORED")) {
					e.setLabel("DISCOVERY");
					topologicalDFS(graph,w,S);
				} else {
					if(w.getSecondMark()==0)
						throw new RuntimeException("Il grafo in input non è un DAG.\nImpossibile stabilire un ordinamento topologico.");
					else {
						if(w.getFirstMark()<v.getFirstMark())
							e.setLabel("CROSS");
						else
							e.setLabel("FORWARD");
					}
				}
				
			}
		}
		v.setSecondMark(leaveNumber--);
		S.addFirst(v);
		
		
	}

	public static void dijkstraDistances(Graph graph,Vertex source) {
		Iterator<Vertex> i = graph.vertices().iterator();
		
		HeapPQ pq = new HeapPQ();
		
		while(i.hasNext()) {
			Vertex v = i.next();
			if(v==source)
				v.setDistance(0);
			else
				v.setDistance(Integer.MAX_VALUE);
			pq.insert(v);
		}
		
		while(!pq.isEmpty()) {
			Vertex v = pq.removeMin();
			Iterator<Edge> j = graph.incidentEdges(v).iterator();
			while(j.hasNext()) {
				Edge e = j.next();
				Vertex z = graph.opposite(v,e);
				if(z.distance()>v.distance()+e.weight())
					z.setDistance(v.distance()+e.weight());
				pq.reload(z.getIndex());

			}
		}
		
		
	}
}






