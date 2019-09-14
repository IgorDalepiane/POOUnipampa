/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.clientes;

public class Cliente {
    private String nome;
    private long CPF;
    private long CNH;
    private long telefone;
    private String endereco;

    public Cliente(String nome, long CPF, long CNH, long telefone, String endereco) {
        this.nome = nome;
        this.CPF = CPF;
        this.CNH = CNH;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome +
                " | CPF: " + this.CPF +
                " | CNH: " + this.CNH +
                " | Telefone: " + this.telefone +
                " | Endereço: " + this.endereco;
    }

    String resumo() {
        return "Nome: " + this.nome +
                " | CPF: " + this.CPF;
    }

    long getCPF() {
        return this.CPF;
    }
}
