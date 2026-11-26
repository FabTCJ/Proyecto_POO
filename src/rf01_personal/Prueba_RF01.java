/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rf01_personal;

/**
 *
 * @author josef
 */
public class Prueba_RF01 
{
    public static void main(String[] args) 
    {
        GestorEmpleados gestor = new GestorEmpleados(5);

        // ---------- 1. Registrar empleados validos ----------
        System.out.println("=== 1. Registrar ===");
        gestor.Registrar(new Administrador("11111111", "Ana", "Lopez", "admin", "1234"));
        gestor.Registrar(new Recepcionista("22222222", "Luis", "Perez", "lperez", "abcd"));
        gestor.Registrar(new EncargadoCancha("33333333", "Marta", "Rios", "mrios", "xyz1"));
        comprobar("Hay 3 empleados registrados", gestor.getEmpleados().length == 3);
        mostrar(gestor);

        // ---------- 2. DNI duplicado ----------
        System.out.println("\n=== 2. DNI duplicado ===");
        gestor.Registrar(new Recepcionista("22222222", "Otro", "Nombre", "otro", "000"));
        comprobar("Sigue habiendo 3 empleados (no se registro el duplicado)", gestor.getEmpleados().length == 3);

        // ---------- 3. Usuario duplicado ----------
        System.out.println("\n=== 3. Usuario duplicado ===");
        gestor.Registrar(new Recepcionista("44444444", "Otro", "Nombre", "lperez", "000"));
        comprobar("Sigue habiendo 3 empleados (no se registro el duplicado)", gestor.getEmpleados().length == 3);

        // ---------- 4. Busquedas ----------
        System.out.println("\n=== 4. Busquedas ===");
        comprobar("buscarPorDni encuentra 22222222", gestor.buscarPorDni("22222222") != null);
        comprobar("buscarPorDni no encuentra 99999999", gestor.buscarPorDni("99999999") == null);
        comprobar("buscarPorUsuario encuentra mrios", gestor.buscarPorUsuario("mrios") != null);
        comprobar("buscarPorUsuario no encuentra fantasma", gestor.buscarPorUsuario("fantasma") == null);

        // ---------- 5. Modificar ----------
        System.out.println("\n=== 5. Modificar ===");
        boolean ok = gestor.modificar("22222222", new Recepcionista("22222222", "Luis Alberto", "Perez", "lperez", "abcd"));
        comprobar("Modificar un empleado existente devuelve true", ok);
        comprobar("El cambio se refleja en el arreglo", gestor.buscarPorDni("22222222").getNombres().equals("Luis Alberto"));

        ok = gestor.modificar("22222222", new Recepcionista("11111111", "Luis", "Perez", "lperez", "abcd"));
        comprobar("Modificar con un DNI que ya tiene otro empleado devuelve false", ok == false);

        ok = gestor.modificar("22222222", new Recepcionista("22222222", "Luis", "Perez", "admin", "abcd"));
        comprobar("Modificar con un usuario que ya tiene otro empleado devuelve false", ok == false);

        ok = gestor.modificar("99999999", new Recepcionista("99999999", "X", "Y", "xy", "1"));
        comprobar("Modificar un DNI que no existe devuelve false", ok == false);

        // Cambio de rol: Recepcionista -> Encargado de Cancha
        ok = gestor.modificar("22222222", new EncargadoCancha("22222222", "Luis", "Perez", "lperez", "abcd"));
        comprobar("Cambiar el rol (otra subclase) devuelve true", ok);

        // ---------- 6. Eliminar ----------
        System.out.println("\n=== 6. Eliminar ===");
        ok = gestor.Eliminar("33333333");
        comprobar("Eliminar un empleado existente devuelve true", ok);
        comprobar("Quedan 2 empleados", gestor.getEmpleados().length == 2);
        comprobar("El empleado eliminado ya no se encuentra", gestor.buscarPorDni("33333333") == null);

        ok = gestor.Eliminar("99999999");
        comprobar("Eliminar un DNI que no existe devuelve false", ok == false);
        mostrar(gestor);

        // ---------- 7. Arreglo lleno ----------
        System.out.println("\n=== 7. Arreglo lleno (capacidad 5) ===");
        gestor.Registrar(new Recepcionista("55555555", "Rosa", "Diaz", "rdiaz", "r1"));
        gestor.Registrar(new Recepcionista("66666666", "Jose", "Vega", "jvega", "j1"));
        gestor.Registrar(new Recepcionista("77777777", "Pilar", "Soto", "psoto", "p1"));
        comprobar("Hay 5 empleados (arreglo lleno)", gestor.getEmpleados().length == 5);

        gestor.Registrar(new Recepcionista("88888888", "Sobra", "Uno", "sobra", "s1"));
        comprobar("Un sexto empleado no se registra", gestor.getEmpleados().length == 5);
        mostrar(gestor);
    }

    // Imprime OK o FALLO segun la condicion
    private static void comprobar(String prueba, boolean condicion) 
    {
        if (condicion) 
        {
            System.out.println("   OK     - " + prueba);
        } 
        else 
        {
            System.out.println("   FALLO  - " + prueba);
        }
    }

    // Muestra los empleados registrados
    private static void mostrar(GestorEmpleados gestor) 
    {
        Empleado[] lista = gestor.getEmpleados();
        for (int i = 0; i < lista.length; i++) 
        {
            System.out.println("   - " + lista[i].getDNI() + " | " + lista[i].getUsuario());
        }
    }
}
    
