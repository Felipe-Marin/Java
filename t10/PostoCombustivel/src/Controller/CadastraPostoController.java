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
    
    
    
    public void cadastra_posto(String cnpj, String social, String fantasia, String bandeira, String endereco, String bairro, String cep, String imagem){
        Posto novo_posto = new Posto();
        novo_posto.set_cnpj(cnpj);
        novo_posto.set_razao_social(social);
        novo_posto.set_nome_fantasia(fantasia);
        novo_posto.set_bandeira(bandeira);
        novo_posto.set_endereco(endereco);
        novo_posto.set_bairro(bairro);
        novo_posto.set_cep(cep);
        novo_posto.set_imagem(imagem);
        lista_postos.addPosto(novo_posto);
    }
    
    public void editar_posto(String cnpj, String social, String fantasia, String bandeira, String endereco, String bairro, String cep, String imagem, Object obj){
        Posto posto = (Posto)obj;
        posto.set_cnpj(cnpj);
        posto.set_razao_social(social);
        posto.set_nome_fantasia(fantasia);
        posto.set_bandeira(bandeira);
        posto.set_endereco(endereco);
        posto.set_bairro(bairro);
        posto.set_cep(cep);
        posto.set_imagem(imagem);
    }
    
    public void excluir_posto(Object obj){
        Posto posto = (Posto)obj;
        lista_postos.removePosto(posto);
    }
    
    public String[] get_namelist(){
        return lista_postos.get_namelist();
    }
    
    public List<Posto> get_list(){
        return lista_postos.get_list();
    }
    
    public String[] get_selected_list_values(Object ob_posto){
        Posto posto = (Posto)ob_posto;
        String[] list = new String[8];
        list[0] = posto.get_cnpj();
        list[1] = posto.get_razao();
        list[2] = posto.get_nome();
        list[3] = posto.get_bandeira();
        list[4] = posto.get_endereco();
        list[5] = posto.get_bairro();
        list[6] = posto.get_cep();
        list[7] = posto.get_imagem();
        return list;
    }
    
    public List busca_posto(String bairro){
        return lista_postos.busca_bairro(bairro);
    }
}
