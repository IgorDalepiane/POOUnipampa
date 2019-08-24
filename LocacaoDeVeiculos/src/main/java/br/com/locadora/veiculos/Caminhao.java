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
    
    
}
