package pattern.model;

public class EvaluacionAdaptativa {
    private int idEvaluacionAdaptativa;
    private String fecha;
    private int idCompetencia;
    private int idPerioro;
    private int idArea;
    private int idEstudianteMatricula;
    private int idDocenteAula;

    public EvaluacionAdaptativa() {
    }

    public EvaluacionAdaptativa(int idEvaluacionAdaptativa, String fecha, int idCompetencia, int idPerioro, int idArea, int idEstudianteMatricula, int idDocenteAula) {
        this.idEvaluacionAdaptativa = idEvaluacionAdaptativa;
        this.fecha = fecha;
        this.idCompetencia = idCompetencia;
        this.idPerioro = idPerioro;
        this.idArea = idArea;
        this.idEstudianteMatricula = idEstudianteMatricula;
        this.idDocenteAula = idDocenteAula;
    }

    public int getIdEvaluacionAdaptativa() {
        return idEvaluacionAdaptativa;
    }

    public void setIdEvaluacionAdaptativa(int idEvaluacionAdaptativa) {
        this.idEvaluacionAdaptativa = idEvaluacionAdaptativa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(int idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public int getIdPerioro() {
        return idPerioro;
    }

    public void setIdPerioro(int idPerioro) {
        this.idPerioro = idPerioro;
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
