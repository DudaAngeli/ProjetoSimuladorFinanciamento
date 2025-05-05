package src.modelo;

import src.util.AumentoMaiorDoQueJurosException;

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

    private void validarJurosMensal(double limiteJuros, double valorAcrescimo) throws AumentoMaiorDoQueJurosException {
        if (valorAcrescimo > limiteJuros) {
            throw new AumentoMaiorDoQueJurosException("Acréscimo maior que a metade dos juros mensais.");
        }
    }

    @Override
    public double calcularPagamentoMensal() {
        // obter valor dos juros
        // obter valor do acréscimo
        double valorAcrescimo = 80;
        double parcela = this.getValorImovel() / (this.getPrazoFinanciamento() * 12);
        double taxaMensal = this.getTaxaJuros() / 100 / 12;
        double jurosMensal = parcela * taxaMensal;

        try {
            validarJurosMensal(jurosMensal / 2, valorAcrescimo);
        } catch (AumentoMaiorDoQueJurosException e) {
            // alterar o valor do acréscimo;
            System.out.println(e.getMessage());
            valorAcrescimo = jurosMensal / 2;
        }

        return parcela + jurosMensal + valorAcrescimo;
    }

    @Override
    public void mostrarInformacoes() {
        super.mostrarInformacoes();
        System.out.printf("\nÁrea construída: %.2f m², Área do terreno: %.2f m²\n", areaConstruida, areaTerreno);
    }
}
