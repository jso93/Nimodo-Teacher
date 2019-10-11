package pattern.model;

public class Desempeño {
    private int idDesempeño;
    private String desempeño;
    private String descripcion;
    private int idDocenteAula;

    public Desempeño() {
    }

    public Desempeño(int idDesempeño, String desempeño, String descripcion, int idDocenteAula) {
        this.idDesempeño = idDesempeño;
        this.desempeño = desempeño;
        this.descripcion = descripcion;
        this.idDocenteAula = idDocenteAula;
    }

    public int getIdDesempeño() {
        return idDesempeño;
    }

    public void setIdDesempeño(int idDesempeño) {
        this.idDesempeño = idDesempeño;
    }

    public String getDesempeño() {
        return desempeño;
    }

    public void setDesempeño(String desempeño) {
        this.desempeño = desempeño;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdDocenteAula() {
        return idDocenteAula;
    }

    public void setIdDocenteAula(int idDocenteAula) {
        this.idDocenteAula = idDocenteAula;
    }
}
