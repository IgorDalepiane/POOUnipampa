/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora;

import br.com.locadora.clientes.Cliente;
import br.com.locadora.clientes.ClienteGUI;
import br.com.locadora.clientes.Clientes;
import br.com.locadora.locacoes.Locacao;
import br.com.locadora.locacoes.Locacoes;
import br.com.locadora.veiculos.Onibus;
import br.com.locadora.veiculos.Veiculo;
import br.com.locadora.veiculos.Veiculos;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
/**
 * @author 1801560700
 */
public class LocadoraMain {
    public static void main(String[] args) throws ParseException {
        Clientes cs = new Clientes();
        Veiculos vs = new Veiculos();
        Locacoes lcs = new Locacoes();

        Cliente c1 = new Cliente("Pedro", 11111111, 111111111, 1111, "abc");
        Veiculo v1 = new Onibus(4, "tri", true, true, "1", 1, 5.00);

        Date inicio = new Date();
        Date fim = DateFormat.getDateInstance().parse("21/12/2035");
        Locacao loc1 = new Locacao(c1, v1, true, inicio, fim);

        lcs.add(loc1);
        System.out.println(lcs.getInfo(loc1.getCod()));

        new ClienteGUI(cs);
    }
}
