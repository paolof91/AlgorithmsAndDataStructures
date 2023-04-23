import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

public class GraphFrame extends JFrame {
	static LinkedList<VertexPosition> vertices;
	static Iterator<Vertex> i;
	static Random random;
	static int x;
	static int y;
	static Iterator<Edge> j;
	static LinkedList<EdgePosition> edges;
	static Graph graph;
	static GraphFrame f;
	
	int nodeRadius=10;
	
    public static GraphFrame show(Graph gr,String description) {
		graph = gr;
		vertices = new LinkedList<VertexPosition>();
        i = graph.vertices().iterator();
                
        random = new Random();
        
        
        
        while(i.hasNext()) {
			x = random.nextInt(29)*28+120;
			y = random.nextInt(19)*30+10;
			vertices.add(new VertexPosition(i.next(),x,y));
		}
		
        j = graph.edges().iterator();
		edges = new LinkedList<EdgePosition>();
        
        while(j.hasNext()) {
			EdgePosition e = new EdgePosition();
			e.v = j.next();
			Vertex[] endVertices = e.v.getEndVertices();
			Iterator<VertexPosition> ii = vertices.iterator();
						
			while(ii.hasNext()) {
				VertexPosition v = ii.next();
				if(endVertices[0]==v.v) {
					e.x1=v.x;
					e.y1=v.y;
				}
				if(endVertices[1]==v.v) {
					e.x2=v.x;
					e.y2=v.y;
				}
			}
			edges.add(e);
			
		}

        f = new GraphFrame(graph, vertices,edges);
        f.setSize(1000, 800);
        f.setVisible(true);
        f.setTitle(description);
        return f;
    }

    public GraphFrame(final Graph graph, final LinkedList<VertexPosition> vertices, final LinkedList<EdgePosition> edges) {
        JPanel panelView = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                Iterator<VertexPosition> v = vertices.iterator();
                
                while(v.hasNext()) {
					VertexPosition vp = v.next();
					g2.setColor(Color.BLACK);
					g2.fill(new Ellipse2D.Double(vp.x,vp.y,2*nodeRadius,2*nodeRadius));
					if(vp.v.getLabel()==null)
						g2.setColor(Color.DARK_GRAY);
					else if(vp.v.getLabel().equals("UNEXPLORED"))
						g2.setColor(Color.CYAN);
					else if(vp.v.getLabel().equals("DIJKSTRA PATH"))
						g2.setColor(Color.RED);
					else
						g2.setColor(Color.RED);
                    g2.draw(new Ellipse2D.Double(vp.x,vp.y,2*nodeRadius,2*nodeRadius));
					g2.setFont(g2.getFont().deriveFont(Font.BOLD));
					g2.drawString(vp.v.toString(),vp.x-v.toString().length(), vp.y+35);

					
				}
				
                Iterator<EdgePosition> e = edges.iterator();
                
                while(e.hasNext()) {
					EdgePosition ep = e.next();
					if(ep.v.getLabel()==null||ep.v.getLabel().equals("UNEXPLORED"))
						g2.setColor(Color.BLACK);
					else if(ep.v.getLabel().equals("DISCOVERY")||
								ep.v.getLabel().equals("DIJKSTRA"))
						g2.setColor(Color.BLUE);
					else if(ep.v.getLabel().equals("DIJKSTRA PATH"))
						g2.setColor(Color.RED);
					else if(ep.v.getLabel().equals("CROSS"))
						g2.setColor(Color.GREEN);
					else if(ep.v.getLabel().equals("BACK"))
						g2.setColor(Color.PINK);
					else if(ep.v.getLabel().equals("FORWARD"))
						g2.setColor(Color.DARK_GRAY);
		
                    g2.draw(new Line2D.Double(ep.x1+nodeRadius,ep.y1+nodeRadius,ep.x2+nodeRadius,ep.y2+nodeRadius));
					g2.setFont(g2.getFont().deriveFont(Font.BOLD));
					int xpos = (ep.x1+ep.x2)/2;
					int ypos = (ep.y1+ep.y2)/2;
					g2.drawString(ep.v.toString(),xpos, ypos);

					
				}
				
                
            }
        };
        
        panelView.setPreferredSize(new Dimension(1000, 800));
        panelView.setDoubleBuffered(true);
        setContentPane(new JScrollPane(panelView));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void close() {
        dispose();
    }
}


class EdgePosition {
		public EdgePosition() {
			
		}
		public EdgePosition(Edge v,int x1,int y1,int x2,int y2) {
			this.v=v;
			this.x1=x1;
			this.y1=y1;
			this.x2=x2;
			this.y2=y2;
			
		}
		
		Edge v;
		int x1;
		int y1;
		int x2;
		int y2;
}
    
class VertexPosition {
		public VertexPosition(Vertex v,int x,int y) {
			this.v=v;
			this.x=x;
			this.y=y;
		}
		
		Vertex v;
		int x;
		int y;
}
