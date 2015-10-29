/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t9;

/**
 *
 * @author Felipe
 */
class Ponto{
    private double x;
    private double y;
    
    public Ponto(){
        x = 0;
        y = 0;
    }
    
    public Ponto(double ini_x, double ini_y){
        x = ini_x;
        y = ini_y;
    }
    
    public void move(double dx, double dy){
        x += dx;
        y += dy;
    }
    
    public void mostra(){
        System.out.printf("Position x: %f\n", x);
        System.out.printf("Position y: %f\n", y);
    }
}

class Circle{
    private Ponto centro;
    private double raio;
    
    public Circle(){
        centro = new Ponto();
        raio = 1;
    }
    
    public Circle(double x, double y, double r){
        centro = new Ponto(x, y);
        raio = r;
    }
    
    public double getArea(){
        double area;
        area = Math.PI * raio * raio;
        return area;
    }
    
    public double getDiameter(){
        double diameter;
        diameter = 2 * raio;
        return diameter;
    }
    
    public void mostra(){
        centro.mostra();
        System.out.printf("Raio: %f\n", raio);
    }
}

public class T9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circle circulo1;
        Circle circulo2;
        circulo1 = new Circle(1.0, 2.0, 5);
        System.out.println("Circulo 1:");
        circulo1.mostra();
        System.out.printf("Área circulo 1: %f\n", circulo1.getArea());
        System.out.printf("Diametro circulo 1: %f\n", circulo1.getDiameter());
        circulo2 = new Circle();
        System.out.println("Circulo 2:");
        circulo2.mostra();
        System.out.printf("Área circulo 2: %f\n", circulo2.getArea());
        System.out.printf("Diametro circulo 2: %f\n", circulo2.getDiameter());
    }
    
}
