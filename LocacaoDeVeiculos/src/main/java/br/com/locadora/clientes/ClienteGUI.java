package br.com.locadora.clientes;

import br.com.locadora.clientes.GUI.Toolbar;

import javax.swing.*;
import java.awt.*;

//controller
public class ClienteGUI extends JFrame {

    private Toolbar t;

    private Cliente c;

    public ClienteGUI() {
        super("Cliente CRUD");

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(300, 80));
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        generate();
    }

    private void generate() {
        t = new Toolbar();
        add(t, BorderLayout.NORTH);
    }
}
