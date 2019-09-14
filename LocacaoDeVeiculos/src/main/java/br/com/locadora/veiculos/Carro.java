package br.com.locadora.veiculos;

public class Carro extends Veiculo {
    private int numPassageiros;
    private int numPortas;
    private double mediaDeKmL;
    private boolean arCondicionado;

    public Carro(int numPassageiros,
          int numPortas,
          double mediaDeKmL,
          boolean arCondicionado,
          String placa, int ano, double valorDiaria) {
        super(placa, ano, valorDiaria);
        this.numPassageiros = numPassageiros;
        this.numPortas = numPortas;
        this.mediaDeKmL = mediaDeKmL;
        this.arCondicionado = arCondicionado;
    }

    private boolean hasAC() {
        return arCondicionado;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Numero de passageiros: " + numPassageiros +
                " | Numero de portas: " + numPortas +
                " | Média de km/L: " + mediaDeKmL +
                " | Ar-condicionado: " + (hasAC() ? "Sim" : "Não");
    }
}