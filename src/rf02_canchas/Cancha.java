/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rf02_canchas;

/**
 *
 * @author josef
 */
public abstract class Cancha 
{
    private int codigo, capacidadMaxima, estadoCancha;         
    private String nombre;      
    private double tarifaBase;

    public Cancha(int codigo, String nombre, int capacidad, double tarifaBase) 
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.capacidadMaxima = capacidad;
        this.tarifaBase = tarifaBase;
        this.estadoCancha = 1;
    }

    
    
    //Metodos abstractos, para tipo de cancha y calcular tipo segun tarifa
    
    public abstract String getTipo();
    
    public abstract double CalcularTarifa(int hora);
    
    public boolean PuedeReservarse()
    {
        return estadoCancha != 3;
    }
    
    //Pasa el estado de int a String 
    
    public String getEstadoTexto() 
    {
        if (estadoCancha == 1) 
        {
            return "Disponible";
        }
        if (estadoCancha == 2) 
        {
            return "Ocupada";
        }
        return "En Mantenimiento";
    }
    
    //Getters y Setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getEstadoCancha() {
        return estadoCancha;
    }

    public void setEstadoCancha(int estadoCancha) {
        this.estadoCancha = estadoCancha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    @Override
    public String toString() 
    {
        return codigo + " - " + nombre + " (" + getTipo() + ", " + getEstadoTexto() + ")";
    }
    
}
