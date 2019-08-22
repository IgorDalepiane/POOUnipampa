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
public class Retangulo implements CalculosFiguraGeometrica{
    
    protected double ladoMenor;
    protected double ladoMaior;

    public Retangulo(double ladoMenor, double ladoMaior) {
        this.ladoMenor = ladoMenor;
        this.ladoMaior = ladoMaior;
    }
    @Override
    public double calculaArea() {
        return ladoMenor*ladoMaior;
    }

    @Override
    public double calculaPerimetro() {
        return (ladoMenor*2)+(ladoMaior*2);
    }
    
}
