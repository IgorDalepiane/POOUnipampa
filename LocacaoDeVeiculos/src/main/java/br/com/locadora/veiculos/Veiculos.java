package br.com.locadora.veiculos;

import java.util.ArrayList;
import java.util.List;

public class Veiculos implements IVeiculos {
    private List<Veiculo> list;

    public Veiculos() {
        this.list = new ArrayList<>();
    }

    public List<Veiculo> getList() {
        return list;
    }

    @Override
    public void add(Veiculo v) {
        list.add(v);
    }

    @Override
    public Veiculo get(String placa) {
        return list.stream()
                .filter(v -> v.getPlaca().equals(placa))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String getInfo(String placa) {
        Veiculo v = get(placa);
        if (v != null)
            return v.toString();
        return null;
    }

    @Override
    public String getInfo() {
        String str = "";
        if (!list.isEmpty()) {
            for (Veiculo v : list)
                str = str.concat(String.valueOf(list.indexOf(v)))
                        .concat(". ")
                        .concat(v.toString())
                        .concat("\n");
            return str;
        }
        return null;
    }

    @Override
    public String getResumoInfo() {
        String str = "";
        if (!list.isEmpty()) {
            for (Veiculo v : list) {
                str = str.concat(v.resumo())
                        .concat("\n");
            }
            return str;
        } else return null;
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
        return list.remove(get(placa));
    }

    @Override
    public boolean existe(String placa) {
        return get(placa) != null;
    }

}
