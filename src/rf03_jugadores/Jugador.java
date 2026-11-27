/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rf03_jugadores;

/**
 *
 * @author josef
 */
public abstract class Jugador 
{
    private int DNI, reservasFinalizadas;
    private String nombres, apellidos, telefono, correoElectronico;
    
    public Jugador(int DNI, String nombres, String apellidos, String telefono, String correoElectronico) 
    {
        this.DNI = DNI;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.reservasFinalizadas = 0;
    }
    
    //Metodos abstractos
    
    public abstract String getTipo();

    public abstract boolean esFrecuente();
    
    public abstract double calcularDescuento(double montoAlquiler);
    
    public void incrementarReservasFinalizadas()
    {
        this.reservasFinalizadas++;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getReservasFinalizadas() {
        return reservasFinalizadas;
    }

    public void setReservasFinalizadas(int reservasFinalizadas) {
        this.reservasFinalizadas = reservasFinalizadas;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
    @Override
    public String toString() 
    {
        return DNI + " - " + this.nombres + " " + this.apellidos + " (" + getTipo() + ", " + reservasFinalizadas + " reservas finalizadas)";
    }
    
}
