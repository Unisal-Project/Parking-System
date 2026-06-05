package Strategy;

public class Pagamento {
    public MetodoPagamento metodoPagamento;

    public Pagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public double realizarPagamento(double valor) {
        return metodoPagamento.pagar(valor);
    }
}