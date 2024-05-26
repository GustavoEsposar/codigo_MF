package parte2;

import parte2.controller.LoginController;


public class Main {
    public static void main(String... args) {
        LoginController login = new LoginController();

        var loginFalha = login.login("gustavo@example.com", "Gustavo_912345");
        var loginSucesso = login.login("zoador@example.com", "Zo@dor78912345");

        var cadastroJaExiste = login.cadastrar("fuba@example.com", "Fub@5678912345");
        var emailFalha = login.cadastrar("fuba@.com", "Fub@5678912345");
        var senhaFalha = login.cadastrar("fuba@example.com", "Fub@56");
        var cadastroSucesso = login.cadastrar("gustavo@example.com", "Gustavo@9123456");

        System.out.printf("Cenário de login falha: %b\n", loginFalha);
        System.out.printf("Cenário de login sucesso: %b\n", loginSucesso);
        System.out.printf("Cenário de cadastro já existente: %b\n", cadastroJaExiste);
        System.out.printf("Cenário de email falha: %b\n", emailFalha);
        System.out.printf("Cenário de senha falha: %b\n", senhaFalha);
        System.out.printf("Cenário de cadastro sucesso: %b\n", cadastroSucesso);
        
    }
}
