/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.*;
import Model.*;
import java.util.List;
import java.util.Date;

/**
 *
 * @author Felipe
 */
public class CadastrarCombustivelController {
    private View.CadastrarCombustivel view;
    List<Posto> list_postos;

    public CadastrarCombustivelController(CadastrarCombustivel view, List<Posto> list_postos) {
        this.view = view;
        this.list_postos = list_postos;
    }
    
    public void add_combustivel(Object ob, String tipo, String data, String preco){
        System.out.println(data);
        System.out.println(preco);
        Posto p = (Posto)ob;
        long precol = Long.parseLong(preco);
        Date date = new Date(data);
        System.out.println(date.toString());
        p.insere_combustivel(date, precol, tipo);
    }
    
    public List<Posto> get_list(){
        return list_postos;
    }
    
    public Combustivel[] get_price_gasolina(Object ob){
        Posto p = (Posto)ob;
        return p.lista_gasolina();
    }
    
    public Combustivel[] get_price_etanol(Object ob){
        Posto p = (Posto)ob;
        return p.lista_etanol();
    }
    
    public Combustivel[] get_price_diesel(Object ob){
        Posto p = (Posto)ob;
        return p.lista_diesel();
    }
    
}
