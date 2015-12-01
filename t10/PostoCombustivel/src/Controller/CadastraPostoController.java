/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.CadastraPosto;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class CadastraPostoController {
    private View.CadastraPosto view;
    private ListaPostos lista_postos = new ListaPostos();

    public CadastraPostoController(CadastraPosto view) {
        this.view = view;
    }
    
    
    
    public void cadastra_posto(String cnpj, String social, String fantasia, String bandeira, String endereco, String bairro, String cep){
        Posto novo_posto = new Posto();
        novo_posto.set_cnpj(cnpj);
        novo_posto.set_razao_social(social);
        novo_posto.set_nome_fantasia(fantasia);
        novo_posto.set_bandeira(bandeira);
        novo_posto.set_endereco(endereco);
        novo_posto.set_bairro(bairro);
        novo_posto.set_cep(cep);
        lista_postos.addPosto(novo_posto);
    }
    
    public String[] get_namelist(){
        return lista_postos.get_namelist();
    }
    
    public List<Posto> get_list(){
        return lista_postos.get_list();
    }
}
