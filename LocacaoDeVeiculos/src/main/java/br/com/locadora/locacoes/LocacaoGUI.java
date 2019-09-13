package br.com.locadora.locacoes;

import br.com.locadora.clientes.Cliente;
import br.com.locadora.clientes.ClienteGUI;
import br.com.locadora.clientes.Clientes;
import br.com.locadora.veiculos.Veiculo;
import br.com.locadora.veiculos.Veiculos;
import br.com.locadora.veiculos.VeiculosGUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LocacaoGUI {
    private Scanner in = new Scanner(System.in);
    private Locacoes locacoes;
    private Clientes clientes;
    private Veiculos veiculos;

    private ClienteGUI cGUI; // necessário para listar os objetos ao inserir a locação
    private VeiculosGUI vGUI;

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
            System.out.println("2. Listar locações");
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
                cGUI = new ClienteGUI(clientes);
                break;
            case 5:
                vGUI = new VeiculosGUI(veiculos);
                break;
        }
    }

    private void editarMenu() {
        if (!locacoes.getList().isEmpty()) {
            System.out.println("Locação a ser editada: ");
            listarTodos();
            do {
                answer = in.nextInt();
                in.nextLine();
            } while (answer < 0 || answer > locacoes.getList().size() - 1); //index
            Locacao velho = locacoes.getList().get(answer);
            Locacao novo = formMenu();
            locacoes.set(velho.getCod(), novo);
        } else
            System.out.println("Nenhuma locação no sistema.");
    }

    //Listar
    private void listarMenu() {
        do {
            System.out.println("0. Voltar");
            System.out.println("1. Procurar por código");
            System.out.println("2. Listar todas");
            answer = in.nextInt();
            in.nextLine();
        } while (answer < 0 || answer > 2);
        switch (answer) {
            case 0:
                generateMenu();
                break;
            case 1:
                listarUm();
                break;
            case 2:
                listarTodos();
                break;
        }
    }

    private void listarUm() {
        System.out.print("Código: ");
        System.out.println(locacoes.getInfo(in.nextInt()));
    }

    private void listarTodos() {
        if (!locacoes.getList().isEmpty())
            System.out.println(locacoes.getInfo());
        else
            System.out.println("Nenhuma locação no sistema.");
    }

    //.Listar
    private Locacao formMenu() {
        Cliente c;
        Veiculo v;
        boolean seguro;
        Date dataIn;
        Date dataTe;
        System.out.println("Selecione o cliente: "); //cliente
        try {
            cGUI.listarTodos();
        } catch (NullPointerException npe) {
            System.out.println("Nenhum cliente no sistema.");
            generateMenu();
        }
        do {
            answer = in.nextInt();
            in.nextLine();
        } while (answer < 0 || answer > clientes.getList().size() - 1);
        c = clientes.getList().get(answer);
        System.out.println("Selecione o veículo: "); //veiculo
        try {
            vGUI.listarTodos();
        } catch (NullPointerException npe) {
            System.out.println("Nenhum veículo no sistema.");
            generateMenu();
        }
        do {
            answer = in.nextInt();
            in.nextLine();
        } while (answer < 0 || answer > veiculos.getList().size() - 1);
        v = veiculos.getList().get(answer);
        System.out.print("Você quer seguro? [s][n]"); //seguro
        do {
            answer = Character.toUpperCase(in.next().charAt(0));
            if (answer == 'S') {
                seguro = true;
                break;
            } else if (answer == 'N') {
                seguro = false;
                break;
            }
        } while (true);
        in.nextLine();
        System.out.print("Data de início: [dd/mm/yy][hoje]"); //data início
        do {
            String resposta = in.nextLine();
            if (resposta.equals("hoje")) {
                dataIn = new Date();
                break;
            } else
                try {
                    dataIn = new SimpleDateFormat("dd/mm/yy").parse(resposta);
                    break;
                } catch (ParseException e) {
                    System.out.println("Erro: a data inserida não está no formato exigido.");
                }
        } while (true);
        System.out.print("Data de término: [dd/mm/yy]"); //data fim
        do {
            try {
                dataTe = new SimpleDateFormat("dd/mm/yy").parse(in.nextLine());
                break;
            } catch (ParseException e) {
                System.out.println("Erro: a data inserida não está no formato exigido.");
            }
        } while (true);
        return new Locacao(c, v, seguro, dataIn, dataTe);
    }

    private void cadastrarMenu() {
        Locacao form = formMenu();
        locacoes.add(form);
    }
}