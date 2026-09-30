public class Main {
    public static void main(String[] args) {
        GatewayPagamento gateway = new GatewayPagamento();

        PagamentoPix pagamentoPix = new PagamentoPix(150.00, "cliente@email.com");
        PagamentoCartao pagamentoCartao = new PagamentoCartao(6000.00, "1234567890123456", "Maria Silva");

        gateway.realizarCobranca(pagamentoPix);
        gateway.realizarCobranca(pagamentoCartao);
    }
}
