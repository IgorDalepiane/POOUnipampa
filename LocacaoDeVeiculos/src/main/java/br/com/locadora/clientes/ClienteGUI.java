package br.com.locadora.clientes;


import java.util.Scanner;

public class ClienteGUI {
    private Scanner in = new Scanner(System.in);
    private int answer;

    private String newNome;
    private long newCPF;
    private long newCNH;
    private long newTel;
    private String newEnd;

    public ClienteGUI() {
        do {
            generateMenu();
        } while (true);
    }

    private void generateMenu() {
        do {
            System.out.println("0. Sair");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar");
            System.out.println("3. Editar");
            answer = in.nextInt();
            in.nextLine();
        } while (answer < 0 || answer > 3);
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
        }
    }

    private void editarMenu() {
        if(!Cliente.clientes.isEmpty()) {
            System.out.println("Cliente a ser editado: ");
            System.out.println("(0 - " + (Cliente.clientes.size() - 1) + ")");
            listarMenu();
            do {
                answer = in.nextInt();
                in.nextLine();
            } while (answer < 0 || answer > Cliente.clientes.size() - 1);
            Cliente old = Cliente.clientes.get(answer);
            formMenu();
            old.set(old.CPF, new Cliente(newNome, newCPF, newCNH, newTel, newEnd));
        } else
            System.out.println("Nenhum cliente no sistema.");
    }

    private void listarMenu() {
        if (Cliente.clientes != null)
            System.out.println(Cliente.clientes.get(0).getInfo());
    }

    private void cadastrarMenu() {
        System.out.println("Cadastro de Cliente");
        formMenu();
        try {
            Cliente c = new Cliente(newNome, newCPF, newCNH, newTel, newEnd);
            c.add(c);
        } catch (NumberFormatException nfe) {
            System.out.println("Erro: algum campo numérico recebeu caracteres literais.");
        }
    }

    private void formMenu() {
        System.out.print("Nome: ");
        newNome = in.nextLine();
        System.out.print("CPF: ");
        newCPF = in.nextLong();
        System.out.print("CNH: ");
        newCNH = in.nextLong();
        System.out.print("Telefone: ");
        newTel = in.nextLong();
        in.nextLine();
        System.out.print("Endereço: ");
        newEnd = in.nextLine();
    }
}
