package modelo;

import java.util.Dictionary;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

import utils.ListUtils;

public final class Carrinho {

    private Dictionary<String, ProdutoAplicado> produtos;
    private HashSet<Cupom> cupons;
    private Double valorTotal;
    private Double valorCupons;

    public Carrinho(){
        produtos = new Hashtable<String, ProdutoAplicado>();
        cupons = new HashSet<Cupom>();
        cupons.add(new Cupom("SPECTASTIC", 15.0));
        cupons.add(new Cupom("ZOADO", 10.0));
        valorTotal = 0.0;
        valorCupons = 0.0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nCarrinho{\n");
        sb.append("\tvalorTotal=").append(valorTotal);
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

        calcularValorTotal();
    }

    public void removerProduto(String idProduto){
        produtos.remove(idProduto);
        calcularValorTotal();
    }

    public boolean adicionarCupons(List<Cupom> cupons){
        var descontoCupons = somarValoresCupons(cupons);
        var valorARetirar = (valorTotal * descontoCupons);
        
        if(valorARetirar <= valorTotal){
            for (Cupom cupom : cupons) {
                cupons.add(cupom);
            }
            valorTotal -= valorARetirar;
            return true;
        }

        return false;
    }

    private void calcularValorTotal(){
        var precoCarrinho = calcularPrecoCarrinho(this.produtos);
        var descontoCupons = somarValoresCupons(this.cupons.stream().toList());
        valorTotal = precoCarrinho - (precoCarrinho * descontoCupons);
    }

    private Double somarValoresCupons(List<Cupom> cupons){
        if(cupons.size() == 0){
            return 0.0;
        }

        if(cupons.size() == 1){
            return cupons.get(0).getPorcentagemDesconto();
        }

        valorCupons = somarValoresCupons(cupons.subList(0, 1)) +
        somarValoresCupons(cupons.subList(1, cupons.size()));
        
        return valorCupons;
    }

    private Double calcularPrecoCarrinho(Dictionary<String, ProdutoAplicado> produtos){
        var valorTotal = 0.0;
        var produtosAplicados = ListUtils.paraLista(produtos.elements());

       for (ProdutoAplicado produtoAplicado : produtosAplicados) {
            valorTotal += produtoAplicado.getValorProduto();
       }
        
       return valorTotal;
    }

    public Double getValorTotal(){
        return valorTotal;
    }
}

class ProdutoAplicado {
    public int quantidade;
    public Produto produto;

    ProdutoAplicado(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Double getValorProduto() {
        return quantidade * produto.preço();
    }
}