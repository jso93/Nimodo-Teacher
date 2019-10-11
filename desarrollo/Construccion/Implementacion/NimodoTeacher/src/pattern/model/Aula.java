package pattern.model;

public class Aula {
    private int idAula;
    private int idGrado;
    private int idSeccion;

    public Aula() {
    }

    public Aula(int idAula, int idGrado, int idSeccion) {
        this.idAula = idAula;
        this.idGrado = idGrado;
        this.idSeccion = idSeccion;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }
}
