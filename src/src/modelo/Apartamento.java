package src.modelo;

public class Apartamento extends Financiamento{
    private int vagasGaragem;
    private int andarApartamento;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJuros, int vagasGaragem, int andarApartamento) {
        super(valorImovel, prazoFinanciamento, taxaJuros);
        this.vagasGaragem  = vagasGaragem;
        this.andarApartamento = andarApartamento;
    }

    public double calcularTaxaMensal() {
        return taxaJuros / 12;
    }

    public int calcularPrazoMeses() {
        return prazoFinanciamento * 12;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxa = calcularTaxaMensal();
        double prazo = calcularPrazoMeses();

        taxa = taxa / 100.0;

        if (taxa == 0 || prazo == 0) {
            return valorImovel / Math.max(prazo, 1);
        }

        double fator = Math.pow(1 + taxa, prazo);
        return valorImovel * (taxa * fator) / (fator - 1);
    }

    @Override
    public void mostrarInformacoes() {
        super.mostrarInformacoes();
        System.out.println("\nVagas na garagem: " + vagasGaragem + ", Andar do Apartamento: " + andarApartamento);
    }
}
