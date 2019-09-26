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
public class ContaPoupanca extends Conta{

    public ContaPoupanca(String titular) {
        super(titular);
    }
    
    @Override
    public void atualiza(double taxa){
        super.atualiza(taxa * 3);
    }
    
    
}
