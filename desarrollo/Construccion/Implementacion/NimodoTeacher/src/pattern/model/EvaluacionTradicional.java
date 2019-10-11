package pattern.model;

public class EvaluacionTradicional {
    private int idEvaluacionTradicional;
    private String fecha;
    private int idPeriodo;
    private int idArea;
    private int idEstudianteMatricula;
    private int idDocenteAula;

    public EvaluacionTradicional() {
    }

    public EvaluacionTradicional(int idEvaluacionTradicional, String fecha, int idPeriodo, int idArea, int idEstudianteMatricula, int idDocenteAula) {
        this.idEvaluacionTradicional = idEvaluacionTradicional;
        this.fecha = fecha;
        this.idPeriodo = idPeriodo;
        this.idArea = idArea;
        this.idEstudianteMatricula = idEstudianteMatricula;
        this.idDocenteAula = idDocenteAula;
    }

    public int getIdEvaluacionTradicional() {
        return idEvaluacionTradicional;
    }

    public void setIdEvaluacionTradicional(int idEvaluacionTradicional) {
        this.idEvaluacionTradicional = idEvaluacionTradicional;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public int getIdEstudianteMatricula() {
        return idEstudianteMatricula;
    }

    public void setIdEstudianteMatricula(int idEstudianteMatricula) {
        this.idEstudianteMatricula = idEstudianteMatricula;
    }

    public int getIdDocenteAula() {
        return idDocenteAula;
    }

    public void setIdDocenteAula(int idDocenteAula) {
        this.idDocenteAula = idDocenteAula;
    }
}
