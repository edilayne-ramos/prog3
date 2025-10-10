package aula8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculadora extends JFrame {
    private JTextField numero1Field, numero2Field;
    private JComboBox<String> operacaoComboBox;
    private JCheckBox mostrarJOptionPane;

    public calculadora() {
        setTitle("calculadora Simples");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setLayout(new GridLayout(4, 2, 10, 10));
        
        add(new JLabel("Número 1:"));
        numero1Field = new JTextField(10);
        add(numero1Field);
        
        add(new JLabel("Número 2:"));
        numero2Field = new JTextField(10);
        add(numero2Field);
        
        add(new JLabel("Operação:"));
        String[] operacoes = {"Somar", "Subtrair", "Multiplicar", "Dividir"};
        operacaoComboBox = new JComboBox<>(operacoes);
        add(operacaoComboBox);
        
        add(new JLabel("Mostrar em popup:"));
        mostrarJOptionPane = new JCheckBox();
        add(mostrarJOptionPane);
        
        JButton calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(numero1Field.getText());
                    double num2 = Double.parseDouble(numero2Field.getText());
                    String operacao = (String) operacaoComboBox.getSelectedItem();
                    double resultado = 0;
                    
                    switch (operacao) {
                        case "Somar":
                            resultado = num1 + num2;
                            break;
                        case "Subtrair":
                            resultado = num1 - num2;
                            break;
                        case "Multiplicar":
                            resultado = num1 * num2;
                            break;
                        case "Dividir":
                            if (num2 == 0) {
                                throw new ArithmeticException("Divisão por zero!");
                            }
                            resultado = num1 / num2;
                            break;
                    }
                    
                    String mensagem = String.format("Resultado: %.2f", resultado);
                    if (mostrarJOptionPane.isSelected()) {
                        JOptionPane.showMessageDialog(calculadora.this, 
                            mensagem, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JLabel resultadoLabel = new JLabel(mensagem);
                        add(resultadoLabel);
                        revalidate();
                        repaint();
                    }
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(calculadora.this, 
                        "Por favor, insira números válidos!", 
                        "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(calculadora.this, 
                        ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(new JLabel());
        add(calcularButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new calculadora().setVisible(true);
            }
        });
    }
}