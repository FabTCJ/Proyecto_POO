/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rf03_jugadores;

/**
 *
 * @author josef
 */
public class Regular extends Jugador
{

    public Regular(int DNI, String nombres, String apellidos, String telefono, String correoElectronico) {
        super(DNI, nombres, apellidos, telefono, correoElectronico);
    }

    @Override
    public String getTipo() 
    {
        return "Regular";
        
    }

    @Override
    public boolean esFrecuente() 
    {
        return false;
    }

    @Override
    public double calcularDescuento(double montoAlquiler) 
    {
        return 0;
      
    }
    
}
