/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author 1801560700
 */
public class Cliente {
    private String nome;
    private double CPF;

    public Cliente(String nome, double CPF) {
        this.nome = nome;
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCPF() {
        return CPF;
    }

    public void setCPF(double CPF) {
        this.CPF = CPF;
    }
    
    @Override
    public String toString() {
        return "Cliente " + nome + ", CPF=" + CPF;
    }
    
    
}
