/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author 1801560700
 */
public class ContaCorrente extends Conta{
    private double limite;
    
    public ContaCorrente(Cliente titular) {
        super(titular);
        this.limite=0;
    }

    @Override
    public void atualiza(double taxa) {
        super.saldo+= super.saldo * (taxa*2)/100;
    }
    public void deposita(double valor){
        saldo+=valor;
        saldo-=0.10;
    }
    public double getLimite(){
        return limite;
    }
    
    public void setLimite(double l){
        limite=l;
    }

    @Override
    public boolean saca(double valor) {
        if(valor <= (saldo+limite)){
            saldo-=valor;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " | Limite: "+this.limite+"\n";
    }
    
}
