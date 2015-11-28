/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.Date;
/**
 *
 * @author Felipe
 */
public class Combustivel {
    private enum combustiveis{Gasolina, Diesel, Etanol}
    combustiveis tipo;
    private long preco;
    private Date data;
    
    public Combustivel(){
        preco = 0;
        data.setTime(System.currentTimeMillis());
    }
    
    public void setTipo(String tipo){
        this.tipo = combustiveis.valueOf(tipo);
    }
    
    public void setPreco(long preco){
        this.preco = preco;
    }
    
    public void setDate(Date data){
        this.data = data;
    }
}
    
    
