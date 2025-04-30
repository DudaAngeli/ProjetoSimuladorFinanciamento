package src.modelo;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class Financiamento{
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJuros;

    public double getValorImovel(){
        return this.valorImovel;
    }

    public int getPrazoFinanciamento(){
        return this.prazoFinanciamento;
    }

    public double getTaxaJuros(){
        return this.taxaJuros;
    }

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJuros) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJuros = taxaJuros;
    }

    public abstract double calcularPagamentoMensal();

    public double calcularPagamentoTotal() {
        return (this.calcularPagamentoMensal() * this.getPrazoFinanciamento() * 12);
    }

    public void mostrarInformacoes() {
        String brm;
        String brt;
        Locale localBrasil = new Locale("pt", "BR");
        brm = NumberFormat.getCurrencyInstance(localBrasil).format(this.calcularPagamentoMensal());
        brt = NumberFormat.getCurrencyInstance(localBrasil).format(this.calcularPagamentoTotal());

        System.out.printf("\nO pagamento mensal do seu financiamento será: %s\n\n", brm);

        System.out.printf("O pagamento total do seu financiamento será: %s\n", brt);
    }
}