package src.util;

import java.util.Scanner;

public class InterfaceUsuario {
    Scanner sc = new Scanner(System.in);

    public double digiteAreaConstruida() {
        System.out.print("Digite a área construída (m²): ");
        return sc.nextDouble();
    }

    public double digiteAreaTerreno() {
        System.out.print("Digite a área do terreno (m²): ");
        return sc.nextDouble();
    }

    public int digiteVagasGaragem() {
        System.out.print("Digite a quantidade de vagas disponíveis na garagem do prédio: ");
        return sc.nextInt();
    }

    public int digiteAndar() {
        System.out.print("Digite o andar do prédio em que seu apartamento está: ");
        return sc.nextInt();
    }

    public int digiteTipoZona() {
        System.out.print("Qual o tipo de zona do terreno? 1-Residencial, 2-Comercial: ");
        return sc.nextInt();
    }

    public int escolhaUsuario() {
        int escolhaUser;
        do {
            System.out.print("Qual o tipo de imóvel você deseja financiar? 1-Casa, 2-Apartamento, 3-Terreno ");
            escolhaUser = sc.nextInt();
            if (escolhaUser < 1 || escolhaUser > 3) {
                System.out.println("Número incorreto. Escolha uma das opções disponíveis.");
            }
        }while (escolhaUser < 1|| escolhaUser > 3);
        return escolhaUser;
    }

    public double digiteValorImovel() {
        double digitadoValorImovel;
        do {
            System.out.print("Digite o valor do imóvel: ");
            digitadoValorImovel = sc.nextDouble();
            if (digitadoValorImovel <= 0) {
                System.out.println("O valor não pode ser negativo. Tente novamente.");
            }
        } while (digitadoValorImovel <= 0);
        return digitadoValorImovel;
    }

    public int digitePrazoFinanciamento() {
        int digitadoPrazo;
        do {
            System.out.print("Digite o prazo do financiamento em anos: ");
            digitadoPrazo = sc.nextInt();
            if (digitadoPrazo <= 0){
                System.out.println("O valor não pode ser negativo. Tente novamente.");
            }
        } while (digitadoPrazo <= 0);
        return digitadoPrazo;
    }

    public double digiteTaxaJuros() {
        double digitadoTaxa;
        do {
            System.out.print("Digite a taxa de juros ao ano: ");
            digitadoTaxa = sc.nextDouble();
            if (digitadoTaxa <= 0) {
                System.out.println("O valor não pode ser negativo. Tente novamente.");
            }
        }while (digitadoTaxa <= 0);
        return digitadoTaxa;
    }
}