
import java.util.Calendar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public abstract class BlockBusterItem {
    int codigo;
    String nombre;
    double precio;
    
    BlockBusterItem(int code, String name, double price){
        codigo=code;
        nombre=name;
        precio=price;
        Calendar fecha = Calendar.getInstance();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    @Override
    public String toString(){
        return "Nombre: "+ nombre+" Codigo: "+codigo+" Precio de la Renta: "+precio ;
    }
    
    public abstract double pagoRenta(int dias);
      
}
