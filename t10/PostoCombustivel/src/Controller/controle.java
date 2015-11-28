/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Posto;

/**
 *
 * @author Felipe
 */
class Controller{
    private CadastrarPosto view;
    
    Controller(CadastrarPosto view){
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
    }
    
}
