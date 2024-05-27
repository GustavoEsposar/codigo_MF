package c23.database;

import java.util.HashMap;
import java.util.Map;

import c23.model.Usuario;

public class UsuariosCadastrados {
    private static Map<String, Usuario> usuarios = new HashMap<>();

    static {
        usuarios.put("fuba@example.com", new Usuario("fuba@example.com", "Fub@5678912345", "user"));
        usuarios.put("ocara@example.com", new Usuario("ocara@example.com", "Ocar@678912345", "user"));
        usuarios.put("zoador@example.com", new Usuario("zoador@example.com", "Zo@dor78912345", "admin"));
    }

    public static Usuario buscarUsuario(String email) {
        return usuarios.get(email);
    }

    public static boolean usuarioCadastrado(String email) {
        if (usuarios.get(email) == null) {
            return false;
        }
        return true;
    }
    
}