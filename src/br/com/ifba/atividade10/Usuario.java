/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade10;

/**
 *
 * @author User
 */
import java.time.LocalDateTime;
import java.util.UUID;

public class Usuario {
    private Long id;
    private PerfilUsuario perfil;
    private String nomeUsuario;
    private String email;
    private String senha;
    private LocalDateTime ultimoLogin;
    private boolean ativo;

    // Construtor
    public Usuario(Long id, PerfilUsuario perfil, String nomeUsuario, String email, String senha, boolean ativo) {
        this.id = id;
        this.perfil = perfil;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
        this.ultimoLogin = null;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public PerfilUsuario getPerfil() { return perfil; }
    public void setPerfil(PerfilUsuario perfil) { this.perfil = perfil; }

    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public LocalDateTime getUltimoLogin() { return ultimoLogin; }
    public void setUltimoLogin(LocalDateTime ultimoLogin) { this.ultimoLogin = ultimoLogin; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    // Método para logar (simula login e gera log de auditoria)
    public LogAuditoria logar(String senhaDigitada) {
        if (this.senha.equals(senhaDigitada)) {
            this.ultimoLogin = LocalDateTime.now();
            return new LogAuditoria(System.currentTimeMillis(), this, "Login realizado com sucesso", this.ultimoLogin, "127.0.0.1");
        } else {
            return new LogAuditoria(System.currentTimeMillis(), this, "Tentativa de login com senha incorreta", LocalDateTime.now(), "127.0.0.1");
        }
    }

    // Método para criar uma sessão
    public Sessao criarSessao() {
        String token = UUID.randomUUID().toString();
        return new Sessao(System.currentTimeMillis(), this, token);
    }

    // toString
    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nome='" + nomeUsuario + "', email='" + email + "', ativo=" + ativo + ", ultimoLogin=" + ultimoLogin + '}';
    }
}
