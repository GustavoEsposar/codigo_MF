package parte2.controller;

import parte2.database.UsuariosCadastrados;
import parte2.model.Usuario;
import parte2.services.AutenticacaoEmail;
import parte2.services.AutenticacaoSenha;

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
        (UsuariosCadastrados.buscarUsuario(email) == null)
            &&
        new AutenticacaoSenha().verificarSenhaSegura(senha)
            &&
        new AutenticacaoEmail().verificarEmailCorreto(email);
    }

    public boolean login(String email, String senha) {
        Usuario usuario = UsuariosCadastrados.buscarUsuario(email);

        if (usuario != null && usuario.getSenha().equals(senha)) {
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
