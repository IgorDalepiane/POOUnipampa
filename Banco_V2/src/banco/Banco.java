/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.ArrayList;

/**
 *
 * @author Aline
 */
public class Banco {
    private ArrayList<Conta> contas;
    
    public Banco(){
        contas = new ArrayList();
    }
    
    /**
     * Iniciar uma nova conta
     */
    public void abrirContaCorrente(String titular){
        Conta novaConta = new ContaCorrente(titular);
        contas.add(novaConta);
        
    }
    
    /**
     * Iniciar uma nova conta
     */
    public void abrirContaPoupanca(String titular){
        Conta novaConta = new ContaPoupanca(titular);
        contas.add(novaConta);
        
    }
    
    public void abrirContaCorrente(String titular, double saldo, double limite){
        Conta novaConta = new ContaCorrente(titular);
        novaConta.deposita(saldo);
        novaConta.setLimite(limite);
        contas.add(novaConta);
    }
    
    public void abrirContaPoupanca(String titular, double saldo, double limite){
        Conta novaConta = new ContaPoupanca(titular);
        novaConta.deposita(saldo);
        novaConta.setLimite(limite);
        contas.add(novaConta);
    }
    
    public Conta getConta(int numero){
        for(int i=0; i<contas.size(); i++){
            if(contas.get(i).getNumero() == numero)
                return contas.get(i);
        }
        return null;
    }
    
    
    public void sacar(int numero, double valor) throws IllegalArgumentException,SaldoInsuficienteException{
        Conta conta = getConta(numero);
        if(conta != null){
            conta.saca(valor);
        }else{
            throw new IllegalArgumentException("Número de conta inexistente");
        }
    }

    public void depositar(int numero, double valor)  throws IllegalArgumentException{
        Conta conta = getConta(numero);
        if(conta != null){
            conta.deposita(valor);
        }else{
            throw new IllegalArgumentException("Número de conta inexistente");
        }
        
    }

    
    public double consultarSaldo(int numero) throws Exception{
        Conta conta = getConta(numero);
        if(conta != null){
           return conta.getSaldo();
        }
        throw new Exception("Conta inexistente");
    }
    
    public void transferir(int numeroDebito, int numeroCredito, double valor) throws Exception,IllegalArgumentException,SaldoInsuficienteException{
        Conta contaCredito = getConta(numeroCredito); // depositar valor
        Conta contaDebito = getConta(numeroDebito); // sacar valor
        if(contaDebito== null)
            throw new Exception("Conta Debito inexistente"); 
        if(contaCredito== null)
            throw new Exception("Conta Credito inexistente"); 
        if(contaDebito == contaCredito)
            throw new Exception("Conta Debito e Credito iguais");
        
        contaDebito.saca(valor);
        contaCredito.deposita(valor);
        
    }
    
    public String listarContas(){
        String dados = "";
        for(Conta conta : contas){
            dados += conta.toString();
        }
        return dados;
        
    }
    
    public String listarContasCorrente(){
        String dados = "";
        for(Conta conta : contas){
            if(conta instanceof ContaCorrente){
                dados += conta.toString();
            }
        }
        return dados;
        
    }
    
    public String listarContasPoupanca(){
        String dados = "";
        for(Conta conta : contas){
            if(conta instanceof ContaPoupanca){
                dados += conta.toString();
            }
        }
        return dados;
        
    }
}
