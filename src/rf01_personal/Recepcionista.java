/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rf01_personal;

/**
 *
 * @author josef
 */
public class Recepcionista extends Empleado
{

    public Recepcionista(String DNI, String nombres, String apellidos, String usuario, String contraseña) {
        super(DNI, nombres, apellidos, usuario, contraseña);
    }

    @Override
    public String getRol() {
        return "Recepcionista";
    }
    
    //Permisos de Recepcionista

    @Override
    public boolean puedeFacturar() {
        return true;
    }

    @Override
    public boolean puedeGestionarReservas() {
        return true; 
    }

    @Override
    public boolean puedeGestionarJugadores() {
        return true;
    }

    @Override
    public boolean puedeVerAgenda() {
        return true;
    }
    
}
