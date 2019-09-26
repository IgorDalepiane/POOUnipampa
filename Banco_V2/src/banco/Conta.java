/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author Aline
 */
public abstract class Conta {
    protected static int numeroGeral = 10000;
    protected int numero;
    protected String titular;
    protected double saldo;
    protected double limite;
    
    public Conta(String titular){
       this.numero = numeroGeral;
       numeroGeral++;
       this.titular = titular;
    }
    
    public String getTitular(){
        return titular;
    }
    
    public int getNumero(){
        return numero;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    public double getLimite(){
        return limite;
    }

    
    public void setLimite(double novoLimite){
        limite = novoLimite;
    }
    
    public void saca(double valor){
        if (this.saldo < valor){
            throw new SaldoInsuficienteException("Saldo Insuficiente");
        }else if(valor < 0){
            throw new IllegalArgumentException("Valor Negativo");
        } 
        else {
            this.saldo-=valor;
        }

    }
   
    @Override
    public String toString(){
        String dado = "Conta\n";
        dado += "Numero: "+ getNumero()+"\n";
        dado += "Titular: "+ getTitular()+"\n";
        dado += "Saldo: "+ saldo+"\n";
        dado += "Limite: "+limite+"\n";
        return dado;
    }
    
    public void deposita(double valor) {
        if(valor > 0){
            saldo = saldo + valor;
        }else{
            throw new IllegalArgumentException("Valor Negativo");
        }
    }
    
    public void setTitular(String novoNome){
        titular = novoNome;
    }
    
    public void atualiza(double taxa){
        saldo = saldo * taxa;
    
    }
    
}
