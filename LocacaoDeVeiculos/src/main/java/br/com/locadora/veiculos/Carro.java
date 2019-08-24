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
public class Carro extends Veiculo{
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

    @Override
    public String getInfo(String placa) {
        String imprime;
        if(this.arCondicionado==true){
            imprime="Possui";
        }else{
            imprime="Não possui";
        }
        return super.getInfo(placa)+"Numero de Passageiros: "+this.numPassageiros+" | Numero de Portas: "+this.numPortas+" | Media de Km/L: "+this.mediaDeKmL+" | Ar-Condicionado: "+imprime; 
    }
    
    
}
