package br.com.locadora.locacoes;

import br.com.locadora.clientes.ClienteGUI;
import br.com.locadora.clientes.Clientes;
import br.com.locadora.veiculos.Veiculos;
import br.com.locadora.veiculos.VeiculosGUI;

import java.util.Scanner;

public class LocacaoGUI {
    private Scanner in = new Scanner(System.in);
    private Locacoes locacoes;
    private Clientes clientes;
    private Veiculos veiculos;
    private int answer;


    public LocacaoGUI(Locacoes lcs, Clientes cs, Veiculos vs) {
        this.locacoes = lcs;
        this.clientes = cs;
        this.veiculos = vs;
        do {
            generateMenu();
        } while (true);
    }

    private void generateMenu() {
        do {
            System.out.println("0. Sair");
            System.out.println("1. Nova locação");
            System.out.println("2. Listar locação");
            System.out.println("3. Editar locação");
            System.out.println("4. Cliente");
            System.out.println("5. Veículo");
            answer = in.nextInt();
            in.nextLine();
        } while (answer < 0 || answer > 5);
        switch (answer) {
            case 0:
                System.exit(0);
            case 1:
                cadastrarMenu();
                break;
            case 2:
                listarMenu();
                break;
            case 3:
                editarMenu();
                break;
            case 4:
                new ClienteGUI(clientes);
                break;
            case 5:
                new VeiculosGUI(veiculos);
                break;
        }
    }

    private void editarMenu() {
    }

    private void listarMenu() {
    }

    private void cadastrarMenu() {

    }

}
