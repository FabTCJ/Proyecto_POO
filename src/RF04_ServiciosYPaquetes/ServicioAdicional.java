/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RF04_ServiciosYPaquetes;

/**
 *
 * @autor Giannis
 */
public class ServicioAdicional implements Cobrable 
{
    private String codigo, nombre;
    private float precioU; // precio Unitario
    private int stock;

    public ServicioAdicional(String codigo, String nombre, float precioU, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioU = precioU;
        this.stock = stock;
    }

    @Override
    public String getNombre() 
    {
        return nombre;
    }

    @Override
    public float getPrecioU() 
    {
        return precioU;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecioU(float precioU) {
        this.precioU = precioU;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    
}
