package aula8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class janelainicial extends JFrame {
    public janelainicial() {
        setTitle("Bem-vindo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setLayout(new FlowLayout());
        
        JLabel mensagem = new JLabel("Bem-vindo a tela inicial!");
        mensagem.setFont(new Font("Arial", Font.PLAIN, 16));
        add(mensagem);
        
        JButton botaoFechar = new JButton("Fechar");
        botaoFechar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(botaoFechar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new janelainicial().setVisible(true);
            }
        });
    }
}