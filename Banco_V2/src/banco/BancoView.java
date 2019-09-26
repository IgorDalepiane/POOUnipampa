/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.Scanner;

/**
 *
 * @author Aline
 */
public class BancoView {
    private Banco meuBanco = new Banco();
    
    public void menu(){
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("Banco CC");
            System.out.println("1. Abertura de Conta");
            System.out.println("2. Consultar Saldo");
            System.out.println("3. Sacar");
            System.out.println("4. Depositar");
            System.out.println("5. Tranferir");
            System.out.println("6. Listar contas");
            System.out.println("7. Listar contas corrente");
            System.out.println("8. Listar contas poupança");
            System.out.println("0. Sair\n");
            
            System.out.println("Qual a opcao desejada:");
            opcao = entrada.nextInt();
            
            switch(opcao){
                case 0:
                    break;
                case 1: 
                    abrirConta();
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
                    listarContasCorrente();
                    break;
                case 8:
                    listarContasPoupanca();
                    break;
                default:
                    System.out.println("Opcao Invalida");
            }
        }while(opcao != 0);
        
        
    }
    
    public void abrirConta(){
        Scanner entrada = new Scanner(System.in);
        String titular;
        int tipoConta;
        System.out.println("Informe o titular:");
        titular = entrada.nextLine();
        System.out.println("Informe o tipo de conta: 1- Conta Corrente 2- Conta Poupança");
        tipoConta = entrada.nextInt();
        switch(tipoConta){
            case 1:
                meuBanco.abrirContaCorrente(titular);
                break;
            case 2:
                meuBanco.abrirContaPoupanca(titular);
                break;
            default:
                System.err.println("Tipo inexistente");
                break;
        }
        
    }
    
    public void consultarSaldo(){
        Scanner entrada = new Scanner(System.in);
        int numero;
        System.out.println("Informe o número da conta:");
        numero = entrada.nextInt();
        try{
            System.out.println("Saldo: "+meuBanco.consultarSaldo(numero));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void sacar(){
        Scanner entrada = new Scanner(System.in);
        int numero;
        double valor;
        System.out.println("Informe o número da conta:");
        numero = entrada.nextInt();
        System.out.println("Informe o valor:");
        valor = entrada.nextDouble();
        try{
            meuBanco.sacar(numero, valor);
            System.out.println("Saque realizado com sucesso");
        }catch(IllegalArgumentException | SaldoInsuficienteException e){
            System.err.println(e.getMessage());
        }
    
    }
    
    public void depositar(){
        Scanner entrada = new Scanner(System.in);
        int numero;
        double valor;
        System.out.println("Informe o número da conta:");
        numero = entrada.nextInt();
        System.out.println("Informe o valor:");
        valor = entrada.nextDouble();
        try{
            meuBanco.depositar(numero, valor);
            System.out.println("Foram depositados "+valor+" reais.");
        }catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }

    public void transferir(){
        Scanner entrada = new Scanner(System.in);
        int numeroDebito, numeroCredito;
        double valor;
        System.out.println("Informe o número da conta de debito:");
        numeroDebito = entrada.nextInt();
        System.out.println("Informe o número da conta de credito:");
        numeroCredito = entrada.nextInt();
        System.out.println("Informe o valor:");
        valor = entrada.nextDouble();
        try{
            meuBanco.transferir(numeroDebito, numeroCredito, valor);
            System.out.println("Transferência concluida");
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    public void listar(){
        System.out.println(meuBanco.listarContas());
    }
    
    public void listarContasCorrente(){
        System.out.println(meuBanco.listarContasCorrente());
    }

    public void listarContasPoupanca(){
        System.out.println(meuBanco.listarContasPoupanca());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BancoView bcc = new BancoView(); 
        bcc.menu();
    }
    
}
