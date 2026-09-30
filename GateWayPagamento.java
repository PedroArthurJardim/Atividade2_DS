public class GatewayPagamento {
    public void realizarCobranca(Pagamento pagamento) {
        if (pagamento.processar()) {
            pagamento.setStatus("APROVADO");
        } else {
            pagamento.setStatus("RECUSADO");
        }

        pagamento.imprimirRecibo();
    }
}
