package pattern.model;

public class Alternativa {
    private int idAlternativa;
    private String descripcion;
    private boolean success;
    private int idPregunta;

    public Alternativa() {
    }

    public Alternativa(int idAlternativa, String descripcion, boolean success, int idPregunta) {
        this.idAlternativa = idAlternativa;
        this.descripcion = descripcion;
        this.success = success;
        this.idPregunta = idPregunta;
    }

    public int getIdAlternativa() {
        return idAlternativa;
    }

    public void setIdAlternativa(int idAlternativa) {
        this.idAlternativa = idAlternativa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }
}
