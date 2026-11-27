/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rf02_canchas;

/**
 *
 * @author josef
 */
public class CanchaFutbol11 extends Cancha
{

    public CanchaFutbol11(int codigo, String nombre, int capacidad, double tarifaBase) {
        super(codigo, nombre, capacidad, tarifaBase);
    }

    @Override
    public String getTipo() 
    {
        return "Cancha Futbol 11";
    }

    @Override
    public double CalcularTarifa(int hora) 
    {
        if(hora >= 18)
        {
            return this.getTarifaBase() * 1.20;
        }
        return this.getTarifaBase();
    }
    
    
    
}
