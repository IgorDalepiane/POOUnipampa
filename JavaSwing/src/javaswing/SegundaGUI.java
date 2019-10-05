/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author 1801560700
 */
public class SegundaGUI implements ActionListener{
    private JFrame frame;
    private JComboBox produto;
    private JLabel produto_label;
    
    private JTextField quantidade;
    private JLabel quant_label;
    
    private JTextField precoUnit;
    private JLabel precoUnit_label;
    
    private JButton botao_ok;
    private JButton botao_cancela;
    
    private JTextField precoTotal;
    private JLabel precoTotal_label;
    private Map<String,Double> valores;
    
    private JLabel erro;
    
    public SegundaGUI(){
        valores = new HashMap<String,Double>();
        valores.put( "Banana", 3.89);
        valores.put( "Laranja", 1.99);
        valores.put( "Maça", 3.50);
        valores.put( "Melância", 6.00);
        
        frame = new JFrame("Mercado");
        frame.setSize(300, 330);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        produto_label = new JLabel("Produtos:");
        produto_label.setBounds(20, 20, 100, 40);
        frame.getContentPane().add(produto_label, BorderLayout.CENTER);
        
        String produtos[]={"Banana","Laranja","Maça","Melância"};  
        produto = new JComboBox(produtos);
        produto.addActionListener(this);
        produto.setBounds(130, 20, 100, 40);
        frame.getContentPane().add(produto, BorderLayout.CENTER);
        
        quant_label = new JLabel("Quantidade:");
        quant_label.setBounds(20, 70, 100, 40);
        frame.getContentPane().add(quant_label, BorderLayout.CENTER);
        
        quantidade = new JTextField("");
        quantidade.setBounds(130, 70, 100, 40);
        frame.getContentPane().add(quantidade, BorderLayout.CENTER);
        
        precoUnit_label = new JLabel("Preço Unitario:");
        precoUnit_label.setBounds(20, 120, 100, 40);
        frame.getContentPane().add(precoUnit_label, BorderLayout.CENTER);
        
        precoUnit = new JTextField("");
        precoUnit.setBounds(130, 120, 100, 40);
        frame.getContentPane().add(precoUnit, BorderLayout.CENTER);
        
        botao_ok = new JButton("OK");
        botao_ok.setBounds(30, 170, 100, 40);
        botao_ok.addActionListener(this);
        frame.getContentPane().add(botao_ok, BorderLayout.CENTER);
        
        botao_cancela = new JButton("Cancela");
        botao_cancela.setBounds(140, 170, 100, 40);
        botao_cancela.addActionListener(this);
        frame.getContentPane().add(botao_cancela, BorderLayout.CENTER);
        
        precoTotal_label = new JLabel("Preço Total:");
        precoTotal_label.setBounds(20, 220, 100, 40);
        frame.getContentPane().add(precoTotal_label, BorderLayout.CENTER);
        
        precoTotal = new JTextField("");
        precoTotal.setEditable(false);
        precoTotal.setBounds(130, 220, 100, 40);
        frame.getContentPane().add(precoTotal, BorderLayout.CENTER);
        
        erro = new JLabel();
        erro.setBounds(20, 270, 150, 40);
        erro.setVisible(false);
        frame.getContentPane().add(erro, BorderLayout.CENTER);
        
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == botao_ok){
            try{
               int quant = Integer.parseInt(quantidade.getText());
               String precoU=precoUnit.getText();
               float precoUnidade = Float.parseFloat(precoU.substring(precoU.indexOf(" ") + 1, precoU.length()));
               float valorFinal = quant*precoUnidade;
               precoTotal.setText("R$ "+valorFinal);
               erro.setVisible(false);
            }catch(NumberFormatException e){
                if(quantidade.getText().isEmpty() || precoUnit.getText().isEmpty()){
                    erro.setText("Preencha os campos!");
                    erro.setVisible(true);
                }else{
                    erro.setText("Apenas números!");
                    erro.setVisible(true);
                } 
            }
        }else if(evt.getSource() == botao_cancela){
            precoTotal.setText("");
            precoUnit.setText("");
            quantidade.setText("");
        }else if(evt.getSource() == produto){
            precoUnit.setText("R$ "+valores.get((String) produto.getSelectedItem()));
        }
    }
}