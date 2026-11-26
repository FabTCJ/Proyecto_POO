/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rf01_personal;

/**
 *
 * @author josef
 */
public abstract class Empleado 
{
    private String DNI, nombres, apellidos, usuario, contraseña;
    
    public Empleado(String DNI, String nombres, String apellidos, String usuario, String contraseña) {
        this.DNI = DNI;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    
    //Metodos como tal
    
    public String getNombreCompleto()
    {
        return this.nombres + " " + this.apellidos;
    }
    
    public abstract String getRol();

    public String VerInfo() {
        return "\nDNI: " + DNI +
                "\nNombre Completo: " + this.getNombreCompleto() +
                "\nRol: " + this.getRol();
    }
    
    //Metodos de acceso
    
    public boolean puedeGestionarEmpleados() {
        return false;
    }

    public boolean puedeGestionarCanchas() {
        return false;
    }

    public boolean puedeGestionarServicios() {
        return false;
    }

    public boolean puedeVerReportes() {
        return false;
    }

    public boolean puedeGestionarJugadores() {
        return false;
    }

    public boolean puedeGestionarReservas() {
        return false;
    }

    public boolean puedeFacturar() {
        return false;
    }

    public boolean puedeOperarPartidos() {
        return false;
    }

    public boolean puedeVerAgenda() {
        return false;
    }
    
    //Getters y Setters

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
    
    
    
    
    
    
}
