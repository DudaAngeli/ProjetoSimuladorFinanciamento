package src.modelo;

public class Terreno extends Financiamento{
    private int tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJuros, int tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJuros);
        this.tipoZona = tipoZona;
    }

    public int getTipoZona() {
        return tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        return (this.getValorImovel() / (this.getPrazoFinanciamento() * 12)) * (1 + (getTaxaJuros() / 12)) * 1.02;
    }

    @Override
    public void mostrarInformacoes() {
        super.mostrarInformacoes();
        String tipo = (getTipoZona() == 1) ? "Residencial" : "Comercial";
        System.out.println("\nTipo de Zona do Terreno: " + tipo);
    }
}
