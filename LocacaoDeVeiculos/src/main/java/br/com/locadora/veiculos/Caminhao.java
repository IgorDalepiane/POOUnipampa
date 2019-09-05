/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.veiculos;

/**
 *
 * @author 1801560700
 */
public class Caminhao extends Veiculo{
    private int numEixos;
    private double cargaMax;

    public Caminhao(int numEixos, double cargaMax, String placa, int ano, double valorDiaria) {
        super(placa, ano, valorDiaria);
        this.numEixos = numEixos;
        this.cargaMax = cargaMax;
    }

    public int getNumEixos() {
        return numEixos;
    }

    public void setNumEixos(int numEixos) {
        this.numEixos = numEixos;
    }

    public double getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(double cargaMax) {
        this.cargaMax = cargaMax;
    }

    @Override
    public String toString() {
        return "Caminhao com "+super.toString()+", Numero de Eixos = " + numEixos + ", Carga Máxima = " + cargaMax+" Kg";
    }
    
    
}
