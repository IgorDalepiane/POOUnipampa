package br.com.locadora.clientes.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel {

    private JButton insBtn;
    private JButton lisBtn;
    private JButton delBtn;


    private Inserir ins = new Inserir();

    public Toolbar() {
        insBtn = new JButton("Inserir");
        lisBtn = new JButton("Listar");
        delBtn = new JButton("Apagar");

        setLayout(new FlowLayout(FlowLayout.CENTER));

        add(insBtn);
        add(lisBtn);
        add(delBtn);

        //listener do inserir
        insBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ins.setVisible(true);
                ins.setLocation(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y + 35);
            }
        });
    }

}
