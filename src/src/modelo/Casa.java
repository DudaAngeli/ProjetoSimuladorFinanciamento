package src.modelo;

public class Casa extends Financiamento{
    private double areaConstruida;
    private double areaTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJuros, double areaConstruida, double areaTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJuros);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getAreaTerreno() {
        return areaTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        return (this.getValorImovel() / (this.getPrazoFinanciamento() * 12)) * (1 + (getTaxaJuros() / 12)) + 80;
    }

    @Override
    public void mostrarInformacoes() {
        super.mostrarInformacoes();
        System.out.printf("\nÁrea construída: %.2f m², Área do terreno: %.2f m²\n", areaConstruida, areaTerreno);
    }
}
