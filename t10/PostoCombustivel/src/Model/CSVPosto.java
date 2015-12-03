/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.*;
/**
 *
 * @author Felipe
 */
public class CSVPosto{
    
    File postocsv;
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final Object [] FILE_HEADER = {"cnpj","razaosocial","nome","bandeira","endereco","bairro","cep","imagem"};
    private static final String[] FILE_HEADER_MAPPING = {"cnpj","razaosocial","nome","bandeira","endereco","bairro","cep","imagem"};
    
    CSVPrinter csvFilePrinter = null;
    CSVParser csvFileParser = null;
    
    public CSVPosto(){
        postocsv = new File("C:/CSV/posto.csv");
    }
    
    public void write_posto(Posto p){
        FileWriter fw=null;
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
        try{
            fw = new FileWriter(postocsv, true);
            csvFilePrinter = new CSVPrinter(fw, csvFileFormat);
            //csvFilePrinter.printRecord(FILE_HEADER);
            csvFilePrinter.printRecord(p.get_lista_atributos());
        }
        catch(IOException e){
            System.out.println("Exception.");
        } finally{
            try{
                fw.flush();
		fw.close();
		csvFilePrinter.close();
            }catch(IOException e){
		System.out.println("Error fechar arquivo CSV    ");
            }
        }
    }
    
    public List<Posto> read_List_postos(){
        FileReader fr = null;
        List<Posto> lista = new ArrayList();
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
        try{            
            fr = new FileReader(postocsv);
            csvFileParser = new CSVParser(fr, csvFileFormat);
            List<CSVRecord> csvRecords = csvFileParser.getRecords();
            for (int i = 1; i < csvRecords.size(); i++){
                CSVRecord record = csvRecords.get(i);
                Posto p = new Posto();
                p.set_cnpj(record.get("cnpj"));
                p.set_razao_social(record.get("razaosocial"));
                p.set_nome_fantasia(record.get("nome"));
                p.set_cnpj(record.get("bandeira"));
                p.set_cnpj(record.get("endereco"));
                p.set_cnpj(record.get("bairro"));
                p.set_cnpj(record.get("cep"));
                p.set_cnpj(record.get("imagem"));
                lista.add(p);
            }
        }
        catch(IOException e){
            System.out.println("Erro na leitura CSV");
        }
        finally{
            try{
                fr.close();
                csvFileParser.close();
            }
            catch(IOException e){
                System.out.println("Erro ao fechar arquivo CSV");
            }
        }
        return lista;
    }
    
    public void replace_posto(Posto p_old, Posto p_new){
        try{
            FileReader fr = new FileReader(postocsv);
            //csvFileParser = new CSVParser(fr, csvFileFormat);
        }
        catch(IOException e){
            
        }
    }
}
