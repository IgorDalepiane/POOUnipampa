package br.com.locadora.clientes;

import java.util.ArrayList;
import java.util.List;

public class Clientes implements IClientes{
    List<Cliente> list;

    public Clientes() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(Cliente c) {
        list.add(c);
    }

    @Override
    public Cliente get(long CPF) {
        return list.stream()
                .filter(clienteNaLista -> clienteNaLista.CPF == CPF)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String getInfo(long CPF) {
        Cliente c = get(CPF);
        if (c != null)
            return "Nome: " + c.nome +
                    " | CPF: " + c.CPF +
                    " | Telefone: " + c.telefone +
                    " | CNH: " + c.CNH +
                    " | Endereço: " + c.endereco;
        return null;
    }

    @Override
    public String getInfo() {
        String str = "";
        if (!list.isEmpty()) {
            for (Cliente c : list)
                str = str.concat(getInfo(c.CPF)).concat("\n");
            return str;
        }
        return null;
    }

    @Override
    public String getResumoInfo() {
        StringBuilder all = new StringBuilder();
        if (list.get(0) != null) {
            for (Cliente c : list)
                all.append("Nome: ").append(c.nome).append(" | CPF: ").append(c.CPF).append("\n");
            return all.toString();
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
