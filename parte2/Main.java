package parte2;

import parte2.controller.LoginController;


public class Main {
    public static void main(String... args) {
        LoginController login = new LoginController();

        var um = login.cadastrar("spec@email.com", "Spec123sdfasd4@");

    }
}
