/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rf01_personal;

/**
 *
 * @author josef
 */
public class GestorEmpleados 
{
    private Empleado[] empleados;
    private int conta;
    
    public GestorEmpleados(int conta)
    {
        this.empleados = new Empleado[conta];
        this.conta = 0;
    }
    
    //Metodo Registrar
    
    public void Registrar(Empleado ref) 
    {
    if (conta == empleados.length) 
    {
        System.out.println("Arreglo lleno");
        return;
    }
    if (buscarPorDni(ref.getDNI()) != null) 
    {
        System.out.println("DNI ya existente");
        return;
    }
    if (buscarPorUsuario(ref.getUsuario()) != null) 
    {
        System.out.println("Usuario ya existente");
        return;
    }
    empleados[conta] = ref;
    conta++;
    System.out.println("Empleado registrado con exito");
    }
    
    //Metodo Eliminar
    
    public boolean Eliminar(String DNI) {
        int pos = this.posicionPorDni(DNI);
        if (pos == -1) return false;

        for (int i = pos; i < conta - 1; i++) {
            empleados[i] = empleados[i + 1];
        }
        empleados[conta - 1] = null;
        conta--;
        return true;
    }

    //Metodos de Busqueda
    
    public Empleado buscarPorDni(String dni) 
    {
        int pos = posicionPorDni(dni);
        if (pos == -1) 
        {
            return null;
        }
        return empleados[pos];
    }

    public Empleado buscarPorUsuario(String usuario) 
    {
        for (int i = 0; i < conta; i++) 
        {
            if (empleados[i].getUsuario().equals(usuario)) 
            {
                return empleados[i];
            }
        }
        return null;
    }

    private int posicionPorDni(String dni) 
    {
        for (int i = 0; i < conta; i++) 
        {
            if (empleados[i].getDNI().equals(dni)) 
            {
                return i;
            }
        }
        return -1;
    }
    
    //Metodo Modificar
    
    public boolean modificar(String DNI, Empleado ref) 
    {
        int pos = posicionPorDni(DNI);
        if (pos == -1) {
            return false;
        }
        for (int i = 0; i < conta; i++) {
            if (i != pos) {
                if (empleados[i].getDNI().equals(ref.getDNI())
                        || empleados[i].getUsuario().equals(ref.getUsuario())) {
                    return false;
                }
            }
        }
        empleados[pos] = ref;
        return true;
    }
    
    public Empleado[] getEmpleados() {
        Empleado[] copia = new Empleado[conta];
        for (int i = 0; i < conta; i++) {
            copia[i] = empleados[i];
        }
        return copia;
    }
    
    
}
