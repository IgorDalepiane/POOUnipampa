package br.com.locadora.veiculos;

public class Caminhao extends Veiculo {
    private int numEixos;
    private double cargaMax;

    public Caminhao(int numEixos, double cargaMax, String placa, int ano, double valorDiaria) {
        super(placa, ano, valorDiaria);
        this.numEixos = numEixos;
        this.cargaMax = cargaMax;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Numero de Eixos: " + numEixos +
                " | Carga Máxima: " + cargaMax + "kg";
    }
}