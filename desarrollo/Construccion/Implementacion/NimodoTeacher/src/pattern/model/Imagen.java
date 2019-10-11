package pattern.model;

public class Imagen {
    private int idImagen;
    private String imagen;
    private int idPregunta;

    public Imagen(int idImagen, String imagen, int idPregunta) {
        this.idImagen = idImagen;
        this.imagen = imagen;
        this.idPregunta = idPregunta;
    }

    public Imagen() {
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }
}
