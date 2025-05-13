/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade10;

/**
 *
 * @author User
 */
public class PagamentoPix implements Pagamento {
    private double valor;

    public PagamentoPix(double valor) {
        this.valor = valor;
    }

    @Override
    public double calcularTotal() {
        return valor * 0.98; // 2% de cashback
    }

    @Override
    public void imprimirRecibo() {
        System.out.println("Pagamento via Pix");
        System.out.println("Valor original: R$ " + valor);
        System.out.println("Cashback: 2%");
        System.out.println("Total a pagar: R$ " + calcularTotal());
    }
}
