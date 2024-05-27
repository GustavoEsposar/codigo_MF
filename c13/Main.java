package c13;
import c13.modelo.*;


public class Main {
    public static void main(String... args) {
        System.out.println();
        Vendedor vendedor = new Vendedor("Ocara Embalagens Ltda.", "contato@ocaraembalagens.com", "(11)9999-9999", "68.650.621/0001-54");
        preencherCatalogo(vendedor);
        System.out.println(vendedor);

        System.out.println();
        Comprador comprador = new Comprador("Zoador Jardins Silveira", "zoador@gmail.com", "(11)99999-9999", true, "100.211.070-09");
        escolheProdutos(comprador, vendedor);
        adicionarCupons(comprador);
        System.out.println(comprador);

        removerProduto(comprador, "P001");
        System.out.println(comprador);

        removerProduto(comprador, "P003");
        System.out.println(comprador);
    }

    static void preencherCatalogo(Vendedor vendedor) {
        vendedor.adicionarProdutoNoCatalogo(new Produto(
                "P001",
                "Caixa de Papelão",
                "Embalagem",
                10.0,
                "Caixa de papelão resistente para transporte",
                1000.0f,
                30.0f,
                20.0f,
                15.0f,
                50
        ));
        vendedor.adicionarProdutoNoCatalogo(new Produto(
                "P002",
                "Envelope Plástico",
                "Embalagem",
                5.0,
                "Envelope plástico resistente para documentos",
                500.0f,
                25.0f,
                18.0f,
                0.5f,
                200
        ));
        vendedor.adicionarProdutoNoCatalogo(new Produto(
                "P003",
                "Caixa de Metal",
                "Embalagem",
                15.0,
                "Caixa de metal para armazenamento seguro",
                2000.0f,
                40.0f,
                30.0f,
                25.0f,
                30
        ));
    }

    static void escolheProdutos(Comprador comprador, Vendedor vendedor) {
        comprador.adicionarAoCarrinho(vendedor.getProdutoDoCatalogo("P001"));
        comprador.adicionarAoCarrinho(vendedor.getProdutoDoCatalogo("P003"));
    }

    static void adicionarCupons(Comprador comprador){
        comprador.adicionarCupomAoCarrinho(new Cupom("SPECTASTIC", 15.0));
        comprador.adicionarCupomAoCarrinho(new Cupom("ZOADO", 10.0));
    }

    static void removerProduto(Comprador comprador, String idProduto){
        comprador.removerProdutoDoCorrinho(idProduto);
    }
}
