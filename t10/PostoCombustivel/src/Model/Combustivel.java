/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author Felipe
 */
public class Combustivel {
    //private enum combustiveis{Gasolina, Diesel, Etanol}
    //combustiveis tipo;
    private long preco;
    private Date data;
    
    public Combustivel(){
        preco = 0;
        data = new Date(System.currentTimeMillis());
    }
    
    public Combustivel(Date data, long preco){
        this.preco = preco;
        this.data = data;
    }
    
    //public void setTipo(String tipo){
    //    this.tipo = combustiveis.valueOf(tipo);
    //}
    
    public void setPreco(long preco){
        this.preco = preco;
    }
    
    public void setDate(Date data){
        this.data = data;
    }
    
    public String getPreco(){
        String s = String.valueOf(preco);
        return s;
    }
    
    @Override
    public String toString(){
        double  preco_real = preco/100;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
        return "Data:" + format.format(data)+ " - Preço: R$"+Double.toString(preco_real);
    }
}
    
    
