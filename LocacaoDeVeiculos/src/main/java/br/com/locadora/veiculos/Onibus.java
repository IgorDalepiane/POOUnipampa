package br.com.locadora.veiculos;

public class Onibus extends Veiculo {
    private int numPassageiros;
    private String categoria;
    private boolean wiFi, ac;

    public Onibus(int numPassageiros,
                  String categoria,
                  boolean wiFi,
                  boolean ac,
                  String placa, int ano, double valorDiaria) {
        super(placa, ano, valorDiaria);
        this.numPassageiros = numPassageiros;
        this.categoria = categoria;
        this.wiFi = wiFi;
        this.ac = ac;
    }

    private boolean hasWiFi() {
        return wiFi;
    }

    private boolean hasAC() {
        return ac;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Numero de passageiros: " + numPassageiros +
                " | Categoria: " + categoria +
                " | Wi-Fi: " + (hasWiFi() ? "Sim" : "Não") +
                " | Ar-Condicionado: " + (hasAC() ? "Sim" : "Não");
    }
}