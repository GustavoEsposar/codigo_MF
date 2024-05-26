package parte2.model;

import java.util.HashMap;
import java.util.Map;

public class UsuariosCadastrados {
    private static Map<String, Usuario> usuarios = new HashMap<>();

    static {
        usuarios.put("fuba@example.com", new Usuario("fuba@example.com", "fuba123", "user"));
        usuarios.put("ocara@example.com", new Usuario("ocara@example.com", "ocara123", "user"));
        usuarios.put("zoador@example.com", new Usuario("zoador@example.com", "zoador123", "admin"));
    }

    public static Usuario buscarUsuario(String email) {
        return usuarios.get(email);
    }
}