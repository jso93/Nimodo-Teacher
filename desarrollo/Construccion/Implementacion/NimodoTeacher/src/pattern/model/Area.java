package pattern.model;

public class Area {
    private int idArea;
    private String area;
    private String descripcion;

    public Area() {
    }

    public Area(int idArea, String area, String descripcion) {
        this.idArea = idArea;
        this.area = area;
        this.descripcion = descripcion;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
