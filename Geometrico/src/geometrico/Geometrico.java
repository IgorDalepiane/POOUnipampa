/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometrico;

/**
 *
 * @author 1801560700
 */
public class Geometrico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Quadrado q = new Quadrado(5);
        System.out.println("Area do Quadrado: "+ q.calculaArea());
        System.out.println("Perimetro do Quadrado: "+ q.calculaPerimetro());
        
        Retangulo r = new Retangulo(4,9);
        System.out.println("Area do Retangulo: "+ r.calculaArea());
        System.out.println("Perimetro do Retangulo: "+ r.calculaPerimetro());
    }
    
}
