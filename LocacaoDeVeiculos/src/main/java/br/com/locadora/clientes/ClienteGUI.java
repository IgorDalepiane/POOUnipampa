package br.com.locadora.clientes;

import javax.swing.*;
import java.awt.*;

public class ClienteGUI extends JFrame {
    private JTextField nomeTextField, cpfTextField, cnhTextField, telefoneTextField, enderecoTextField;
    private JLabel label;
    private JButton cadastrar;


    public ClienteGUI()  {
        createView();
        setTitle("CRUD Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void createView() {
        //cria um painel no JFrame
        JPanel p = new JPanel();
        getContentPane().add(p);


        label = new JLabel("Nome:");
        p.add(label);

        nomeTextField = new JTextField();
        nomeTextField.setPreferredSize(new Dimension(100, 30));
        p.add(nomeTextField);

        label = new JLabel("CPF:");
        p.add(label);

        cpfTextField = new JTextField();
        cpfTextField.setPreferredSize(new Dimension(100, 30));
        p.add(cpfTextField);

        label = new JLabel("CNH:");
        p.add(label);

        cnhTextField = new JTextField();
        cnhTextField.setPreferredSize(new Dimension(100, 30));
        p.add(cnhTextField);

        label = new JLabel("Telefone:");
        p.add(label);

        telefoneTextField = new JTextField();
        telefoneTextField.setPreferredSize(new Dimension(100, 30));
        p.add(telefoneTextField);

        label = new JLabel("Endereço:");
        p.add(label);

        enderecoTextField = new JTextField();
        enderecoTextField.setPreferredSize(new Dimension(100, 30));
        p.add(enderecoTextField);

        cadastrar = new JButton("Cadastrar");
        p.add(cadastrar);
    }
}
