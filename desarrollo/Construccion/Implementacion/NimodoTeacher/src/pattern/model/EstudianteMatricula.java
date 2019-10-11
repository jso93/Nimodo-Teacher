package pattern.model;

public class EstudianteMatricula {
    private int idEstudianteMatricula;
    private String fecha;
    private int idPerfil;
    private int idAula;

    public EstudianteMatricula() {
    }

    public EstudianteMatricula(int idEstudianteMatricula, String fecha, int idPerfil, int idAula) {
        this.idEstudianteMatricula = idEstudianteMatricula;
        this.fecha = fecha;
        this.idPerfil = idPerfil;
        this.idAula = idAula;
    }

    public int getIdEstudianteMatricula() {
        return idEstudianteMatricula;
    }

    public void setIdEstudianteMatricula(int idEstudianteMatricula) {
        this.idEstudianteMatricula = idEstudianteMatricula;
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
