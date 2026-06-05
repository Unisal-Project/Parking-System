public class Pagamento {
    private MetodoPagamento metodoPagamento;

    public Pagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public void realizarPagamento(double valor) {
        metodoPagamento.pagar(valor);
    }
}