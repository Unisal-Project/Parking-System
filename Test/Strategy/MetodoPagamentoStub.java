package Strategy;

public class MetodoPagamentoStub implements MetodoPagamento {
    @Override
    public double pagar(double valor) {
        return 5.0;
    }

}