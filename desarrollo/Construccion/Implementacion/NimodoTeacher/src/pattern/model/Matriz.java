package pattern.model;

public class Matriz {
    private int idMatriz;
    private int idArea;
    private int idCompetencia;
    private int idCapacidad;
    private int idDesempeño;
    private int idDocenteAula;

    public Matriz() {
    }

    public Matriz(int idMatriz, int idArea, int idCompetencia, int idCapacidad, int idDesempeño, int idDocenteAula) {
        this.idMatriz = idMatriz;
        this.idArea = idArea;
        this.idCompetencia = idCompetencia;
        this.idCapacidad = idCapacidad;
        this.idDesempeño = idDesempeño;
        this.idDocenteAula = idDocenteAula;
    }

    public int getIdMatriz() {
        return idMatriz;
    }

    public void setIdMatriz(int idMatriz) {
        this.idMatriz = idMatriz;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public int getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(int idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public int getIdCapacidad() {
        return idCapacidad;
    }

    public void setIdCapacidad(int idCapacidad) {
        this.idCapacidad = idCapacidad;
    }

    public int getIdDesempeño() {
        return idDesempeño;
    }

    public void setIdDesempeño(int idDesempeño) {
        this.idDesempeño = idDesempeño;
    }

    public int getIdDocenteAula() {
        return idDocenteAula;
    }

    public void setIdDocenteAula(int idDocenteAula) {
        this.idDocenteAula = idDocenteAula;
    }
}
