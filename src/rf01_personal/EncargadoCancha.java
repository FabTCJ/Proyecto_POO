/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rf01_personal;

/**
 *
 * @author josef
 */
public class EncargadoCancha extends Empleado
{

    public EncargadoCancha(String DNI, String nombres, String apellidos, String usuario, String contraseña) {
        super(DNI, nombres, apellidos, usuario, contraseña);
    }

    @Override
    public String getRol() {
        return "Encargado de Cancha";
    }

    @Override
    public boolean puedeVerAgenda() {
        return true;
    }

    @Override
    public boolean puedeOperarPartidos() {
        return true; 
    }
    
    
    
    
    
}
