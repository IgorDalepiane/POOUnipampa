/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora;

import br.com.locadora.clientes.ClienteGUI;

import javax.swing.*;

/**
 * @author 1801560700
 */
public class LocadoraMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ClienteGUI().setVisible(true);
            }
        });
    }
}
