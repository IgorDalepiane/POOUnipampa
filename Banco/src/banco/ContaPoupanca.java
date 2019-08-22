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
public class ContaPoupanca extends Conta{
    
    public ContaPoupanca(Cliente titular) {
        super(titular);
    }

    @Override
    public void atualiza(double taxa) {
        super.saldo+= super.saldo * (taxa*3)/100;
    }

    @Override
    public boolean saca(double valor) {
       if(valor <= super.saldo){
            super.saldo-=valor;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n";
    }
    
}
