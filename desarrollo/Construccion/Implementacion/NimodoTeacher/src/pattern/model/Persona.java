package pattern.model;

public class Persona {
    private String dni;
    private String nombres;
    private String apellidos;
    private String user;
    private String password;

    public Persona() {
    }

    public Persona(String dni, String nombres, String apellidos, String user, String password) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.user = user;
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
