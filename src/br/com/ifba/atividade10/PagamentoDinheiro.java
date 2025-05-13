/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade10;

/**
 *
 * @author User
 */
public class PagamentoDinheiro implements Pagamento {
    private double valor;

    public PagamentoDinheiro(double valor) {
        this.valor = valor;
    }

    @Override
    public double calcularTotal() {
        return valor * 0.90; // 10% de desconto
    }

    @Override
    public void imprimirRecibo() {
        System.out.println("Pagamento em Dinheiro");
        System.out.println("Valor original: R$ " + valor);
        System.out.println("Desconto: 10%");
        System.out.println("Total a pagar: R$ " + calcularTotal());
    }
}
