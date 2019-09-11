package br.com.locadora.locacoes;

import java.util.ArrayList;
import java.util.List;

public class Locacoes implements ILocacoes {
    List<Locacao> list;

    public Locacoes() {
        list = new ArrayList<>();
    }

    @Override
    public void add(Locacao l) {
        list.add(l);
    }

    @Override
    public Locacao get(int codigo) {
        return list.stream()
                .filter(loc -> loc.cod == codigo)
                .findAny()
                .orElse(null);
    }

    @Override
    public String getInfo(int codigo) {
        Locacao loc = get(codigo);
        if (loc != null)
            return "Código: " + loc.cod +
                    " | Cliente: " + loc.c.toString() +
                    " | Veículo: " + loc.v.toString() +
                    " | Seguro: " + (loc.seguro ? "Sim" : "Não") +
                    " | Diária: " + loc.diaria +
                    " | Data de início: " + loc.dataInicio.toString() +
                    " | Data de término: " + loc.dataFim.toString();
        return null;
    }

    @Override
    public String getInfo() {
        String str = "";
        if (!list.isEmpty()) {
            for (Locacao loc : list)
                str = str.concat(getInfo(loc.cod)).concat("\n");
            return str;
        }
        return null;
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
