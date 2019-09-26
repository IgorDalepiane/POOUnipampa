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
public class SaldoInsuficienteException extends RuntimeException{
    SaldoInsuficienteException(String message){
      super(message);
    }
}

