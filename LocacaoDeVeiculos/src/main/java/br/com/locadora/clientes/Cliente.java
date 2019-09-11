/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.clientes;

public class Cliente {
    String nome;
    long CPF;
    long CNH;
    long telefone;
    String endereco;

    public Cliente(String nome, long CPF, long CNH, long telefone, String endereco) {
        this.nome = nome;
        this.CPF = CPF;
        this.CNH = CNH;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String toString() {
        return this.nome + " | " +
                this.CPF + " | " +
                this.CNH + " | " +
                this.telefone + " | " +
                this.endereco;
    }
}
