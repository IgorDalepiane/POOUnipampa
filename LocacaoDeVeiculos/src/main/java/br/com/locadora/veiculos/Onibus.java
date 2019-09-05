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
public class Onibus extends Veiculos{
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
    
    @Override
    public String getInfo(String placa) {
        String ar;
        if(this.arCondicionado==true){
            ar="Possui";
        }else{
            ar="Não possui";
        }
        
        String wifi;
        if(this.wiFi==true){
            wifi="Possui";
        }else{
            wifi="Não possui";
        }
        return super.getInfo(placa)+"Numero de Passageiros: "+this.numPassageiros+" | Categoria: "+this.categoria+" | Wi-Fi: "+wifi+" | Ar-Condicionado: "+ar; 
    }
   
    
}
