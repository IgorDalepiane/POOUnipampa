package br.com.locadora.clientes;

import java.util.Scanner;

public class ClienteGUI {
    private Clientes clientes;
    private Scanner in = new Scanner(System.in);
    private int answer;
    private boolean sair = false;

    public ClienteGUI(Clientes cs) {
        this.clientes = cs;
        while (!sair) {
            generateMenu();
        }
    }

    private void generateMenu() {
        do {
            System.out.println("0. Voltar");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Listar cliente");
            System.out.println("3. Editar cliente");
            answer = in.nextInt();
            in.nextLine();
        } while (answer < 0 || answer > 3);
        switch (answer) {
            case 0:
                sair = true;
                break;
            case 1:
                cadastrarMenu();
                break;
            case 2:
                listarMenu();
                break;
            case 3:
                editarMenu();
                break;
        }
    }

    private void editarMenu() {
        if (!clientes.getList().isEmpty()) {
            System.out.println("Cliente a ser editado: ");
            listarTodos();
            do {
                answer = in.nextInt();
                in.nextLine();
            } while (answer < 0 || answer > clientes.getList().size() - 1);
            Cliente velho = clientes.getList().get(answer);
            Cliente novo = formMenu();
            if (novo != null)
                clientes.set(velho.getCPF(), novo);
        } else
            System.out.println("Nenhum cliente no sistema.");
    }
    /*Listar*/
    private void listarMenu() {
        do {
            System.out.println("0. Voltar");
            System.out.println("1. Procurar por CPF");
            System.out.println("2. Listar todos");
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
        System.out.print("CPF: ");
        System.out.println(clientes.getInfo(in.nextLong()));
    }

    public void listarTodos() {
        if (!clientes.getList().isEmpty())
            System.out.print(clientes.getInfo());
        else
            System.out.println("Nenhum cliente no sistema.");
    }
    /*.Listar*/

    private void cadastrarMenu() {
        System.out.println("Cadastro de Cliente");
        Cliente form = formMenu();
        if (form != null)
            clientes.add(form);
    }

    private Cliente formMenu() {
        long newCPF;
        long newCNH;
        try {
            System.out.print("Nome: ");
            String newNome = in.nextLine();
            do {
                System.out.print("CPF: ");
                newCPF = in.nextLong();
                if (clientes.get(newCPF) != null) {
                    System.out.println("Já existe um cliente com este CPF.");
                    continue;
                }
                break;
            } while(true);
            do {
                System.out.print("CNH: ");
                newCNH = in.nextLong();
                if (clientes.get(newCNH) != null) {
                    System.out.println("Já existe um cliente com esta CNH.");
                    continue;
                }
                break;
            } while(true);
            System.out.print("Telefone: ");
            long newTel = in.nextLong();
            in.nextLine();
            System.out.print("Endereço: ");
            String newEnd = in.nextLine();
            return new Cliente(newNome, newCPF, newCNH, newTel, newEnd);
        } catch (NumberFormatException nfe) {
            System.out.println("Erro: algum campo numérico recebeu caracteres literais.");
            return null;
        }
    }
}