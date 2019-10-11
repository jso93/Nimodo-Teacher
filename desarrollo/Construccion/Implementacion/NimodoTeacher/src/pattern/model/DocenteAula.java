package pattern.model;

public class DocenteAula {
    private int idDocenteAula;
    private String fecha;
    private int idPerfil;
    private int idAula;

    public DocenteAula() {
    }

    public DocenteAula(int idDocenteAula, String fecha, int idPerfil, int idAula) {
        this.idDocenteAula = idDocenteAula;
        this.fecha = fecha;
        this.idPerfil = idPerfil;
        this.idAula = idAula;
    }

    public int getIdDocenteAula() {
        return idDocenteAula;
    }

    public void setIdDocenteAula(int idDocenteAula) {
        this.idDocenteAula = idDocenteAula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }
}
