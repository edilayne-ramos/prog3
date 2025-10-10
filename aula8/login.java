package aula8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public login() {
        // Configuração da janela
        setTitle("Tela de Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Layout
        setLayout(new GridLayout(3, 2, 10, 10));
        
        // Componentes
        add(new JLabel("Usuário:"));
        usernameField = new JTextField(20);
        add(usernameField);
        
        add(new JLabel("Senha:"));
        passwordField = new JPasswordField(20);
        add(passwordField);
        
        JButton login = new JButton("Entrar");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                if (username.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(login.this, 
                        "Por favor, digite um nome de usuário!", 
                        "Erro", 
                        JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(login.this, 
                        "Bem-vindo, " + username + "!", 
                        "Boas-vindas", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        add(new JLabel());
        add(login);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }
}