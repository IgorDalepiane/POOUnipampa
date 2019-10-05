/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author 1801560700
 */
public class PrimeiraGUI implements ActionListener{
    private JFrame frame;
    private JTextField celsius;
    private JButton botao;
    private JButton botao_limpa;
    private JLabel celsius_label;
    private JLabel fahr_label;
    private JLabel erro;
    
    public PrimeiraGUI(){
        frame = new JFrame("Conversor");
        frame.setSize(300, 220);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        celsius = new JTextField("0");
        celsius.setBounds(20, 20, 100, 40);
        frame.getContentPane().add(celsius, BorderLayout.CENTER);
        
        celsius_label = new JLabel("Celsius");
        celsius_label.setBounds(140, 20, 100, 40);
        frame.getContentPane().add(celsius_label, BorderLayout.CENTER);
        
        botao = new JButton("Converter");
        botao.setBounds(20, 80, 100, 40);
        botao.addActionListener(this);
        frame.getContentPane().add(botao, BorderLayout.CENTER);
        
        botao_limpa = new JButton("Limpar");
        botao_limpa.setBounds(20, 130, 100, 40);
        botao_limpa.addActionListener(this);
        frame.getContentPane().add(botao_limpa, BorderLayout.CENTER);
        
        fahr_label = new JLabel("32.0 Fahrenheit");
        fahr_label.setBounds(140, 80, 100, 40);
        fahr_label.setVisible(true);
        frame.getContentPane().add(fahr_label, BorderLayout.CENTER);
        
        erro = new JLabel();
        erro.setBounds(140, 120, 150, 40);
        erro.setVisible(false);
        frame.getContentPane().add(erro, BorderLayout.CENTER);
        
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == botao){
            try{
               float jml = Float.parseFloat(celsius.getText());
                float fahr=(jml*9/5) + 32;
                String label = fahr+" Fahrenheit";
                fahr_label.setText(label);
                fahr_label.setVisible(true);
                erro.setVisible(false);
            }catch(NumberFormatException e){
                if(celsius.getText().isEmpty()){
                    erro.setText("Preencha o campo!");
                    erro.setVisible(true);
                }else{
                    erro.setText("Apenas números!");
                    erro.setVisible(true);
                } 
            }
        }else if(evt.getSource() == botao_limpa){
            celsius.setText("0");
            fahr_label.setText("32.0 Fahrenheit");
        }
    }
}