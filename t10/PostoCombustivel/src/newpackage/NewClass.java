/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Felipe
 */
class Posto{
    private String cnpj;
    private String razao_social;
    private String nome_fantasia;
    private String bandeira;
    private String endereco;
    private String bairro;
    private String cep;
    
    public Posto(){
        cnpj= "";
        razao_social = "";
        nome_fantasia = "";
        bandeira = "";
        endereco = "";
        bairro = "";
        cep = "";
    }
    
    public void set_cnpj(String cnpj){
        this.cnpj = cnpj;
    }
    
    public void set_razao_social(String razao_social){
        this.razao_social = razao_social;
    }
    
    public void set_nome_fantasia(String nome_fantasia){
        this.nome_fantasia = nome_fantasia;
    }
    
    public void set_bandeira(String bandeira){
        this.bandeira = bandeira;
    }
    
    public void set_endereco(String endereco){
        this.endereco = endereco;
    }
    
    public void set_bairro(String bairro){
        this.bairro = bairro;
    }
    
    public void set_cep(String cep){
        this.cep = cep;
    }
    
}
