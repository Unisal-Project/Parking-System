package Strategy;

public class PagamentoDinheiro implements MetodoPagamento {
    @Override
    public double pagar(double valor) {
        return valor * 0.90;
    }
}