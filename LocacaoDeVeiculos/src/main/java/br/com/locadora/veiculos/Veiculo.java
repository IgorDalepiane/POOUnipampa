/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.veiculos;

import java.util.ArrayList;

/**
 *
 * @author 1801560700
 */
public class Veiculo implements IVeiculos{
    protected String placa;
    protected int ano;
    protected double valorDiaria;
    private ArrayList<Veiculo> veiculos = new ArrayList<>();

    public Veiculo(String placa, int ano, double valorDiaria) {
        this.placa = placa;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
        
        
    }
    @Override
    public void add(Veiculo v) {
        veiculos.add(v);
    }

    @Override
    public Veiculo get(String placa) {
        for(Veiculo v: veiculos){
            if(v.placa.equals(placa)){
                return v;
            }
        }
        return null;
    }

    @Override
    public String getInfo(String placa) {
        Veiculo v = get(placa);
        if(v!=null){
            return "Placa: "+this.placa+" | Ano: "+this.ano+" | Valor da Diaria: "+this.valorDiaria+" | ";
        }
        return null;
    }

    @Override
    public String getInfo() {
        String str=null;
        if(veiculos.get(0) != null){
           for(Veiculo v:veiculos){
            str += str.concat(v.getInfo(v.placa)+"\n");
           }
           return str;
        }
        return null;
    }

    @Override
    public String getResumoInfo() {
         String str=null;
        if(veiculos.get(0) != null){
           for(Veiculo v:veiculos){
            str += str.concat("Placa: "+v.placa+" | Ano: "+v.ano+" | Valor da Diaria: "+v.valorDiaria+"\n");
           }
           return str;
        }
        return null;
    }

    @Override
    public boolean set(String placa, Veiculo v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(String placa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(String placa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
