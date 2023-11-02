/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author LENOVO
 */
public class VideoGameItem extends BlockBusterItem {
    private String consola;
    public static final String PLAYSTATION = "PLAYSTATION";
    public static final String XBOX = "XBOX";
    public static final String WII = "WII";
    public VideoGameItem(int code, String name, double price, String consola) {
        super(code, name, 30);
        this.consola=consola;
    }   
    @Override
     public String toString() {
        return super.toString() + " - "+consola+" Game";
    }

    @Override
    public double pagoRenta(int dias) {
     return 30*dias;  
    } 
    
}
