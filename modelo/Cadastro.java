package modelo;

public abstract class Cadastro {
    protected String nome;
    protected String documento;
    protected String senha;
    protected Contato contato;

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getSenha() {
        return senha;
    }

    public Contato getContato() {
        return contato;
    }

    protected String adicionarDocumento(boolean isCPF, String doc) {
        if (isCPF) {
            return formatarCPF(doc);
        }
        return formatarCNPJ(doc);
    }

    private String formatarCPF(String doc) {
        if (doc != null)
            doc = doc.replaceAll("[^\\d]", "");

        // Verifica se a string tem exatamente 11 dígitos
        if (doc  == null || !doc.matches("^\\d{11}$")) {
            throw new IllegalArgumentException("CPF inválido: " + doc);
        }

        // Formata o CPF com pontos e traço
        return doc.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    private String formatarCNPJ(String doc) {
        if (doc != null)
            doc = doc.replaceAll("[^\\d]", "");

        // Verifica se a string tem exatamente 14 dígitos
        if (doc  == null || !doc.matches("^\\d{14}$")) {
            throw new IllegalArgumentException("CNPJ inválido: " + doc);
        }

        // Formata o CNPJ com pontos, barra e traço
        return doc.replaceFirst("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
    }
}