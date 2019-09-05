/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.clientes;

import java.util.ArrayList;

/**
 * @author 1801560700
 */
public class Cliente implements IClientes {
    private String nome;
    long CPF;
    private long CNH;
    private long telefone;
    private String endereco;

    static ArrayList<Cliente> clientes = new ArrayList<>();

    public Cliente(String nome, long CPF, long CNH, long telefone, String endereco) {
        this.nome = nome;
        this.CPF = CPF;
        this.CNH = CNH;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    @Override
    public void add(Cliente c) {
        clientes.add(c);
    }

    @Override
    public Cliente get(long CPF) {
        for (Cliente c : clientes) {
            if (c.CPF == CPF)
                return this;
        }
        return null;
    }

    @Override
    public String getInfo(long CPF) {
        Cliente c = get(CPF);
        if (c != null)
            return "Nome: " + c.nome
                    + " | CPF: " + c.CPF
                    + " | CNH: " + c.CNH
                    + " | Telefone: " + c.telefone
                    + " | Endereço: " + c.endereco;

        return null;
    }

    @Override
    public String getInfo() {
        StringBuilder all = new StringBuilder();
        if (clientes.get(0) != null) {
            for (Cliente c : clientes)
                all.append(getInfo(c.CPF)).append("\n");
            return all.toString();
        } else return null;
    }

    @Override
    public String getResumoInfo() {
        StringBuilder all = new StringBuilder();
        if (clientes.get(0) != null) {
            for (Cliente c : clientes)
                all.append("Nome: ").append(c.nome).append(" | CPF: ").append(c.CPF).append("\n");
            return all.toString();
        } else return null;
    }

    @Override
    public boolean set(long CPF, Cliente novo) {
        try {
            int objIndex = clientes.indexOf(get(CPF));
            Cliente velho = clientes.get(objIndex);

            velho.nome = novo.nome;
            velho.CPF = novo.CPF;
            velho.CNH = novo.CNH;
            velho.telefone = novo.telefone;
            velho.endereco = novo.endereco;

            clientes.set(objIndex, velho);
        } catch (NullPointerException npe) {
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(long CPF) {
        return clientes.remove(get(CPF));
    }

    @Override
    public boolean existe(long CPF) {
        return get(CPF) != null;
    }

}
