package modelo;

public class Cupom{
    public String identificador;
    private Double porcentagemDesconto;

    public Cupom(String identificador, Double porcentagemDesconto){
        this.identificador = identificador;
        setPorcentagemDesconto(porcentagemDesconto);
    }

    public void setPorcentagemDesconto(double porcentagem){
        porcentagemDesconto = porcentagem / 100;
    }

    public Double getPorcentagemDesconto(){
        return porcentagemDesconto;
    }
}