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
public class Veiculos implements IVeiculos{
    static ArrayList<Veiculo> veiculos = new ArrayList<>();
    
    public Veiculos(){
        
    }
    @Override
    public void add(Veiculo v) {
        veiculos.add(v);
    }

    @Override
    public Veiculo get(String placa) {
        for(Veiculo v: veiculos){
            if(v.getPlaca().equals(placa)){
                return v;
            }
        }
        return null;
    }

    @Override
    public String getInfo(String placa) {
        Veiculo v = get(placa);
        if(v!=null){
            return "Placa: "+v.placa+" | Ano: "+v.ano+" | Valor da Diaria: R$ "+v.valorDiaria+" | ";
        }
        return null;
    }

    @Override
    public String getInfo() {
        String str="";
        if(veiculos.get(0) != null){
           for(Veiculos v:veiculos){
              str = str.concat(v.getInfo(v.placa)+"\n");
           }
           return str;
        }
        return null;
    }

    @Override
    public String getResumoInfo() {
         String str=null;
        if(veiculos.get(0) != null){
           for(Veiculos v:veiculos){
            str += str.concat("Placa: "+v.placa+" | Ano: "+v.ano+" | Valor da Diaria: "+v.valorDiaria+"\n");
           }
           return str;
        }
        return null;
    }

    @Override
    public boolean set(String placa, Veiculos novo) {
        Veiculos velho = get(placa);
        if(velho!=null){
           int objIndex = veiculos.indexOf(velho);
           veiculos.set(objIndex, novo);
           return true;
        }
        return false; 
    }

    @Override
    public boolean remove(String placa) {
        Veiculos veiculo = get(placa);
        if(veiculo!=null){
           veiculos.remove(veiculo);
           return true;
        }
        return false; 
    }

    @Override
    public boolean existe(String placa) {
        Veiculos veiculo = get(placa);
        return veiculo!=null; 
    }
    
}
