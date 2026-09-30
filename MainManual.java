import java.util.Scanner;

public class MainManual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GatewayPagamento gateway = new GatewayPagamento();

        System.out.println("=== Gateway de Pagamentos ===");
        System.out.println("1 - Usar dados demonstrativos");
        System.out.println("2 - Informar dados manualmente");
        System.out.print("Escolha uma opcao: ");
        String opcao = scanner.nextLine();

        if (opcao.equals("1")) {
            executarDadosDemonstrativos(gateway);
        } else if (opcao.equals("2")) {
            executarDadosManuais(scanner, gateway);
        } else {
            System.out.println("Opcao invalida.");
        }

        scanner.close();
    }

    private static void executarDadosDemonstrativos(GatewayPagamento gateway) {
        System.out.println();
        System.out.println("Executando cobrancas com dados demonstrativos...");

        PagamentoPix pagamentoPix = new PagamentoPix(150.00, "cliente@email.com");
        PagamentoCartao pagamentoCartao = new PagamentoCartao(6000.00, "1234567890123456", "Maria Silva");

        gateway.realizarCobranca(pagamentoPix);
        gateway.realizarCobranca(pagamentoCartao);
    }

    private static void executarDadosManuais(Scanner scanner, GatewayPagamento gateway) {
        System.out.println("=== Pagamento via PIX ===");
        System.out.print("Digite o valor do Pix: ");
        double valorPix = lerValor(scanner);
        System.out.print("Digite a chave Pix: ");
        String chavePix = scanner.nextLine();

        PagamentoPix pagamentoPix = new PagamentoPix(valorPix, chavePix);
        gateway.realizarCobranca(pagamentoPix);

        System.out.println();
        System.out.println("=== Pagamento via Cartao ===");
        System.out.print("Digite o valor do cartao: ");
        double valorCartao = lerValor(scanner);
        System.out.print("Digite o numero do cartao: ");
        String numeroCartao = scanner.nextLine();
        System.out.print("Digite o nome do titular: ");
        String nomeTitular = scanner.nextLine();

        PagamentoCartao pagamentoCartao = new PagamentoCartao(valorCartao, numeroCartao, nomeTitular);
        gateway.realizarCobranca(pagamentoCartao);
    }

    private static double lerValor(Scanner scanner) {
        String entrada = scanner.nextLine().replace(",", ".");
        return Double.parseDouble(entrada);
    }
}
