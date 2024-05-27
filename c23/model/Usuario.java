package c23.model;

public class Usuario {
    private String email;
    private String senha;
    private String role;

    public Usuario(String email, String senha, String role) {
        this.email = email;
        this.senha = senha;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getRole() {
        return role;
    }
}