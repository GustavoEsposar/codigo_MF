package parte1.modelo;

import java.util.ArrayList;
import java.util.List;

public final class Vendedor extends Cadastro {
    private List<Produto> catalogo;

    public Vendedor(String nome, String email, String telefone /* ,String senha */, String documento) {
        this.nome = nome;
        this.contato = new Contato(email, telefone);
        this.senha = null;
        this.documento = adicionarDocumento(false, documento);
        this.catalogo = new ArrayList<Produto>();
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "nome='" + nome + '\'' +
                ", contato=" + contato +
                ", senha=" + (senha == null ? "null" : "***") +
                ", documento='" + documento + '\'' +
                ", catalogo=" + catalogo +
                '}';
    }

    public List<Produto> getCatalogo() {
        return catalogo;
    }

    public Produto getProdutoDoCatalogo(String id) {
        return this.catalogo
                .stream()
                .filter(p -> p.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void adicionarProdutoNoCatalogo(Produto produto) {
        this.catalogo.add(produto);
    }
}
