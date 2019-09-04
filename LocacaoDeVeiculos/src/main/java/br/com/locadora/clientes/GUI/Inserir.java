package br.com.locadora.clientes.GUI;

import br.com.locadora.clientes.Cliente;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Inserir extends JFrame {
    private JButton cadastrar;

    Inserir() {
        super("Cadastro de cliente");
        setSize(new Dimension(300, 225));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Container cP = getContentPane();

        SpringLayout layout = new SpringLayout();
        cP.setLayout(layout);

        ArrayList<JTextField> tfs = new ArrayList<>();
        String[] labels = {"Nome: ", "CPF: ", "CNH: ", "Telefone: ", "Endereço: ", ""}; //precisa de +1 label por causa do botão
        for (int i = 0; i < labels.length; i++) {
            if (i != labels.length - 1) {
                JLabel l = new JLabel(labels[i], JLabel.TRAILING);
                add(l);
                JTextField textField = new JTextField(10);
                l.setLabelFor(textField);

                tfs.add(textField);
                add(textField);
            } else {
                //last iteration, adiciona o botão
                JLabel l = new JLabel(labels[i], JLabel.TRAILING); //jlabel invisivel
                add(l);
                cadastrar = new JButton("Cadastrar");
                l.setLabelFor(cadastrar);
                add(cadastrar);
            }
        }
        SpringUtilities.makeCompactGrid(cP,
                labels.length, 2,
                6, 6,
                6, 6);
        cadastrar.setEnabled(false);
        //a cada alteração nos jtextfields, checa se existe um vazio
        DocumentListener filledListener = new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                boolean canEnable = true;
                for (JTextField tf : tfs) {
                    if (tf.getText().isEmpty()) {
                        canEnable = false;
                    }
                }
                cadastrar.setEnabled(canEnable);
            }
        };
        //adiciona o listener a cada textfield
        for (JTextField tf : tfs) {
            tf.getDocument().addDocumentListener(filledListener);
        }

        //cadastro do cliente, após clicar no botão
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Cliente(
                            tfs.get(0).getText(),                 //nome
                            Long.parseLong(tfs.get(1).getText()), //cpf
                            Long.parseLong(tfs.get(2).getText()), //cnh
                            Long.parseLong(tfs.get(3).getText()), // telefone
                            tfs.get(4).getText()                  //endereço
                    );
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }
                //fecha o frame de inserir
                Inserir.super.dispose();
            }
        });

    }
}
