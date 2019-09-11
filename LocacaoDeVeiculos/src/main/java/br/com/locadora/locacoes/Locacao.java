/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.locacoes;

import br.com.locadora.clientes.Cliente;
import br.com.locadora.veiculos.Veiculo;

import java.util.Date;

/**
 * @author 1801560700
 */
public class Locacao {
    private int cod = 1;
    private Cliente c;
    private Veiculo v;
    private boolean seguro;
    private double diaria;
    private Date dataInicio;
    private Date dataFim;

    public int getCod() {
        return cod;
    }

    public Locacao(Cliente c, Veiculo v, boolean seguro, Date dataInicio, Date dataFim) {
        this.cod = cod++;
        this.c = c;
        this.v = v;
        this.seguro = seguro;
        this.diaria = v.getValorDiaria();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public String toString() {
        return "Código: " + this.cod +
                " | Cliente: " + this.c.toString() +
                " | Veículo: " + this.v.toString() +
                " | Seguro: " + (this.seguro ? "Sim" : "Não") +
                " | Diária: " + this.diaria +
                " | Data de início: " + this.dataInicio.toString() +
                " | Data de término: " + this.dataFim.toString();
    }
}
