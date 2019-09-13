package br.com.locadora.veiculos;

import java.util.Scanner;

public class VeiculosGUI {
    private final Scanner ler = new Scanner(System.in);
    private int op;
    private String placa;
    private int ano;
    private double valorDiaria;
    private Veiculos veiculos;

    private boolean sair = false;

    public VeiculosGUI(Veiculos vs) {
        this.veiculos = vs;
        while (!sair) {
            menu();
        }
    }

    private void menu() {
        do {
            System.out.println("0. Voltar");
            System.out.println("1. Cadastrar veículo");
            System.out.println("2. Listar veículos");
            System.out.println("3. Editar veículo");
            op = ler.nextInt();
            ler.nextLine();
        } while (op < 0 || op > 3);
        switch (op) {
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

    private void cadastrarMenu() {
        do {
            System.out.println("0. Voltar");
            System.out.println("1. Carro");
            System.out.println("2. Ônibus");
            System.out.println("3. Caminhão");
            op = ler.nextInt();
            ler.nextLine();
        } while (op < 0 || op > 3);
        switch (op) {
            case 0:
                menu();
                break;
            case 1:
                cadastrarCarro();
                break;
            case 2:
                cadastrarOnibus();
                break;
            case 3:
                cadastrarCaminhao();
                break;
        }
    }

    //Carros
    private Veiculo formCarro() {
        try {
            int numPassageiros;
            int numPortas;
            double mediaDeKml;
            boolean ac;
            formVeiculo();
            System.out.print("Número de passageiros: ");
            numPassageiros = ler.nextInt();
            ler.nextLine();
            System.out.print("Número de portas: ");
            numPortas = ler.nextInt();
            ler.nextLine();
            System.out.print("Média de km/L: ");
            mediaDeKml = ler.nextDouble();
            System.out.println("O veículo possui ar-condicionado?");
            ac = formYesOrNo();
            return new Carro(numPassageiros,
                    numPortas,
                    mediaDeKml,
                    ac,
                    placa, ano, valorDiaria);
        } catch (NumberFormatException nfe) {
            System.out.println("Algum campo foi preenchido incorretamente.");
            return null;
        }
    }



    private void cadastrarCarro() {
        Veiculo carro = formCarro();
        if (carro != null) {
            veiculos.add(carro);
        }
    }

    //Ônibus
    private Veiculo formOnibus() {
        try {
            int numPassageiros;
            String categoria;
            boolean wifi;
            boolean ac;
            formVeiculo();
            System.out.print("Categoria: ");
            categoria = ler.nextLine();
            System.out.print("Número de passageiros: ");
            numPassageiros = ler.nextInt();
            ler.nextLine();
            System.out.println("O veículo possui Wi-Fi?");
            wifi = formYesOrNo();
            System.out.println("O veículo possui ar-condicionado?");
            ac = formYesOrNo();
            return new Onibus(numPassageiros,
                    categoria,
                    wifi,
                    ac,
                    placa, ano, valorDiaria);
        } catch (NumberFormatException nfe) {
            System.out.println("Algum campo foi preenchido incorretamente.");
            return null;
        }
    }

    private void cadastrarOnibus() {
        Veiculo onibus = formOnibus();
        if (onibus != null) {
            veiculos.add(onibus);
        }
    }

    //Caminhão
    private Veiculo formCaminhao() {
        try {
            int numEixos;
            double cargaMax;
            formVeiculo();
            System.out.print("Número de eixos: ");
            numEixos = ler.nextInt();
            ler.nextLine();
            System.out.print("Carga máxima: ");
            cargaMax = ler.nextDouble();
            return new Caminhao(numEixos, cargaMax, placa, ano, valorDiaria);
        } catch (NumberFormatException nfe) {
            System.out.println("Algum campo foi preenchido incorretamente.");
            return null;
        }
    }

    private void cadastrarCaminhao() {
        Veiculo caminhao = formCaminhao();
        if (caminhao != null) {
            veiculos.add(caminhao);
        }
    }

    //Listar
    private void listarMenu() {
        do {
            System.out.println("0. Voltar.");
            System.out.println("1. Procurar veículo por placa.");
            System.out.println("2. Listar todos os veículos.");
            op = ler.nextInt();
            ler.nextLine();
        } while (op < 0 || op > 3);
        switch (op) {
            case 0:
                menu();
                break;
            case 1:
                listarUmVeiculo();
                break;
            case 2:
                listarTodos();
                break;
        }
    }

    private void listarUmVeiculo() {
        System.out.print("Digite a placa do veículo: ");
        placa = ler.nextLine();
        System.out.println(veiculos.getInfo(placa));
    }

    public void listarTodos() {
        if (!veiculos.getList().isEmpty())
            System.out.print(veiculos.getInfo());
        else
            System.out.println("Nenhum veículo no sistema.");
    }

    //Editar
    private void editarMenu() {
        int indice;
        listarTodos();
        System.out.println("Escolha um dentre os " + veiculos.getList().size() + " veículos para edita-lo.");
        do {
            indice = ler.nextInt();
            ler.nextLine();
        } while (indice < 0 || indice >= veiculos.getList().size());
        Veiculo v = veiculos.getList().get(indice);
        if (v instanceof Carro) {
            Veiculo carro = formCarro();
            if (carro != null) {
                veiculos.set(v.getPlaca(), carro);
            }
        } else if (v instanceof Onibus) {
            Veiculo onibus = formOnibus();
            if (onibus != null) {
                veiculos.set(v.getPlaca(), onibus);
            }
        } else if (v instanceof Caminhao) {
            Veiculo caminhao = formCaminhao();
            if (caminhao != null) {
                veiculos.set(v.getPlaca(), caminhao);
            }
        }
    }

    //Utilidades
    private boolean formYesOrNo() {
        int op;
        System.out.println("1. Sim");
        System.out.println("2. Não");
        System.out.print("Sua escolha: ");
        do {
            op = ler.nextInt();
        } while (op < 1 || op > 2);
        return op == 1;
    }

    private void formVeiculo() {
        do {
            System.out.print("Placa: ");
            placa = ler.nextLine();
            if (veiculos.get(placa) != null) {
                System.out.println("Já existe um veículo com esta placa.");
                continue;
            }
            break;
        } while (true);
        System.out.print("Ano: ");
        ano = ler.nextInt();
        ler.nextLine();
        System.out.print("Valor da diária: ");
        valorDiaria = ler.nextDouble();
        ler.nextLine();
    }
}
