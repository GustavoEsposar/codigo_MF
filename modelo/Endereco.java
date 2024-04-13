package modelo;

public record Endereco(
    String CEP,
    String rua,
    Integer numero,
    String complemento,
    String bairro,
    String cidade,
    String estado
) {}
