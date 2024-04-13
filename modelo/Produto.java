package modelo;

public record Produto(
    String id,
    String nome,
    String categoria,
    Double preço,
    String descricao,
    float volume,
    float comprimento,
    float largura,
    float espessura,
    Integer qtdeEstoque
) {}

