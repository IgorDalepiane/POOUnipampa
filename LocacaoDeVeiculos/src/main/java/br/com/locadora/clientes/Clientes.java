package br.com.locadora.clientes;

import java.util.ArrayList;
import java.util.List;

public class Clientes implements IClientes {
    private List<Cliente> list;

    public Clientes() {
        this.list = new ArrayList<>();
    }

    public List<Cliente> getList() {
        return list;
    }

    @Override
    public void add(Cliente c) {
        list.add(c);
    }

    @Override
    public Cliente get(long CPF) {
        return list.stream()
                .filter(c -> c.getCPF() == CPF)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String getInfo(long CPF) {
        Cliente c = get(CPF);
        if (c != null)
            return c.toString();
        return null;
    }

    @Override
    public String getInfo() {
        String str = "";
        if (!list.isEmpty()) {
            for (Cliente c : list)
                str = str.concat(String.valueOf(list.indexOf(c)))
                        .concat(". ")
                        .concat(c.toString())
                        .concat("\n");
            return str;
        } else return null;
    }

    @Override
    public String getResumoInfo() {
        String str = "";
        if (!list.isEmpty()) {
            for (Cliente c : list)
                str = str.concat(c.resumo())
                        .concat("\n");
            return str;
        } else return null;
    }

    @Override
    public boolean set(long CPF, Cliente novo) {
        try {
            int objIndex = list.indexOf(get(CPF));
            list.set(objIndex, novo);
        } catch (NullPointerException npe) {
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(long CPF) {
        return list.remove(get(CPF));
    }

    @Override
    public boolean existe(long CPF) {
        return get(CPF) != null;
    }
}
