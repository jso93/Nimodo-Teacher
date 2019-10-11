package pattern.model;

public class Pregunta {
    private int idPregunta;
    private String descripcion;
    private double descuido;
    private double adivinanza;
    private int idNivel;
    private int idEstilo;
    private int idMatriz;
    private int idPeriodo;
    private int idDocenteAula;

    public Pregunta() {
    }

    public Pregunta(int idPregunta, String descripcion, double descuido, double adivinanza, int idNivel, int idEstilo, int idMatriz, int idPeriodo, int idDocenteAula) {
        this.idPregunta = idPregunta;
        this.descripcion = descripcion;
        this.descuido = descuido;
        this.adivinanza = adivinanza;
        this.idNivel = idNivel;
        this.idEstilo = idEstilo;
        this.idMatriz = idMatriz;
        this.idPeriodo = idPeriodo;
        this.idDocenteAula = idDocenteAula;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getDescuido() {
        return descuido;
    }

    public void setDescuido(double descuido) {
        this.descuido = descuido;
    }

    public double getAdivinanza() {
        return adivinanza;
    }

    public void setAdivinanza(double adivinanza) {
        this.adivinanza = adivinanza;
    }

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    public int getIdEstilo() {
        return idEstilo;
    }

    public void setIdEstilo(int idEstilo) {
        this.idEstilo = idEstilo;
    }

    public int getIdMatriz() {
        return idMatriz;
    }

    public void setIdMatriz(int idMatriz) {
        this.idMatriz = idMatriz;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public int getIdDocenteAula() {
        return idDocenteAula;
    }

    public void setIdDocenteAula(int idDocenteAula) {
        this.idDocenteAula = idDocenteAula;
    }
}
