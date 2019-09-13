package br.com.locadora.locacoes;

import java.util.ArrayList;
import java.util.List;

public class Locacoes implements ILocacoes {
    private List<Locacao> list;

    public Locacoes() {
        list = new ArrayList<>();
    }

    List<Locacao> getList() {
        return list;
    }

    @Override
    public void add(Locacao l) {
        list.add(l);
    }

    @Override
    public Locacao get(int codigo) {
        return list.stream()
                .filter(loc -> loc.getCod() == codigo)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String getInfo(int codigo) {
        Locacao loc = get(codigo);
        if (loc != null)
            return loc.toString();
        return null;
    }

    @Override
    public String getInfo() {
        String str = "";
        if (!list.isEmpty()) {
            for (Locacao loc : list)
                str = str.concat(String.valueOf(list.indexOf(loc)))
                        .concat(". ")
                        .concat(loc.toString())
                        .concat("\n");
            return str;
        } else return null;
    }

    @Override
    public boolean set(int codigo, Locacao l) {
        try {
            int objIndex = list.indexOf(get(codigo));
            list.set(objIndex, l);
        } catch (NullPointerException npe) {
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(int codigo) {
        return list.remove(get(codigo));
    }

    @Override
    public boolean existe(int codigo) {
        return get(codigo) != null;
    }
}
