/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.veiculos;

public abstract class Veiculo {
    private String placa;
    private int ano;
    private double valorDiaria;

    public Veiculo(String placa, int ano, double valorDiaria) {
        this.placa = placa;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
    }
    
    @Override
    public String toString() {
        return "Tipo: " + this.getClass().getSimpleName() +
                " | Placa: " + placa +
                " | Ano: " + ano +
                " | Valor da diária: " + valorDiaria +
                "\n";
    }

    String resumo() {
        return "Placa: " + placa +
                " | Valor da diária: " + valorDiaria;
    }

    String getPlaca() {
        return placa;
    }


    public double getValorDiaria() {
        return valorDiaria;
    }

}
