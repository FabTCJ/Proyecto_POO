/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rf02_canchas;

/**
 *
 * @author josef
 */
public class Prueba_RF02 
{
    public static void main(String[] args) 
    {
        GestorCanchas gestor = new GestorCanchas(4);

        // ---------- 1. Registrar canchas ----------
        System.out.println("=== 1. Registrar ===");
        gestor.Registrar(new CanchaFutbol5(101, "Cancha Norte", 10, 50));
        gestor.Registrar(new CanchaFutbol7(201, "Cancha Central", 14, 80));
        gestor.Registrar(new CanchaFutbol11(301, "Cancha Grande", 22, 120));
        comprobar("Hay 3 canchas registradas", gestor.getCanchas().length == 3);
        mostrar(gestor);

        // ---------- 2. Codigo duplicado ----------
        System.out.println("\n=== 2. Codigo duplicado ===");
        gestor.Registrar(new CanchaFutbol5(101, "Otra cancha", 10, 55));
        comprobar("Sigue habiendo 3 canchas (no se registro el duplicado)", gestor.getCanchas().length == 3);

        // ---------- 3. Busquedas ----------
        System.out.println("\n=== 3. Busquedas ===");
        comprobar("buscarPorCodigo encuentra 201", gestor.buscarPorCodigo(201) != null);
        comprobar("buscarPorCodigo no encuentra 999", gestor.buscarPorCodigo(999) == null);

        // ---------- 4. Polimorfismo: calcularTarifa ----------
        System.out.println("\n=== 4. Tarifa por tipo y horario (polimorfismo) ===");
        Cancha c5 = gestor.buscarPorCodigo(101);
        Cancha c7 = gestor.buscarPorCodigo(201);
        Cancha c11 = gestor.buscarPorCodigo(301);
        comprobar("F5 a las 10:00 = 50.0 (sin recargo)", casiIgual(c5.CalcularTarifa(10), 50.0));
        comprobar("F7 a las 10:00 = 80.0 (sin recargo)", casiIgual(c7.CalcularTarifa(10), 80.0));
        comprobar("F11 a las 10:00 = 120.0 (sin recargo)", casiIgual(c11.CalcularTarifa(10), 120.0));
        comprobar("F5 a las 19:00 = 55.0 (recargo 10%)", casiIgual(c5.CalcularTarifa(19), 55.0));
        comprobar("F7 a las 19:00 = 92.0 (recargo 15%)", casiIgual(c7.CalcularTarifa(19), 92.0));
        comprobar("F11 a las 19:00 = 144.0 (recargo 20%)", casiIgual(c11.CalcularTarifa(19), 144.0));
        comprobar("F5 a las 18:00 ya lleva recargo", casiIgual(c5.CalcularTarifa(18), 55.0));
        comprobar("F5 a las 17:00 no lleva recargo", casiIgual(c5.CalcularTarifa(17), 50.0));

        // ---------- 5. Estado y mantenimiento ----------
        System.out.println("\n=== 5. Estado de la cancha ===");
        comprobar("Una cancha nueva queda Disponible (estado 1)", c5.getEstadoCancha() == 1);
        comprobar("El texto del estado 1 es Disponible", c5.getEstadoTexto().length() == 10);
        comprobar("Una cancha Disponible puede reservarse", c5.PuedeReservarse());
        c5.setEstadoCancha(3);
        comprobar("Una cancha En Mantenimiento (estado 3) NO puede reservarse", c5.PuedeReservarse() == false);
        c5.setEstadoCancha(2);
        comprobar("Una cancha Ocupada (estado 2) pasa este chequeo (el cruce se valida en RF05)", c5.PuedeReservarse());
        c5.setEstadoCancha(1);

        // ---------- 6. Modificar ----------
        System.out.println("\n=== 6. Modificar ===");
        boolean ok = gestor.modificar(201, new CanchaFutbol7(201, "Cancha Central Renovada", 14, 90));
        comprobar("Modificar una cancha existente devuelve true", ok);
        comprobar("El cambio se refleja en el arreglo", gestor.buscarPorCodigo(201).getTarifaBase() == 90);

        ok = gestor.modificar(201, new CanchaFutbol7(101, "Cancha Central", 14, 90));
        comprobar("Modificar con un codigo que ya tiene otra cancha devuelve false", ok == false);

        ok = gestor.modificar(999, new CanchaFutbol7(999, "X", 14, 90));
        comprobar("Modificar un codigo que no existe devuelve false", ok == false);

        // ---------- 7. Eliminar ----------
        System.out.println("\n=== 7. Eliminar ===");
        ok = gestor.Eliminar(301);
        comprobar("Eliminar una cancha existente devuelve true", ok);
        comprobar("Quedan 2 canchas", gestor.getCanchas().length == 2);
        comprobar("La cancha eliminada ya no se encuentra", gestor.buscarPorCodigo(301) == null);

        ok = gestor.Eliminar(999);
        comprobar("Eliminar un codigo que no existe devuelve false", ok == false);
        mostrar(gestor);

        // ---------- 8. Arreglo lleno ----------
        System.out.println("\n=== 8. Arreglo lleno (capacidad 4) ===");
        gestor.Registrar(new CanchaFutbol5(102, "Cancha Sur", 10, 50));
        gestor.Registrar(new CanchaFutbol11(302, "Cancha Este", 22, 120));
        comprobar("Hay 4 canchas (arreglo lleno)", gestor.getCanchas().length == 4);

        gestor.Registrar(new CanchaFutbol7(202, "Sobra", 14, 80));
        comprobar("Una quinta cancha no se registra", gestor.getCanchas().length == 4);
        mostrar(gestor);
    }

    // Los double no se comparan con == exacto; se acepta una diferencia minima
    private static boolean casiIgual(double a, double b) 
    {
        return Math.abs(a - b) < 0.001;
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

    // Muestra las canchas registradas
    private static void mostrar(GestorCanchas gestor) 
    {
        Cancha[] lista = gestor.getCanchas();
        for (int i = 0; i < lista.length; i++) 
        {
            System.out.println("   - " + lista[i]);
        }
    }
    
}
