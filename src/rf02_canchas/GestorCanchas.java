/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rf02_canchas;

/**
 *
 * @author josef
 */
public class GestorCanchas 
{
    private Cancha[] canchas;
    private int conta;
    
    public GestorCanchas(int conta)
    {
        this.canchas = new Cancha[conta];
        this.conta = 0;
    }
    
    // Metodo Registrar
    public void Registrar(Cancha ref) 
    {
        if (conta == canchas.length) 
        {
            System.out.println("Arreglo lleno");
            return;
        }
        if (buscarPorCodigo(ref.getCodigo()) != null) 
        {
            System.out.println("Codigo de cancha ya existente");
            return;
        }
        canchas[conta] = ref;
        conta++;
        System.out.println("Cancha registrada con exito");
    }
    
    // Metodo Eliminar
    public boolean Eliminar(int codigo) 
    {
        int pos = posicionPorCodigo(codigo);
        if (pos == -1) 
        {
            return false;
        }
        for (int i = pos; i < conta - 1; i++) 
        {
            canchas[i] = canchas[i + 1];
        }
        canchas[conta - 1] = null;
        conta--;
        return true;
    }

    // Metodo Modificar
    // Reemplaza la cancha con ese codigo por el objeto nuevo.
    // Si se quiere cambiar el tipo, se pasa un objeto de otra subclase.
    public boolean modificar(int codigoOriginal, Cancha ref) 
    {
        int pos = posicionPorCodigo(codigoOriginal);
        if (pos == -1) 
        {
            return false;
        }
        for (int i = 0; i < conta; i++) 
        {
            if (i != pos) 
            {
                if (canchas[i].getCodigo() == ref.getCodigo()) 
                {
                    return false;
                }
            }
        }
        canchas[pos] = ref;
        return true;
    }

    // Metodos de busqueda
    public Cancha buscarPorCodigo(int codigo) 
    {
        int pos = posicionPorCodigo(codigo);
        if (pos == -1) 
        {
            return null;
        }
        return canchas[pos];
    }

    private int posicionPorCodigo(int codigo) 
    {
        for (int i = 0; i < conta; i++) 
        {
            if (canchas[i].getCodigo() == codigo) 
            {
                return i;
            }
        }
        return -1;
    }

    // Copia del arreglo solo con las canchas registradas (sin nulls)
    public Cancha[] getCanchas() 
    {
        Cancha[] copia = new Cancha[conta];
        for (int i = 0; i < conta; i++) 
        {
            copia[i] = canchas[i];
        }
        return copia;
    }
    
}
