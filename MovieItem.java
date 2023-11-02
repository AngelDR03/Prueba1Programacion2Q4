
import java.util.Calendar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class MovieItem extends BlockBusterItem {
    Calendar date;
    String estado;
    public MovieItem(int code, String name, double price) {
        super(code, name, price);
        Calendar date= Calendar.getInstance();
        estado="ESTRENO";
    }

    public String EvaluarEstado(){
        Calendar fecha = Calendar.getInstance();
        
        if (fecha.get(Calendar.MONTH)-date.get(Calendar.MONTH)>=5){
            return estado="NORMAL";
        }
        return estado;
    }
    @Override
    public double pagoRenta(int dias) {
        if (EvaluarEstado().equals("NORMAL")&&dias>5) {
            return (dias-5)*30;
        }else if(EvaluarEstado().equals("ESTRENO")&&dias>2){
            return (dias-2)*50;
        }
        return precio;
    }
    @Override
    public String toString(){
        return super.toString()+ estado + "-Movie";
    }
    
}
