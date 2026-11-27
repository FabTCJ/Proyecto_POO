/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rf03_jugadores;

/**
 *
 * @author josef
 */
public class Frecuente extends Jugador 
{

    public Frecuente(int DNI, String nombres, String apellidos, String telefono, String correoElectronico) {
        super(DNI, nombres, apellidos, telefono, correoElectronico);
    }
    
    public Frecuente(Jugador j) 
    {
        super(j.getDNI(), j.getNombres(), j.getApellidos(), j.getTelefono(), j.getCorreoElectronico());
        setReservasFinalizadas(j.getReservasFinalizadas());
    }

    @Override
    public String getTipo() {
        return "Frecuente";
    }

    @Override
    public boolean esFrecuente() 
    {
        return true;
    }

    @Override
    public double calcularDescuento(double montoAlquiler) 
    {
        return montoAlquiler * 0.10;
    }
    
    
    
}
