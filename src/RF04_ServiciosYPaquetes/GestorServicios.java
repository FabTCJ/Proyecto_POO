/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RF04_ServiciosYPaquetes;

import javax.swing.JOptionPane;

/**
 *
 * @author Giannis
 */
public class GestorServicios 
{
    private ServicioAdicional[] servicios;
    private PaquetePromocional[] paquetes;
    
    private int contaServ;
    private int contaPaq;
    
    public GestorServicios()
    {
        this.servicios = new ServicioAdicional[100];
        this.paquetes = new PaquetePromocional[100];
        this.contaServ = 0;
        this.contaPaq = 0;
    }
    
    // ---------- Metodos de servicios --------------
    
    public void RegistrarServicio(ServicioAdicional ref)
    {
        boolean repetido = false;
        
        if (ref == null) // campos obligatorios
        {
            JOptionPane.showMessageDialog(null, "El servicio no puede estar vacío.");
        }
        else if (ref.getCodigo().equals(""))
        {
            JOptionPane.showMessageDialog(null, "El código es obligatorio.");
        }
        else if (ref.getNombre().equals(""))
        {
            JOptionPane.showMessageDialog(null, "El nombre es obligatorio.");
        }
        else if (ref.getPrecioU() <= 0)
        {
            JOptionPane.showMessageDialog(null, "El precio debe ser mayor a 0.");
        }
        else if (ref.getStock() < 0)
        {
            JOptionPane.showMessageDialog(null, "El stock no debe ser negativo.");
        }
        else if (contaServ < servicios.length) // registrar servicio
        {
            for (int i=0;i<contaServ;i++)
            {
                if (servicios[i].getCodigo().equalsIgnoreCase(ref.getCodigo()))
                {
                    repetido = true;
                    break;
                }
            }
            
            if (repetido)
            {
                JOptionPane.showMessageDialog(null, "El codigo ingresado ya existe para este servicio.");
            }
            else
            {
                servicios[contaServ] = ref;
                contaServ++;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Sin espacio disponible.");
        }
        
    }
    
    public void ModificarServicio(String codigo, String nuevoNom, float nuevoPrecioU, int nuevoStock) // cambiar por su codigo
    {
        boolean encontrado = false;
        for (int i=0;i<contaServ;i++)
        {
            if (servicios[i].getCodigo().equalsIgnoreCase(codigo))
            {
                encontrado = true;
                servicios[i].setNombre(nuevoNom);
                servicios[i].setPrecioU(nuevoPrecioU);
                servicios[i].setStock(nuevoStock);
                JOptionPane.showMessageDialog(null, "Cambios realizados con éxito.");
                break;
            }
        }
        
        if (!encontrado)
        {
            JOptionPane.showMessageDialog(null, "El código ingresado no se encontró.");
        }
        
    }
    
    public void EliminarServicio(String cod)
    {
        boolean encontrado = false;
        for (int i=0;i<contaServ;i++)
        {
            if (servicios[i].getCodigo().equalsIgnoreCase(cod))
            {
                encontrado = true;
                for (int j=i;j<contaServ-1;j++)
                {
                    servicios[j] = servicios[j+1];
                }
                servicios[contaServ-1] = null;
                contaServ--;
                JOptionPane.showMessageDialog(null, "Servicio eliminado con éxito.");
            }
        }
        
        if (!encontrado)
        {
            JOptionPane.showMessageDialog(null, "El codigo ingresado no se encontró.");
        }
    }
    
    
    // ------------ Metodos de paquetes --------------
    
    public void RegistrarPaquete(PaquetePromocional ref)
    {
        boolean repetido = false;
        
        if (ref == null) // campos obligatorios
        {
            JOptionPane.showMessageDialog(null, "El paquete no puede estar vacío.");
        }
        else if (ref.getNombre().equals(""))
        {
            JOptionPane.showMessageDialog(null, "El nombre es obligatorio.");
        }
        else if (ref.getPrecioU() <= 0)
        {
            JOptionPane.showMessageDialog(null, "El precio debe ser mayor a 0.");
        }
        else if (ref.getServicios() == null || ref.getServicios().length == 0)
        {
            JOptionPane.showMessageDialog(null, "El paquete debe incluir al menos un servicio");
        }
        else if (contaPaq < paquetes.length) // registrar paquete
        {
            for (int i=0;i<contaPaq;i++)
            {
                if (paquetes[i].getNombre().equalsIgnoreCase(ref.getNombre()))
                {
                    repetido = true;
                    break;
                }
            }
            
            if (repetido)
            {
                JOptionPane.showConfirmDialog(null, "El nombre de servicio ya se encuentra registrado.");
            }
            else
            {
                paquetes[contaPaq] = ref;
                contaPaq++;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Sin espacio disponible.");
        }
        
    }
    
    public void ModificarPaquete(String nom, String nuevoNom, ServicioAdicional[] nuevoServicio, float nuevoPrecio) // reemplazar con nuevo nombre
    {
        boolean encontrado = false;
        for (int i=0;i<contaPaq;i++)
        {
            if (paquetes[i].getNombre().equalsIgnoreCase(nom))
            {
                for (int j=0;j<contaPaq;j++)
                {
                    if (j != i && paquetes[j].getNombre().equalsIgnoreCase(nuevoNom)) // verificar que el paquete no este repetido
                    {
                        JOptionPane.showMessageDialog(null, "El nombre del paquete ingresado ya existe.");
                    }
                }
                encontrado = true;
                paquetes[i].setNombrePaq(nuevoNom);
                paquetes[i].setServicios(nuevoServicio);
                paquetes[i].setPrecioPromo(nuevoPrecio);
                JOptionPane.showMessageDialog(null, "Cambios realizados con éxito.");
                break;
            }
        }
        
        if (!encontrado)
        {
            JOptionPane.showMessageDialog(null, "El nombre del paquete no se encontró.");
        }
    }
    
    public void EliminarPaquete(String nom)
    {
        boolean encontrado = false;
        for (int i=0;i<contaPaq;i++)
        {
            if (paquetes[i].getNombre().equalsIgnoreCase(nom))
            {
                encontrado = true;
                for (int j=i;j<contaPaq-1;j++)
                {
                    paquetes[j] = paquetes[j+1];
                }
                paquetes[contaPaq-1] = null;
                contaPaq--;
            }
        }
        
        if (!encontrado)
        {
            JOptionPane.showMessageDialog(null, "El nombre ingresado no se encontró.");
        }
    }
    
    
}
