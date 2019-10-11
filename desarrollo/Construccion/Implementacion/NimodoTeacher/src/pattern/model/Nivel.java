package pattern.model;

public class Nivel {
    private int idNivel;
    private String nivel;
    private String descripcion;

    public Nivel() {
    }

    public Nivel(int idNivel, String nivel, String descripcion) {
        this.idNivel = idNivel;
        this.nivel = nivel;
        this.descripcion = descripcion;
    }

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
