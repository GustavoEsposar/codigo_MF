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
) {
    @Override
    public String toString() {
        return "Produto{" +
                "\n    id='" + id + '\'' +
                ",\n    nome='" + nome + '\'' +
                ",\n    categoria='" + categoria + '\'' +
                ",\n    preço=" + preço +
                ",\n    descricao='" + descricao + '\'' +
                ",\n    volume=" + volume +
                ",\n    comprimento=" + comprimento +
                ",\n    largura=" + largura +
                ",\n    espessura=" + espessura +
                ",\n    qtdeEstoque=" + qtdeEstoque +
                "\n}";
    }
}

