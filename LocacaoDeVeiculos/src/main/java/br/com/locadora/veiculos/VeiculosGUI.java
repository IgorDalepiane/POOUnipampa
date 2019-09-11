/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.veiculos;

import java.lang.reflect.Field;
import java.util.Scanner;

/**
 *
 * @author 1801560700
 */
public class VeiculosGUI {

    private final Scanner ler = new Scanner(System.in);
    private int op;
    private String placa;
    private int ano;
    private double valorDiaria;
    private Veiculos veiculos;

    public VeiculosGUI() {
        this.veiculos = new Veiculos();
        do {
            menu();
        } while (true);
    }

    private void menu() {
        do {
            System.out.println("\nMenu Veículos");
            System.out.println("0 - Sair.");
            System.out.println("1 - Cadastrar.");
            System.out.println("2 - Listar.");
            System.out.println("3 - Editar.");
            System.out.print("O que voce deseja fazer: ");
            op = ler.nextInt();
        } while (op < 0 || op > 3);
        switch (op) {
            case 0:
                System.exit(op);
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
            System.out.println("\nVeículos disponíveis");
            System.out.println("0 - Voltar.");
            System.out.println("1 - Carro.");
            System.out.println("2 - Onibus.");
            System.out.println("3 - Caminhão.");
            System.out.print("Qual veículo você deseja cadastrar: ");
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

    private void cadastrarCarro() {
        int numPassageiros;
        int numPortas;
        double mediaDeKml;
        boolean arCondicionado;
        int opAr;
        System.out.print("Placa: ");
        placa = ler.nextLine();
        System.out.print("Ano: ");
        ano = ler.nextInt();
        ler.nextLine();
        System.out.print("Valor da diaria: ");
        valorDiaria = ler.nextDouble();
        System.out.print("Numero de passageiros: ");
        numPassageiros = ler.nextInt();
        ler.nextLine();
        System.out.print("Numero de portas: ");
        numPortas = ler.nextInt();
        ler.nextLine();
        System.out.print("Media de Km/l: ");
        mediaDeKml = ler.nextDouble();
        System.out.println("O carro possui ar-condicionado?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        System.out.print("Sua escolha: ");
        do {
            opAr = ler.nextInt();
        } while (opAr < 1 || opAr > 2);
        arCondicionado = opAr == 1;
        Carro carro = new Carro(numPassageiros, numPortas, mediaDeKml, arCondicionado, placa, ano, valorDiaria);
        veiculos.add(carro);
    }

    private void cadastrarOnibus() {
        int numPassageiros;
        String categoria;
        boolean wifi;
        boolean arCondicionado;
        int opAr, opWifi;
        System.out.print("Placa: ");
        placa = ler.nextLine();
        System.out.print("Ano: ");
        ano = ler.nextInt();
        ler.nextLine();
        System.out.print("Valor da diaria: ");
        valorDiaria = ler.nextDouble();
        ler.nextLine();
        System.out.print("Categoria: ");
        categoria = ler.nextLine();
        System.out.print("Numero de passageiros: ");
        numPassageiros = ler.nextInt();
        ler.nextLine();
        System.out.println("O carro possui wi-fi?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        System.out.print("Sua escolha: ");
        do {
            opWifi = ler.nextInt();
        } while (opWifi < 1 || opWifi > 2);
        wifi = opWifi == 1;
        System.out.println("O carro possui ar-condicionado?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        System.out.print("Sua escolha: ");
        do {
            opAr = ler.nextInt();
        } while (opAr < 1 || opAr > 2);
        arCondicionado = opAr == 1;
        Veiculo onibus = new Onibus(numPassageiros, categoria, wifi, arCondicionado, placa, ano, valorDiaria);
        veiculos.add(onibus);
    }

    private void cadastrarCaminhao() {
        int numEixos;
        double cargaMax;
        System.out.print("Placa: ");
        placa = ler.nextLine();
        System.out.print("Ano: ");
        ano = ler.nextInt();
        ler.nextLine();
        System.out.print("Valor da diaria: ");
        valorDiaria = ler.nextDouble();
        System.out.print("Numero de eixos: ");
        numEixos = ler.nextInt();
        ler.nextLine();
        System.out.print("Carga maxima: ");
        cargaMax = ler.nextDouble();
        Veiculo caminhao = new Caminhao(numEixos, cargaMax, placa, ano, valorDiaria);
        veiculos.add(caminhao);
    }

    private void listarMenu() {
        do {
            System.out.println("\nMenu Listar");
            System.out.println("0 - Voltar.");
            System.out.println("1 - Procurar veículo por placa.");
            System.out.println("2 - Listar todos os veículos.");
            System.out.print("O que voce deseja fazer: ");
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
                cadastrarOnibus();
                break;
        }
    }

    private void listarUmVeiculo() {
        System.out.println("\nDigite a placa do veículo: ");
        placa = ler.nextLine();
        System.out.println(veiculos.getInfo(placa));
    }

    private void listarTodos() {
        System.out.println(veiculos.getInfo());
    }

    private void editarMenu() {
        int indice;
        listarTodos();
        System.out.println("Escolha um dentre os "+veiculos.getNumVeiculos()+" veiculos para edita-lo.");
        do{
            System.out.print("Qual o indice escolhido: ");
            indice=ler.nextInt();
        }while(indice<1 || indice>veiculos.getNumVeiculos());
        Veiculo v
        
    }
}