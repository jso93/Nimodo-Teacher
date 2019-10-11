package pattern.model;

public class Calificacion {
    private int idCalificacion;
    private int calificacion;
    private int idEvaluacionTradicional;

    public Calificacion() {
    }

    public Calificacion(int idCalificacion, int calificacion, int idEvaluacionTradicional) {
        this.idCalificacion = idCalificacion;
        this.calificacion = calificacion;
        this.idEvaluacionTradicional = idEvaluacionTradicional;
    }

    public int getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getIdEvaluacionTradicional() {
        return idEvaluacionTradicional;
    }

    public void setIdEvaluacionTradicional(int idEvaluacionTradicional) {
        this.idEvaluacionTradicional = idEvaluacionTradicional;
    }
}
