package modelo;

public final class Comprador extends Cadastro {
    private Carrinho carrinho;

    public Comprador(String nome, String email, String telefone /*,String senha*/, boolean isCPF, String documento) {
        this.nome = nome;
        this.contato = new Contato(email, telefone);
        this.senha = null;
        this.documento = adicionarDocumento(isCPF, documento);
        this.carrinho = new Carrinho();
    }

    @Override
    public String toString() {
        return "Comprador{" +
                "nome='" + nome + '\'' +
                ", contato=" + contato +
                ", senha='" + senha + '\'' +
                ", documento='" + documento + '\'' +
                ", carrinho=" + carrinho +
                '}';
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void adicionarAoCarrinho(Produto produto) {
        carrinho.adicionarProduto(produto);
    }

    public void adicionarCupomAoCarrinho(Cupom cupom){
        carrinho.adicionarCupom(cupom);
    }

    public void removerProdutoDoCorrinho(String idProduto){
        carrinho.removerProduto(idProduto);
    }
}