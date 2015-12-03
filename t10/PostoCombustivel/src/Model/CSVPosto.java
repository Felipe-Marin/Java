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
    private static final String POSTO_CNPJ = "cnpj";
    private static final String POSTO_RAZAOSOCIAL = "razaosocial";
    private static final String POSTO_NOME = "nome"; 
    private static final String POSTO_BANDEIRA = "bandeira";
    private static final String POSTO_ENDERECO = "endereco";
    private static final String POSTO_BAIRRO = "bairro";
    private static final String POSTO_CEP = "cep";
    private static final String POSTO_IMAGEM = "imagem";   
    CSVPrinter csvFilePrinter = null;
    CSVParser csvFileParser = null;
    
    public CSVPosto(){
        postocsv = new File("posto.csv");
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
    
    public void write_all_posto(List<Posto> lista_posto){
        FileWriter fw=null;
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
        try{
            fw = new FileWriter(postocsv, false);
            csvFilePrinter = new CSVPrinter(fw, csvFileFormat);
            csvFilePrinter.printRecord(FILE_HEADER);
            for(Posto p : lista_posto){
                csvFilePrinter.printRecord(p.get_lista_atributos());
            }
            
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
                p.set_cnpj(record.get(POSTO_CNPJ));
                p.set_razao_social(record.get(POSTO_RAZAOSOCIAL));
                p.set_nome_fantasia(record.get(POSTO_NOME));
                p.set_bandeira(record.get(POSTO_BANDEIRA));
                p.set_endereco(record.get(POSTO_ENDERECO));
                p.set_bairro(record.get(POSTO_BAIRRO));
                p.set_cep(record.get(POSTO_CEP));
                p.set_imagem(record.get(POSTO_IMAGEM));
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
