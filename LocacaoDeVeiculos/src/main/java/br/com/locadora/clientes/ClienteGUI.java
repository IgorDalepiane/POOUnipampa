package br.com.locadora.clientes;


import java.util.Scanner;

public class ClienteGUI {
    private Clientes clis;
    private Scanner in = new Scanner(System.in);
    private int answer;

    public ClienteGUI(Clientes cs) {
        this.clis = cs;
        do generateMenu(); while (true);
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
        if (!clis.list.isEmpty()) {
            System.out.println("Cliente a ser editado: ");
            System.out.println("(1 - " + (clis.list.size()) + ")");
            listarMenu();
            do {
                answer = in.nextInt() - 1; // indexes start at 0
                in.nextLine();
            } while (answer < 0 || answer > clis.list.size() - 1);
            Cliente old = clis.list.get(answer);
            Cliente novo = formMenu();
            if (novo != null)
                clis.set(old.getCPF(), novo);
        } else
            System.out.println("Nenhum cliente no sistema.");
    }

    private void listarMenu() {
        if (!clis.list.isEmpty())
            System.out.println(clis.getInfo());
        else
            System.out.println("Nenhum cliente no sistema.");
    }

    private void cadastrarMenu() {
        System.out.println("Cadastro de Cliente");
        Cliente form = formMenu();
        if (form != null)
            clis.add(form);
    }

    private Cliente formMenu() {
        try {
            System.out.print("Nome: ");
            String newNome = in.nextLine();
            System.out.print("CPF: ");
            long newCPF = in.nextLong();
            System.out.print("CNH: ");
            long newCNH = in.nextLong();
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
