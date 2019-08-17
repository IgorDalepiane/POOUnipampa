package banco;

import java.util.Scanner;

/**
 * A classe BancoES possui como atributo um objeto da classe Banco e fornece a
 * interface com o usuário, ou seja, as operações de leitura (nextInt(),
 * nextLine()...) e escrita (println()) devem estar concentradas apenas nessa
 * classe.
 *
 * @author Aline
 */
public class BancoES {

    private static Banco meuBanco = new Banco();
    private static Scanner ler = new Scanner(System.in);

    /**
     * Apresenta o menu com as opções de operações do banco.
     */
    public static void menu() {

        int opcao;
        do {
            System.out.println("\nBanco EC");
            System.out.println("1. Abrir Conta");
            System.out.println("2. Consultar Saldo");
            System.out.println("3. Sacar");
            System.out.println("4. Depositar");
            System.out.println("5. Tranferir");
            System.out.println("6. Listar Todas Contas");
            System.out.println("7. Encerrar Conta");
            System.out.println("0. Sair\n");

            System.out.print("Qual a opcao desejada:");
            opcao = ler.nextInt();
            ler.nextLine();
            switch (opcao) {
                case 1:
                    abrir();
                    break;
                case 2:
                    consultarSaldo();
                    break;
                case 3:
                    sacar();
                    break;
                case 4:
                    depositar();
                    break;
                case 5:
                    transferir();
                    break;
                case 6:
                    listar();
                    break;
                case 7:
                    encerrar();
                    break;
                default:
                    System.out.println("Opcao Invalida");
            }
        } while (opcao != 0);
    }

    /**
     * Realiza a leitura dos dados necessários para realizar a abertura de conta
     * e informa ao usuário o resultado da operação.
     */
    public static void abrir() {
        double CPF;
        String nomeCliente;
        System.out.print("Informe o seu nome:");
        nomeCliente=ler.nextLine();
        System.out.print("Informe o seu CPF:");
        CPF=ler.nextDouble();
        Cliente cl = new Cliente(nomeCliente,CPF);
        Conta c = new Conta(cl);
        meuBanco.abrirConta(c);
    }

    /**
     * Realiza a leitura dos dados necessários para realizar a consulta do saldo
     * de uma determinada conta e informa ao usuário o resultado da operação.
     */
    public static void consultarSaldo() {
        int numConta;
        String senhaConta;
        System.out.println("Informe o numero da conta:");
        numConta = ler.nextInt();
        ler.nextLine();
        System.out.println("Informe a senha da conta:");
        senhaConta = ler.nextLine();
        double saldo = meuBanco.consultarSaldo(numConta, senhaConta);
        if (saldo != -1) {
            System.out.println("Seu saldo é: " + saldo);
        } else {
            System.out.println("Senha Inválida");
        }
    }

    /**
     * Realiza a leitura dos dados necessários para realizar o saque de uma
     * determinada conta e informa ao usuário o resultado da operação.
     */
    public static void sacar() {
        int numConta, valorSaque;
        String senhaConta;
        System.out.println("Informe o numero da conta:");
        numConta = ler.nextInt();
        ler.nextLine();
        System.out.println("Informe a senha da conta:");
        senhaConta = ler.nextLine();
        System.out.println("Informe valor a ser sacado:");
        valorSaque = ler.nextInt();

        if (meuBanco.sacar(numConta, senhaConta, valorSaque)) {
            System.out.println("Foram sacados " + valorSaque + " da sua conta.");
        } else {
            System.out.println("Erro");
        }
    }
        /**
         * Realiza a leitura dos dados necessários para realizar o depósito em
         * uma determinada conta e informa ao usuário o resultado da operação.
         */
    public static void depositar() {
        int numConta, valorSaque;
        String senhaConta;
        System.out.println("Informe o numero da conta:");
        numConta = ler.nextInt();
        ler.nextLine();
        System.out.println("Informe a senha da conta:");
        senhaConta = ler.nextLine();
        System.out.println("Informe valor a ser sacado:");
        valorSaque = ler.nextInt();

        if (meuBanco.depositar(numConta, senhaConta, valorSaque)) {
            System.out.println("Foram depositados " + valorSaque + " na sua conta.");
        } else {
            System.out.println("Erro");
        }
    }

    /**
     * Realiza a leitura dos dados necessários para realizar a transferência
     * entre duas contas e informa ao usuário o resultado da operação.
     */
    public static void transferir() {
        int numConta, valorT, numDestino;
        String senhaConta;
        System.out.print("Informe o numero da conta: ");
        numConta = ler.nextInt();
        ler.nextLine();
        System.out.print("Informe a senha da sua conta: ");
        senhaConta = ler.nextLine();
        
        System.out.print("Informe o numero da conta destinatária: ");
        numDestino = ler.nextInt();
        
        System.out.println("Informe valor a ser transferido:");
        valorT = ler.nextInt();
        
        if (meuBanco.transferir(numConta, senhaConta,numDestino, valorT)) {
            System.out.println("Foram transferido " + valorT + " para a conta de destino.");
        } else {
            System.out.println("Erro");
        }
    }

    /**
     * Apresenta uma listagem com as informações de todas as ocntas.
     */
    public static void listar() {
        System.out.println(meuBanco.listarContas());
    }

    /**
     * Realiza a leitura dos dados necessários para realizar o encerramento de
     * uma determinada conta e informa ao usuário o resultado da operação.
     */
    public static void encerrar() {
        int numConta;
        String senhaConta;
        System.out.print("Informe o numero da conta: ");
        numConta = ler.nextInt();
        ler.nextLine();
        System.out.print("Informe a senha da conta: ");
        senhaConta = ler.nextLine();
        
        if (meuBanco.encerrar(numConta, senhaConta)) {
            System.out.println("Sua conta foi encerrada");
        } else {
            System.out.println("Erro");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BancoES.menu();
    }
}
