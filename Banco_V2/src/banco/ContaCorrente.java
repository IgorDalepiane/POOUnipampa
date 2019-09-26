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
public class ContaCorrente extends Conta{

    public ContaCorrente(String titular) {
        super(titular);
    }
    
    public void atualiza(double taxa){
        super.atualiza(taxa * 2);
    }
    
    @Override
    public void deposita(double valor){
        super.deposita(valor - 0.10);
    }
    
    
    
}
