/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rf03_jugadores;

/**
 *
 * @author josef
 */
public class Prueba_RF03 
{
    public static void main(String[] args) 
    {
        GestorJugadores gestor = new GestorJugadores(4);

        // ---------- 1. Registrar jugadores ----------
        System.out.println("=== 1. Registrar ===");
        gestor.Registrar(new Regular(11111111, "Carlos", "Mena", "987654321", "carlos@mail.com"));
        gestor.Registrar(new Regular(22222222, "Diana", "Ruiz", "987111222", "diana@mail.com"));
        gestor.Registrar(new Regular(33333333, "Pedro", "Salas", "987333444", "pedro@mail.com"));
        comprobar("Hay 3 jugadores registrados", gestor.getJugadores().length == 3);
        mostrar(gestor);

        // ---------- 2. DNI duplicado ----------
        System.out.println("\n=== 2. DNI duplicado ===");
        gestor.Registrar(new Regular(22222222, "Otro", "Nombre", "900000000", "otro@mail.com"));
        comprobar("Sigue habiendo 3 jugadores (no se registro el duplicado)", gestor.getJugadores().length == 3);

        // ---------- 3. Busquedas ----------
        System.out.println("\n=== 3. Busquedas ===");
        comprobar("buscarPorDni encuentra 22222222", gestor.buscarPorDni(22222222) != null);
        comprobar("buscarPorDni no encuentra 99999999", gestor.buscarPorDni(99999999) == null);

        // ---------- 4. Descuento polimorfico ----------
        System.out.println("\n=== 4. Descuento segun el tipo (polimorfismo) ===");
        Jugador regular = gestor.buscarPorDni(11111111);
        comprobar("Jugador Regular: tipo Regular", regular.esFrecuente() == false);
        comprobar("Jugador Regular: descuento sobre 100 = 0", casiIgual(regular.calcularDescuento(100), 0));
        Frecuente frec = new Frecuente(44444444, "Lucia", "Vega", "987555666", "lucia@mail.com");
        comprobar("Jugador Frecuente: tipo Frecuente", frec.esFrecuente());
        comprobar("Jugador Frecuente: descuento sobre 100 = 10", casiIgual(frec.calcularDescuento(100), 10));

        // ---------- 5. Cambio automatico de tipo ----------
        System.out.println("\n=== 5. Regular pasa a Frecuente al llegar a 5 reservas finalizadas ===");
        for (int i = 1; i <= 4; i++) 
        {
            gestor.sumarReservaFinalizada(11111111);
        }
        Jugador j = gestor.buscarPorDni(11111111);
        comprobar("Con 4 reservas finalizadas sigue siendo Regular", j.esFrecuente() == false);
        comprobar("Su contador es 4", j.getReservasFinalizadas() == 4);

        gestor.sumarReservaFinalizada(11111111);
        j = gestor.buscarPorDni(11111111);
        comprobar("Con 5 reservas finalizadas pasa a Frecuente", j.esFrecuente());
        comprobar("Conserva su contador (5)", j.getReservasFinalizadas() == 5);
        comprobar("Conserva sus datos (nombres)", j.getNombres().length() == 6);
        comprobar("Ahora recibe descuento sobre 100 = 10", casiIgual(j.calcularDescuento(100), 10));
        comprobar("Sigue habiendo 3 jugadores (se reemplazo, no se duplico)", gestor.getJugadores().length == 3);

        gestor.sumarReservaFinalizada(11111111);
        j = gestor.buscarPorDni(11111111);
        comprobar("Con 6 reservas sigue siendo Frecuente", j.esFrecuente() && j.getReservasFinalizadas() == 6);

        boolean ok = gestor.sumarReservaFinalizada(99999999);
        comprobar("Sumar reserva a un DNI inexistente devuelve false", ok == false);
        mostrar(gestor);

        // ---------- 6. Modificar ----------
        System.out.println("\n=== 6. Modificar ===");
        ok = gestor.modificar(22222222, 22222222, "Diana Maria", "Ruiz", "999888777", "diana2@mail.com");
        comprobar("Modificar un jugador existente devuelve true", ok);
        comprobar("El cambio se refleja (nombres)", gestor.buscarPorDni(22222222).getNombres().length() == 11);

        ok = gestor.modificar(22222222, 33333333, "Diana", "Ruiz", "999888777", "diana@mail.com");
        comprobar("Modificar con un DNI que ya tiene otro jugador devuelve false", ok == false);

        ok = gestor.modificar(99999999, 99999999, "X", "Y", "1", "x@mail.com");
        comprobar("Modificar un DNI que no existe devuelve false", ok == false);

        ok = gestor.modificar(11111111, 11111111, "Carlos", "Mena", "987654321", "carlos@mail.com");
        comprobar("Modificar a un Frecuente conserva su tipo", gestor.buscarPorDni(11111111).esFrecuente());

        // ---------- 7. Eliminar ----------
        System.out.println("\n=== 7. Eliminar ===");
        ok = gestor.Eliminar(33333333);
        comprobar("Eliminar un jugador existente devuelve true", ok);
        comprobar("Quedan 2 jugadores", gestor.getJugadores().length == 2);
        comprobar("El jugador eliminado ya no se encuentra", gestor.buscarPorDni(33333333) == null);

        ok = gestor.Eliminar(99999999);
        comprobar("Eliminar un DNI que no existe devuelve false", ok == false);
        mostrar(gestor);

        // ---------- 8. Arreglo lleno ----------
        System.out.println("\n=== 8. Arreglo lleno (capacidad 4) ===");
        gestor.Registrar(new Regular(55555555, "Rosa", "Diaz", "987000111", "rosa@mail.com"));
        gestor.Registrar(new Regular(66666666, "Jose", "Vega", "987000222", "jose@mail.com"));
        comprobar("Hay 4 jugadores (arreglo lleno)", gestor.getJugadores().length == 4);

        gestor.Registrar(new Regular(77777777, "Sobra", "Uno", "987000333", "sobra@mail.com"));
        comprobar("Un quinto jugador no se registra", gestor.getJugadores().length == 4);
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

    // Muestra los jugadores registrados
    private static void mostrar(GestorJugadores gestor) 
    {
        Jugador[] lista = gestor.getJugadores();
        for (int i = 0; i < lista.length; i++) 
        {
            System.out.println("   - " + lista[i]);
        }
    }
    
}
