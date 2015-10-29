/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t9.estacionamento;
/**
 *
 * @author Felipe
 */
class Veiculo{
    private String placa;
    private int tipo;
    private long hora_entrada;
    
    public Veiculo(String placa_, int tipo_, long horae){
        placa = placa_;
        tipo = tipo_;
        hora_entrada = horae;
    }
    
    public int Tipo(){
        return tipo;
    }
    
    public String Placa(){
        return placa;
    }
    
    public long Hora(){
        return hora_entrada;
    }
}

class Estacionamento{
    private Veiculo v1;
    private int vagas_disponiveis = 1;
    
    public Estacionamento(){}
    
    public void entra(String placa, int tipo){
        if(vagas_disponiveis > 0){
           v1 = new Veiculo(placa, tipo, System.currentTimeMillis()); 
           vagas_disponiveis -= 1;
           System.out.printf("O veiculo %s foi estacionado.\n", placa);
        }else{
            System.out.println("Não há vaga disponivel.");
        }
    }
    
    public void saida(){
        if(vagas_disponiveis == 1){
            System.out.println("Não há veiculo estacionado.");
        }else{
            double valor;
            long horasaida;
            if(v1.Tipo() == 1){
                horasaida = System.currentTimeMillis() + 1800000; //+5400000 apenas para teste.
                valor = 0.05 * ((horasaida - v1.Hora()) / 60000);
                System.out.printf("Valor(Carro, Placa: %s): R$%.2f\n", v1.Placa(), valor);
            }
            if(v1.Tipo() == 2){
                horasaida = System.currentTimeMillis() + 10800000; //+9000000 apenas para teste.
                valor = 0.025 * ((horasaida - v1.Hora()) / 60000);
                System.out.printf("Valor(Moto, Placa: %s): R$%.2f\n", v1.Placa(), valor);
            }
            vagas_disponiveis += 1;
            
        }
    }
    
    
}

public class T9Estacionamento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estacionamento estacionamento;
        estacionamento = new Estacionamento();
        estacionamento.entra("ABC1234", 1);
        estacionamento.entra("BDE4321", 2);
        estacionamento.saida();
        estacionamento.entra("BDE4321", 2);
        estacionamento.saida();
    }
    
}
