package pattern.model;

public class Capacidad {
    private int idCapacidad;
    private String capacidad;
    private String descripcion;

    public Capacidad() {
    }

    public Capacidad(int idCapacidad, String capacidad, String descripcion) {
        this.idCapacidad = idCapacidad;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
    }

    public int getIdCapacidad() {
        return idCapacidad;
    }

    public void setIdCapacidad(int idCapacidad) {
        this.idCapacidad = idCapacidad;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
