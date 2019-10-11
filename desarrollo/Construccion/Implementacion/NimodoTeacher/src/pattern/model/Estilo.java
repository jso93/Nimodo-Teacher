package pattern.model;

public class Estilo {
    private int idEstilo;
    private String estilo;
    private String descripcion;

    public Estilo() {
    }

    public Estilo(int idEstilo, String estilo, String descripcion) {
        this.idEstilo = idEstilo;
        this.estilo = estilo;
        this.descripcion = descripcion;
    }

    public int getIdEstilo() {
        return idEstilo;
    }

    public void setIdEstilo(int idEstilo) {
        this.idEstilo = idEstilo;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
