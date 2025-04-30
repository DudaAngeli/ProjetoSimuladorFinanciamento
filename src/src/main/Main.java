package src.main;

import src.modelo.Apartamento;
import src.modelo.Casa;
import src.modelo.Financiamento;
import src.modelo.Terreno;
import src.util.InterfaceUsuario;

import java.util.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Main{
    public static void main(String[] args) {
        Locale localBrasil = new Locale("pt", "BR");
        String bri;
        String brt;

        var financiamentos = new ArrayList<Financiamento>();

        financiamentos.add(new Apartamento(300000, 15, 5, 10, 6));
        financiamentos.add(new Casa(765000, 30, 8, 600, 500));
        financiamentos.add(new Terreno(276400, 10, 5.4, 1));
        financiamentos.add(new Apartamento(500000, 10, 10, 30, 10));
        financiamentos.add(new Casa(1903400, 30, 8, 1600, 1100));
        financiamentos.add(new Terreno(200000, 20, 9.5, 2));

        System.out.println("\n******* Detalhes dos Financiamentos! *******\n");
        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        for (var f : financiamentos) {
            bri = NumberFormat.getCurrencyInstance(localBrasil).format(f.getValorImovel());
            System.out.printf("Valor do imóvel a ser financiado: %s. Prazo do financiamento: %d anos. Taxa de juros anual: %.1f%%\n\n", bri, f.getPrazoFinanciamento(), f.getTaxaJuros());
            totalImoveis += f.getValorImovel();
            totalFinanciamentos += f.calcularPagamentoTotal();
        }

        InterfaceUsuario inter = new InterfaceUsuario();

        Financiamento financiamento;

        int escolha = inter.escolhaUsuario();

        if (escolha == 1) {
            financiamento = new Casa(inter.digiteValorImovel(), inter.digitePrazoFinanciamento(), inter.digiteTaxaJuros(), inter.digiteAreaConstruida(), inter.digiteAreaTerreno());
        } else if (escolha == 2) {
            financiamento = new Apartamento(inter.digiteValorImovel(), inter.digitePrazoFinanciamento(), inter.digiteTaxaJuros(), inter.digiteVagasGaragem(), inter.digiteAndar());
        } else {
            financiamento = new Terreno(inter.digiteValorImovel(), inter.digitePrazoFinanciamento(), inter.digiteTaxaJuros(), inter.digiteTipoZona());
        }

        financiamento.mostrarInformacoes();

        totalImoveis = totalImoveis + financiamento.getValorImovel();
        totalFinanciamentos = totalFinanciamentos + financiamento.calcularPagamentoTotal();

        bri = NumberFormat.getCurrencyInstance(localBrasil).format(totalImoveis);
        brt = NumberFormat.getCurrencyInstance(localBrasil).format(totalFinanciamentos);

        System.out.printf("\nO valor total dos imóveis será: %s\n\n", bri);
        System.out.printf("O valor total dos imóveis financiados será: %s\n", brt);
    }
}
