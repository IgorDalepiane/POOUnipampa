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

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public void setNumPassageiros(int numPassageiros) {
        this.numPassageiros = numPassageiros;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isWiFi() {
        return wiFi;
    }

    public void setWiFi(boolean wiFi) {
        this.wiFi = wiFi;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public String toString() {
        String ar,wi;
        if(isArCondicionado()){
            ar="possui";
        }else{
            ar="não possui"; 
        }
        if(isWiFi()){
            wi="possui";
        }else{
            wi="não possui"; 
        }
        return "Onibus com " +super.toString()+", Numero de Passageiros = " + numPassageiros + ", Categoria = " + categoria + ", Wi-Fi = " + wi + ", Ar-Condicionado = " + ar;
    }
    
   
   
    
}
