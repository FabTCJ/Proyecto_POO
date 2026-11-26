/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rf01_personal;

/**
 *
 * @author josef
 */
public class Administrador extends Empleado 
{

    public Administrador(String DNI, String nombres, String apellidos, String usuario, String contraseña) {
        super(DNI, nombres, apellidos, usuario, contraseña);
    }
    
    @Override
    public String getRol() 
    {
        return "Administrador";
    }

    //Permisos de Admin
    
    @Override
    public boolean puedeVerReportes() {
        return true; 
    }

    @Override
    public boolean puedeGestionarServicios() {
        return true; 
    }

    @Override
    public boolean puedeGestionarCanchas() {
        return true; 
    }

    @Override
    public boolean puedeGestionarEmpleados() {
        return true; 
    }  
    
}
