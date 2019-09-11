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

    Cliente(String nome, long CPF, long CNH, long telefone, String endereco) {
        this.nome = nome;
        this.CPF = CPF;
        this.CNH = CNH;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public Cliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public long getCPF() {
        return CPF;
    }

    public Cliente setCPF(long CPF) {
        this.CPF = CPF;
        return this;
    }

    public long getCNH() {
        return CNH;
    }

    public Cliente setCNH(long CNH) {
        this.CNH = CNH;
        return this;
    }

    public long getTelefone() {
        return telefone;
    }

    public Cliente setTelefone(long telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getEndereco() {
        return endereco;
    }

    public Cliente setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }
}
