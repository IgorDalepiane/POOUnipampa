/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.locacoes;

import br.com.locadora.clientes.Cliente;
import br.com.locadora.veiculos.Veiculo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Locacao {
    private int cod = 1;
    private Cliente c;
    private Veiculo v;
    private boolean seguro;
    private double diaria;
    private Date dataInicio, dataFim;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");

    public Locacao(Cliente c,
                   Veiculo v,
                   boolean seguro,
                   Date dataInicio,
                   Date dataFim) {
        this.cod = cod++;
        this.c = c;
        this.v = v;
        this.seguro = seguro;
        this.diaria = v.getValorDiaria();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    @Override
    public String toString() {
        return "Código: " + this.cod +
                "\n | Cliente: " + this.c.toString() +
                "\n | Veículo: " + this.v.toString() +
                "\n | Seguro: " + (this.seguro ? "Sim" : "Não") +
                " | Diária: " + this.diaria +
                " | Data de início: " + sdf.format(this.dataInicio) +
                " | Data de término: " + sdf.format(this.dataFim);
    }

    public int getCod() {
        return cod;
    }
}
