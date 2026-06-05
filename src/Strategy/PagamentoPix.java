package Strategy;

public class PagamentoPix implements MetodoPagamento {
    @Override
    public double pagar(double valor) {
       return valor * 0.95;
    }
}