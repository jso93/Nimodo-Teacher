package pattern.model;

public class Seccion {
    private int idSeccion;
    private String seccion;
    private String descripcion;

    public Seccion() {
    }

    public Seccion(int idSeccion, String seccion, String descripcion) {
        this.idSeccion = idSeccion;
        this.seccion = seccion;
        this.descripcion = descripcion;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
