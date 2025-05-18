/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09;

/**
 *
 * @author User
 */
public class PagamentoCartao implements Pagamento {
    private double valor;

    public PagamentoCartao(double valor) {
        this.valor = valor;
    }

    @Override
    public double calcularTotal() {
        return valor * 1.05; // 5% de taxa
    }

    @Override
    public void imprimirRecibo() {
        System.out.println("Pagamento com Cartão");
        System.out.println("Valor original: R$ " + valor);
        System.out.println("Taxa: 5%");
        System.out.println("Total a pagar: R$ " + calcularTotal());
    }
}
