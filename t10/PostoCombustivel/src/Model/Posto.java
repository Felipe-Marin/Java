/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Felipe
 */
public class Posto{
    private String cnpj;
    private String razao_social;
    private String nome_fantasia;
    private String bandeira;
    private String endereco;
    private String bairro;
    private String cep;
    private String imagem;
    private List<Combustivel> gasolina;
    private List<Combustivel> etanol;
    private List<Combustivel> diesel;
    
    public Posto(){
        cnpj= "";
        razao_social = "";
        nome_fantasia = "";
        bandeira = "";
        endereco = "";
        bairro = "";
        cep = "";
        imagem = "";
        gasolina = new ArrayList<>();
        etanol = new ArrayList<>();
        diesel = new ArrayList<>();
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
    
    public void set_imagem(String imagem){
        this.imagem = imagem;
    }
    
    public String get_nome(){
        return this.nome_fantasia;
    }
    
    public String get_cnpj(){
        return this.cnpj;
    }
    
    public String get_razao(){
        return this.razao_social;
    }
    
    public String get_endereco(){
        return this.endereco;
    }
    
    public String get_bandeira(){
        return this.bandeira;
    }
    
    public String get_bairro(){
        return this.bairro;
    }
    
    public String get_imagem(){
        return this.imagem;
    }
    
    public String get_cep(){
        return this.cep;
    }
    
    @Override
    public String toString(){
        return nome_fantasia;
    }
    
    public void insere_combustivel(Date data, long preco, String tipo){
        Combustivel novo_combustivel = new Combustivel();
        novo_combustivel.setDate(data);
        novo_combustivel.setPreco(preco);
        switch(tipo){
            case "Gasolina" : gasolina.add(novo_combustivel); break;
            case "Etanol" : etanol.add(novo_combustivel); break;
            case "Diesel" : diesel.add(novo_combustivel); break;
            default : System.out.println("Erro");
        }
    }
    
    public Combustivel[] lista_gasolina(){
        Combustivel[] list = new Combustivel[gasolina.size()];
        return gasolina.toArray(list);
    }
    
    public Combustivel[] lista_etanol(){
        Combustivel[] list = new Combustivel[etanol.size()];
        return etanol.toArray(list);
    }
    
    public Combustivel[] lista_diesel(){
        Combustivel[] list = new Combustivel[diesel.size()];
        return diesel.toArray(list);
    }
    
    public List get_lista_atributos(){
        List atributos = new ArrayList();
        atributos.add(cnpj);
        atributos.add(razao_social);
        atributos.add(nome_fantasia);
        atributos.add(bandeira);
        atributos.add(endereco);
        atributos.add(bairro);
        atributos.add(cep);
        atributos.add(imagem);
        return atributos;
    }

}
