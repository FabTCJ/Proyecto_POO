/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RF04_ServiciosYPaquetes;

/**
 *
 * @autor Giannis
 */
public class PaquetePromocional implements Cobrable
{
    protected ServicioAdicional[] servicios;
    protected String nombrePaq;
    protected float precioPromo;

    public PaquetePromocional(String nombrePaq, ServicioAdicional[] servicios, float precioPromo) {
        this.nombrePaq = nombrePaq;
        this.precioPromo = precioPromo;
        setServicios(servicios); // llamar al setServicios para definir el tamaño del arreglo servicios
    }

    @Override
    public String getNombre() 
    {
        return nombrePaq;
    }

    @Override
    public float getPrecioU() 
    {
        return precioPromo;
    }

    public ServicioAdicional[] getServicios() {
        return servicios;
    }

    public void setServicios(ServicioAdicional[] servicios) {
        this.servicios = new ServicioAdicional[servicios.length]; // el arreglo aumenta conforme se van añadiendo servicios
        for (int i=0;i<servicios.length;i++)
        {
            this.servicios[i] = servicios[i];
        }
    }

    public void setNombrePaq(String nombrePaq) {
        this.nombrePaq = nombrePaq;
    }

    public void setPrecioPromo(float precioPromo) {
        this.precioPromo = precioPromo;
    }
    
    
}
