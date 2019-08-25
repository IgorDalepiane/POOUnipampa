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
    protected String nome;
    protected long CPF;
    protected long CNH;
    protected long telefone;
    protected String endereco;

    private ArrayList<Cliente> clientes = new ArrayList<>();

    public Cliente(String nome, long CPF, long CNH, long telefone, String endereco) {
        this.nome = nome;
        this.CPF = CPF;
        this.CNH = CNH;
        this.telefone = telefone;
        this.endereco = endereco;
        //adiciona o cliente novo à lista
        add(this);
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
                    + " | Endereço: " + c.endereco
                    + " | Telefone: " + c.telefone
                    + " | CNH: " + c.CNH;
        return null;
    }

    @Override
    public String getInfo() {
        String all = "";
        if (clientes.get(0) != null)
            for (Cliente c : clientes)
                all += getInfo(c.CPF);
        return all;
    }

    @Override
    public String getResumoInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean set(long CPF, Cliente c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(long CPF) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(long CPF) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
