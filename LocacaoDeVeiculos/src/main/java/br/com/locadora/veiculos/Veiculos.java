/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.veiculos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1801560700
 */
public class Veiculos implements IVeiculos {

    List<Veiculo> list = new ArrayList<>();

    @Override
    public void add(Veiculo v) {
        list.add(v);
    }

    @Override
    public Veiculo get(String placa) {
        for (Veiculo v : list) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }
        return null;
    }

    @Override
    public String getInfo(String placa) {
        Veiculo v = get(placa);
        if (v != null) {
            return v.toString();
        }
        return null;
    }

    @Override
    public String getInfo() {
        String str = "";
        int cont = 1;
        if (!list.isEmpty()) {
            for (Veiculo v : list) {
                str = str.concat(cont + ") " + getInfo(v.getPlaca()) + "\n");
                cont++;
            }
            return str;
        }
        return null;
    }

    @Override
    public String getResumoInfo() {
        String str = null;
        if (!list.isEmpty()) {
            for (Veiculo v : list) {
                str = str.concat("Placa: " + v.getPlaca() + " | Ano: " + v.getAno() + " | Valor da Diaria: " + v.getValorDiaria() + "\n");
            }
            return str;
        }
        return null;
    }

    @Override
    public boolean set(String placa, Veiculo novo) {
        Veiculo velho = get(placa);
        if (velho != null) {
            int objIndex = list.indexOf(velho);
            list.set(objIndex, novo);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String placa) {
        Veiculo veiculo = get(placa);
        if (veiculo != null) {
            list.remove(veiculo);
            return true;
        }
        return false;
    }

    @Override
    public boolean existe(String placa) {
        Veiculo veiculo = get(placa);
        return veiculo != null;
    }

}
