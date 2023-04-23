import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

public class DirectedGraphFrame extends JFrame {
	static LinkedList<VertexPosition> vertices;
	static Iterator<Vertex> i;
	static Random random;
	static int x;
	static int y;
	static Iterator<Edge> j;
	static LinkedList<EdgePosition> edges;
	static DirectedGraph graph;
	static DirectedGraphFrame f;
	
	double nodeRadius=10;
	
    public static DirectedGraphFrame show(DirectedGraph gr,String description) {
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

        f = new DirectedGraphFrame(graph, vertices,edges);
        f.setSize(1000, 800);
        f.setVisible(true);
        f.setTitle(description);
        return f;
    }

    public DirectedGraphFrame(final DirectedGraph graph, final LinkedList<VertexPosition> vertices, final LinkedList<EdgePosition> edges) {
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
					g2.fill(new Ellipse2D.Double(vp.x-nodeRadius,vp.y-nodeRadius,2*nodeRadius,2*nodeRadius));
					if(vp.v.getLabel()==null)
						g2.setColor(Color.BLACK);
					else if(vp.v.getLabel().equals("UNEXPLORED"))
						g2.setColor(Color.BLUE);
					else
						g2.setColor(Color.RED);
                    g2.draw(new Ellipse2D.Double(vp.x-nodeRadius,vp.y-nodeRadius,2*nodeRadius,2*nodeRadius));
					g2.setFont(g2.getFont().deriveFont(Font.BOLD));
					g2.drawString(vp.v.toString(),vp.x-v.toString().length()/2, vp.y+30);

					
				}
				
                Iterator<EdgePosition> e = edges.iterator();
                
                while(e.hasNext()) {
					EdgePosition ep = e.next();
					if(ep.v.getLabel()==null||ep.v.getLabel().equals("UNEXPLORED"))
						g2.setColor(Color.BLACK);
					else if(ep.v.getLabel().equals("DISCOVERY"))
						g2.setColor(Color.BLUE);
					else if(ep.v.getLabel().equals("CROSS"))
						g2.setColor(Color.GREEN);
					else if(ep.v.getLabel().equals("BACK"))
						g2.setColor(Color.PINK);
					else if(ep.v.getLabel().equals("FORWARD"))
						g2.setColor(Color.DARK_GRAY);
                    g2.draw(new Line2D.Double(ep.x1,ep.y1,ep.x2,ep.y2));
					double tg = ((double)(ep.y2-ep.y1))/(ep.x2-ep.x1);
					double cos = Math.sqrt(1/(1+tg*tg));
					double sin = Math.sqrt(tg*tg/(1+tg*tg));
					double xPallino,yPallino;
					double radiusPallino = nodeRadius/2.2;
					double nodeRadius1=nodeRadius+2;
					if(ep.x2>ep.x1)
						xPallino=ep.x2-nodeRadius1*cos;
					else
						xPallino=ep.x2+nodeRadius1*cos;
					if(ep.y2>ep.y1)
						yPallino=ep.y2-nodeRadius1*sin;
					else
						yPallino=ep.y2+nodeRadius1*sin;
					g2.fill(new Ellipse2D.Double(xPallino-radiusPallino,yPallino-radiusPallino,radiusPallino*2,radiusPallino*2));
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
