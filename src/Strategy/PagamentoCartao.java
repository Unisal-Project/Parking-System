package Strategy;

public class PagamentoCartao implements MetodoPagamento {
    @Override
    public double pagar(double valor) {
        return valor;
    }
}