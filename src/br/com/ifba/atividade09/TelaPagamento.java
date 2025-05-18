/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09;

/**
 *
 * @author User
 */
import javax.swing.*;
import java.awt.event.*;

public class TelaPagamento extends JFrame {
    private JComboBox<String> comboPagamento;
    private JTextField campoValor;
    private JTextArea areaResultado;
    private JButton botaoCalcular;

    public TelaPagamento() {
        setTitle("Sistema de Pagamento");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblTipo = new JLabel("Tipo de pagamento:");
        lblTipo.setBounds(20, 20, 150, 20);
        add(lblTipo);

        comboPagamento = new JComboBox<>(new String[]{"Dinheiro", "Cartão", "Pix"});
        comboPagamento.setBounds(180, 20, 180, 20);
        add(comboPagamento);

        JLabel lblValor = new JLabel("Valor da compra:");
        lblValor.setBounds(20, 60, 150, 20);
        add(lblValor);

        campoValor = new JTextField();
        campoValor.setBounds(180, 60, 180, 20);
        add(campoValor);

        botaoCalcular = new JButton("Calcular");
        botaoCalcular.setBounds(130, 100, 120, 30);
        add(botaoCalcular);

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);
        scroll.setBounds(20, 140, 340, 100);
        add(scroll);

        botaoCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processarPagamento();
            }
        });
    }

    private void processarPagamento() {
        try {
            double valor = Double.parseDouble(campoValor.getText());
            Pagamento pagamento = null;

            String tipo = (String) comboPagamento.getSelectedItem();

            switch (tipo) {
                case "Dinheiro":
                    pagamento = new PagamentoDinheiro(valor);
                    break;
                case "Cartão":
                    pagamento = new PagamentoCartao(valor);
                    break;
                case "Pix":
                    pagamento = new PagamentoPix(valor);
                    break;
            }

            double total = pagamento.calcularTotal();

            areaResultado.setText("");
            areaResultado.append("Recibo:\n");
            pagamento.imprimirRecibo(); // Imprime no console também
            areaResultado.append("Valor final: R$ " + String.format("%.2f", total));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Insira um valor válido.");
        }
    }

    public static void main(String[] args) {
        TelaPagamento tela = new TelaPagamento();
        tela.setVisible(true);
    }
}
