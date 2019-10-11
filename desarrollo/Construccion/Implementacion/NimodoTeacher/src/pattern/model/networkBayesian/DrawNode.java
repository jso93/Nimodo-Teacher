package pattern.model.networkBayesian;

import java.awt.*;
import java.awt.event.MouseEvent;

public class DrawNode {
    private final Graphics2D g;
    private static int radius = 20;

    public DrawNode(Graphics2D graphics2D){
        g = graphics2D;
    }

    public static boolean isWithinBounds(MouseEvent e, Point p) {
        int x = e.getX();
        int y = e.getY();

        int boundX = (int) p.getX();
        int boundY = (int) p.getY();

        return (x <= boundX + radius && x >= boundX - radius) && (y <= boundY + radius && y >= boundY - radius);
    }

    public static boolean isOverlapping(MouseEvent e, Point p) {
        int x = e.getX();
        int y = e.getY();

        int boundX = (int) p.getX();
        int boundY = (int) p.getY();

        return (x <= boundX + 2.5*radius && x >= boundX - 2.5*radius) && (y <= boundY + 2.5*radius && y >= boundY - 2.5*radius);
    }

    public void drawNode(Node node , Color color){
        g.setColor(Color.BLACK);
        g.fillOval(node.getX() - radius, node.getY() - radius, 2 * radius, 2 * radius);
        radius-=3;
        g.setColor(color);
        g.fillOval(node.getX() - radius, node.getY() - radius, 2 * radius, 2 * radius);
        radius+=3;
        g.setColor(Color.BLACK);
        g.drawString(""+node.getConocimientoAPosteriori(), node.getX()-radius, node.getY() + radius+10);
    }
}
