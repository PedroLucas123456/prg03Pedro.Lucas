/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade10;

/**
 *
 * @author User
 */
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Criando perfil de usuário
        PerfilUsuario adminPerfil = new PerfilUsuario(1L, "Administrador", Arrays.asList("CRIAR_USUARIO", "DELETAR_USUARIO"));
        System.out.println(adminPerfil);

        // Criando usuário e associando ao perfil
        Usuario usuario = new Usuario(1L, adminPerfil, "admin", "admin@email.com", "123456", true);
        System.out.println(usuario);

        // Criando sessão para o usuário
        Sessao sessao = usuario.criarSessao();
        System.out.println(sessao);

        // Simulando login
        LogAuditoria log = usuario.logar("123456");
        System.out.println(log);
    }
}
