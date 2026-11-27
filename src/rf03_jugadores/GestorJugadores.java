/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rf03_jugadores;

/**
 *
 * @author josef
 */
public class GestorJugadores 
{
    private Jugador[] jugadores;
    private int conta;

    public GestorJugadores(int capacidad) 
    {
        this.jugadores = new Jugador[capacidad];
        this.conta = 0;
    }

    // Metodo Registrar
    public void Registrar(Jugador ref) 
    {
        if (conta == jugadores.length) 
        {
            System.out.println("Arreglo lleno");
            return;
        }
        if (buscarPorDni(ref.getDNI()) != null) 
        {
            System.out.println("DNI ya existente");
            return;
        }
        jugadores[conta] = ref;
        conta++;
        System.out.println("Jugador registrado con exito");
    }

    // Metodo Eliminar
    public boolean Eliminar(int DNI) 
    {
        int pos = posicionPorDni(DNI);
        if (pos == -1) 
        {
            return false;
        }
        for (int i = pos; i < conta - 1; i++) 
        {
            jugadores[i] = jugadores[i + 1];
        }
        jugadores[conta - 1] = null;
        conta--;
        return true;
    }

    // Metodo Modificar
    // Cambia los datos del jugador pero conserva su tipo y sus reservas finalizadas
    public boolean modificar(int DNIOriginal, int DNINuevo, String nombres, String apellidos, String telefono, String correoElectronico) 
    {
        int pos = posicionPorDni(DNIOriginal);
        if (pos == -1) 
        {
            return false;
        }
        // El nuevo DNI no puede ser el de OTRO jugador
        for (int i = 0; i < conta; i++) 
        {
            if (i != pos) 
            {
                if (jugadores[i].getDNI() == DNINuevo) 
                {
                    return false;
                }
            }
        }
        jugadores[pos].setDNI(DNINuevo);
        jugadores[pos].setNombres(nombres);
        jugadores[pos].setApellidos(apellidos);
        jugadores[pos].setTelefono(telefono);
        jugadores[pos].setCorreoElectronico(correoElectronico);
        return true;
    }

    
    public boolean sumarReservaFinalizada(int DNI) 
    {
        int pos = posicionPorDni(DNI);
        if (pos == -1) 
        {
            return false;
        }
        jugadores[pos].incrementarReservasFinalizadas();
        if (jugadores[pos].getReservasFinalizadas() == 5) 
        {
            jugadores[pos] = new Frecuente(jugadores[pos]);
        }
        return true;
    }

    // Metodos de busqueda
    public Jugador buscarPorDni(int DNI) 
    {
        int pos = posicionPorDni(DNI);
        if (pos == -1) 
        {
            return null;
        }
        return jugadores[pos];
    }

    private int posicionPorDni(int DNI) 
    {
        for(int i = 0; i < conta; i++) 
        {
            if(jugadores[i].getDNI() == DNI) 
            {
                return i;
            }
        }
        return -1;
    }

    // Copia del arreglo solo con los jugadores registrados (sin nulls)
    public Jugador[] getJugadores() 
    {
        Jugador[] copia = new Jugador[conta];
        for(int i = 0; i < conta; i++) 
        {
            copia[i] = jugadores[i];
        }
        return copia;
    }
    
}
