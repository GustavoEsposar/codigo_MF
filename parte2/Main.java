package parte2;

import parte2.controller.LoginController;
import parte2.services.AutenticacaoEmail;
import parte2.services.AutenticacaoSenha;

public class Main {
    public static void main(String... args) {
        LoginController login = new LoginController();

        var um = login.cadastrar("spec@email.com", "Spec123sdfasd4@");

    }
}
