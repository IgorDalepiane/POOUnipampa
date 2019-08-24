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
public class Onibus extends Veiculo{
    private int numPassageiros;
    private String categoria;
    private boolean wiFi;
    private boolean arCondicionado;

    public Onibus(int numPassageiros, String categoria, boolean wiFi, boolean arCondicionado, String placa, int ano, double valorDiaria) {
        super(placa, ano, valorDiaria);
        this.numPassageiros = numPassageiros;
        this.categoria = categoria;
        this.wiFi = wiFi;
        this.arCondicionado = arCondicionado;
    }

   
    
}
