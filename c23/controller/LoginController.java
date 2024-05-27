package c23.controller;

import c23.database.UsuariosCadastrados;
import c23.model.Usuario;
import c23.services.AutenticacaoEmail;
import c23.services.AutenticacaoSenha;

public class LoginController {
    private String cookie;
    private String senha;
    private String email;
    private String roleUsuario;
    private int tempoExpiracaoCookie;

    public LoginController() {
        cookie = "";
        senha = "";
        email = "";
        roleUsuario = "";
        tempoExpiracaoCookie = 0;
    }

    public boolean cadastrar(String email, String senha) {
        return
        !UsuariosCadastrados.usuarioCadastrado(email)
            &&
        new AutenticacaoSenha().ehUmaSenhaSegura(senha)
            &&
        new AutenticacaoEmail().ehUmEmailCorreto(email);
    }

    public boolean login(String email, String senha) {
        Usuario usuario = UsuariosCadastrados.buscarUsuario(email);

        if (UsuariosCadastrados.usuarioCadastrado(email) && UsuariosCadastrados.buscarUsuario(email).getSenha().equals(senha)) {
            email = usuario.getEmail();
            senha = usuario.getSenha();
            cookie = "123";
            roleUsuario = usuario.getRole();
            tempoExpiracaoCookie = 3;
            return true;
        }

        return false;
    }

    public String getCookie() {
        return cookie;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public String getRoleUsuario() {
        return roleUsuario;
    }

    public int getTempoExpiracaoCookie() {
        return tempoExpiracaoCookie;
    }
}
