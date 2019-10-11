package pattern.model;

public class Competencia {
    private int idCompetencia;
    private String competencia;
    private String descripcion;

    public Competencia() {
    }

    public Competencia(int idCompetencia, String competencia, String descripcion) {
        this.idCompetencia = idCompetencia;
        this.competencia = competencia;
        this.descripcion = descripcion;
    }

    public int getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(int idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
