package parte1.modelo;

import java.util.Dictionary;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

import parte1.utils.ListUtils;

public final class Carrinho {

    private Dictionary<String, ProdutoAplicado> produtos;
    private HashSet<Cupom> cupons;
    private Double valorTotalCarrinho;
    private Double valorProdutos;
    private Double valorCupons;
    @SuppressWarnings("unused")
    private MetodoPagamento metodoPagamento;
    @SuppressWarnings("unused")
    private Double frete;

    Carrinho(){
        metodoPagamento = MetodoPagamento.CREDITO;
        valorCupons = 0.0;
        valorTotalCarrinho = 0.0;
        frete = 0.0;
        produtos = new Hashtable<String, ProdutoAplicado>();
        cupons = new HashSet<Cupom>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nCarrinho{\n");
        sb.append("\tvalorTotal=").append(valorTotalCarrinho);
        sb.append(",\n\tprodutos=").append(produtos);
        sb.append(",\n\tcuponsDisponiveis=").append(cupons);
        sb.append(",\n\tdescontoCuponsAplicados=").append(valorCupons);
        sb.append("\n}");
        return sb.toString();
    }

    public void adicionarProduto(Produto produto){
        var produtoAplicado = produtos.get(produto.id());

        if(produtoAplicado == null){
            produtos.put(produto.id(), new ProdutoAplicado(produto, 1));
        }else{
            produtos.put(produto.id(), new ProdutoAplicado(produto, ++produtoAplicado.quantidade));
        }

        calcularValoresCarrinho();
    }

    public void removerProduto(String idProduto){
        var removido = produtos.remove(idProduto);
        if(removido != null){
            calcularValoresCarrinho();
        }
    }

    public boolean adicionarCupom(Cupom cupom){
        return adicionarCupons(ListUtils.dentroDeLista(cupom));
    }

    public boolean adicionarCupons(List<Cupom> cupons){
        var descontoCupons = somarValoresCupons(cupons);
        var valorARetirar = (valorProdutos * descontoCupons);
        
        if(valorARetirar <= valorTotalCarrinho){
            for (Cupom cupom : cupons) {
                this.cupons.add(cupom);
            }
            valorTotalCarrinho -= valorARetirar;
            valorCupons = somarValoresCupons(this.cupons.stream().toList());
            return true;
        }

        return false;
    }

    private void calcularValoresCarrinho(){
        var precoCarrinho = somarValorProdutos(this.produtos);
        var descontoCupons = somarValoresCupons(this.cupons.stream().toList());
        valorProdutos = precoCarrinho;
        valorTotalCarrinho = precoCarrinho - (precoCarrinho * descontoCupons);
        valorCupons = descontoCupons;
    }

    private Double somarValoresCupons(List<Cupom> cupons){
        if(cupons.size() == 0){
            return 0.0;
        }

        if(cupons.size() == 1){
            return cupons.get(0).getPorcentagemDesconto();
        }

        return somarValoresCupons(cupons.subList(0, 1)) +
        somarValoresCupons(cupons.subList(1, cupons.size()));
    }

    private Double somarValorProdutos(Dictionary<String, ProdutoAplicado> produtos){
        var valorTotal = 0.0;
        var produtosAplicados = ListUtils.paraLista(produtos.elements());

       for (ProdutoAplicado produtoAplicado : produtosAplicados) {
            valorTotal += produtoAplicado.getValorProduto();
       }
        
       return valorTotal;
    }

    public Double getValorTotalCarrinho(){
        return valorTotalCarrinho;
    }
}

class ProdutoAplicado {
    protected int quantidade;
    protected Produto produto;

    ProdutoAplicado(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    protected Double getValorProduto() {
        return quantidade * produto.preço();
    }
}