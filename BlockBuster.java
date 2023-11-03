
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class BlockBuster {
    private int peliculasAuditadas;
    ArrayList <BlockBusterItem> items;
    
    public BlockBuster() {
        this.items = new ArrayList<>();
    }
    public int getPeliculasAuditadas() {
        return peliculasAuditadas;
    }
    public BlockBusterItem BuscarItem(int code,String type){
        for(BlockBusterItem item : items){
            if (item.getCodigo() == code && ((type.equals("MOVIE") && item instanceof MovieItem) ||
                    (type.equals("GAME") && item instanceof VideoGameItem))) {
            return item;
            } 
        }
        return null;
    }
     public void agregarItem(int codigo, String nombre, String tipoItem) {
        BlockBusterItem itemExistente = BuscarItem(codigo, tipoItem);
        if (itemExistente == null) {
            if (tipoItem.equals("MOVIE")) {
                items.add(new MovieItem(codigo, nombre, 0)); 
            } else if (tipoItem.equals("GAME")) {
                String consola = obtenerConsolaValida();
                items.add(new VideoGameItem(codigo, nombre,0, consola));
            }
            System.out.println("Ítem agregado con éxito.");
        } else {
            System.out.println("Ya existe un ítem con el mismo código y tipo.");
        }
    }
    public void rentar(int codigo, String tipoItem, int dias) {
        BlockBusterItem item = BuscarItem(codigo, tipoItem);
        if (item != null) {
            System.out.println("Datos del item:");
            System.out.println(item.toString());
            double montoAPagar = item.pagoRenta(dias);
            System.out.println("Monto a pagar: " + montoAPagar + " Lps.");
        } else {
            System.out.println("Este item no existe.");
        }
    }
    public void auditarMovieEstados() {
        for (BlockBusterItem item : items) {
            if (item instanceof MovieItem) {
                ((MovieItem) item).EvaluarEstado();
                 peliculasAuditadas++;
            }
        }
        System.out.println("Auditoría de estados de películas realizada.");
    }

    private String obtenerConsolaValida() {
        System.out.println("Ingrese la consola (PLAYSTATION, XBOX o WII):");
        String consola = "";
        while (true) {
            String consolaIngresada = System.console().readLine();
            if (consolaIngresada.equals(VideoGameItem.PLAYSTATION) || consolaIngresada.equals(VideoGameItem.XBOX) || consolaIngresada.equals(VideoGameItem.WII)) {
                consola = consolaIngresada;
                break;
            } else {
                System.out.println("Consola no válida. Por favor, ingrese una consola válida.");
            }
        }
        return consola;
    }
}

