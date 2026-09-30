import java.text.NumberFormat;
import java.util.Locale;
import java.util.UUID;

public abstract class Pagamento {
    protected String idTransacao;
    protected double valor;
    protected String status;

    public Pagamento(double valor) {
        this.idTransacao = UUID.randomUUID().toString();
        this.valor = valor;
        this.status = "PENDENTE";
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public double getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void imprimirRecibo() {
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        System.out.println("----- RECIBO -----");
        System.out.println("ID da transacao: " + idTransacao);
        System.out.println("Valor: " + formatoMoeda.format(valor));
        System.out.println("Status: " + status);
        System.out.println("------------------");
    }

    public abstract boolean processar();
}
