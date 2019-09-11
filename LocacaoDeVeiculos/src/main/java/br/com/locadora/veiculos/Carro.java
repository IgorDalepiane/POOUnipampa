/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.veiculos;

/**
 * @author 1801560700
 */
public class Carro extends Veiculo {
    private int numPassageiros;
    private int numPortas;
    private double mediaDeKmL;
    private boolean arCondicionado;

    public Carro(int numPassageiros, int numPortas, double mediaDeKmL, boolean arCondicionado, String placa, int ano, double valorDiaria) {
        super(placa, ano, valorDiaria);
        this.numPassageiros = numPassageiros;
        this.numPortas = numPortas;
        this.mediaDeKmL = mediaDeKmL;
        this.arCondicionado = arCondicionado;
    }

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public void setNumPassageiros(int numPassageiros) {
        this.numPassageiros = numPassageiros;
    }

    public int getNumPortas() {
        return numPortas;
    }

    public void setNumPortas(int numPortas) {
        this.numPortas = numPortas;
    }

    public double getMediaDeKmL() {
        return mediaDeKmL;
    }

    public void setMediaDeKmL(double mediaDeKmL) {
        this.mediaDeKmL = mediaDeKmL;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public String toString() {
        return "Carro com " + super.toString() +
                ", Numero de Passageiros = " + numPassageiros +
                ", Numero de Portas = " + numPortas +
                ", Media de KM/L = " + mediaDeKmL +
                ", Ar-Condicionado = " + (isArCondicionado() ? "Sim" : "Não");
    }


}
