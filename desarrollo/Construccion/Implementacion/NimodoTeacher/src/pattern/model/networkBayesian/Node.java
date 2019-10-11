package pattern.model.networkBayesian;

import java.awt.*;

public class Node {
    private final Point coord;
    private int id;
    private String name;
    private double conocimientoAPosteriori;
    private String tipo;

    public Node(Point coord, int id, String name, double conocimientoAPosteriori, String tipo) {
        this.coord = coord;
        this.id = id;
        this.name = name;
        this.conocimientoAPosteriori = conocimientoAPosteriori;
        this.tipo = tipo;
    }
    
    public void setCoord(int x, int y){
        coord.setLocation(x, y);
    }

    public Point getCoord(){
        return coord;
    }

    public int getX(){
        return (int) coord.getX();
    }

    public int getY(){
        return (int) coord.getY();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getConocimientoAPosteriori() {
        return conocimientoAPosteriori;
    }

    public void setConocimientoAPosteriori(double conocimientoAPosteriori) {
        this.conocimientoAPosteriori = conocimientoAPosteriori;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

}
