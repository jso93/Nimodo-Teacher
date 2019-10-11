package pattern.model;

public class Grado {
    private int idGrado;
    private String grado;
    private String descripcion;

    public Grado() {
    }

    public Grado(int idGrado, String grado, String descripcion) {
        this.idGrado = idGrado;
        this.grado = grado;
        this.descripcion = descripcion;
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
