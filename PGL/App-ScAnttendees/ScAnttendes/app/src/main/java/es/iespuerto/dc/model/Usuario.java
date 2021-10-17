package es.iespuerto.dc.model;

public class Usuario implements IUsuario {
    private int idUsuario, idInstitucion, telefono;
    private  String nombre, nombreUsuario, apellido, email, clave, DNI;

    /**
     * Constructor de un usuario
     * @param idInstitucion
     * @param telefono
     * @param nombre
     * @param nombreUsuario
     * @param apellido
     * @param email
     * @param clave
     * @param DNI
     */
    public Usuario(int idInstitucion, int telefono, String nombre, String nombreUsuario, String apellido, String email, String clave, String DNI) {
        this.idInstitucion = idInstitucion;
        this.telefono = telefono;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.apellido = apellido;
        this.email = email;
        this.clave = clave;
        this.DNI = DNI;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(int idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
