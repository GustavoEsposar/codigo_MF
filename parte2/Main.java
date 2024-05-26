package parte2;

import parte2.controller.LoginController;
import parte2.services.AutenticacaoEmail;

public class Main {
    public static void main(String... args) {
        LoginController login = new LoginController();

        var um = login.cadastrar("spec@email.com", "Spec123sdfasd4@");
        System.out.println(um);

        var cois = new AutenticacaoEmail().verificarEmailCorreto("spec@e.com");
        System.out.println(cois);
    }
}
