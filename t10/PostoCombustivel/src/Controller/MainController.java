/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.Main;
import Model.*;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class MainController {
    Main view;
    List<Posto> lista_postos;
    CSVPosto csv;
    
    public MainController(Main view, List<Posto> lista_postos){
        this.view = view;
        this.lista_postos = lista_postos;
        csv = new CSVPosto();
        lista_postos.addAll(csv.read_List_postos());
        System.out.println(lista_postos);
    }

}
