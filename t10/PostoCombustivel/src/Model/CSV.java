/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.*;

/**
 *
 * @author Felipe
 */
public class CSV {
    
    File postocsv;
    
    public CSV(){
        postocsv = new File("C:/CSV/posto.csv");
    }
    
    public void write_posto(Posto p){
        FileWriter fw;
        String line = p.get_cnpj() + "," + p.get_razao() + "," + p.get_nome()+ ",";
        line = line + p.get_bandeira() + "," + p.get_endereco() + ",";
        line = line + p.get_bairro() + "," + p.get_cep() + "," + p.get_imagem() + "," + "\n";
        try{
            fw = new FileWriter(postocsv, true);
            fw.write(line);
        }
        catch(IOException ioe){
            System.out.println("Exception.");
        }
        
    }
}
