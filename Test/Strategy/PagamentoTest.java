package Strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PagamentoTest {

    @Test
    void PagamentoCartao() {
        Pagamento pagamento = new Pagamento(new PagamentoCartao());
        double valorFinal = pagamento.realizarPagamento(10.0);
        assertEquals(10.0, valorFinal);
    }

    @Test
    void PagamentoPix() {
        Pagamento pagamento = new Pagamento(new PagamentoPix());
        double valorFinal = pagamento.realizarPagamento(10.0);
        assertEquals(9.5, valorFinal);
    }

    @Test
    void PagamentoDinheiro() {
        Pagamento pagamento = new Pagamento(new PagamentoDinheiro());
        double valorFinal = pagamento.realizarPagamento(10.0);
        assertEquals(9.0, valorFinal);
    }

    @Test
    void PagamentoPixValorZero() {
        Pagamento pagamento = new Pagamento(new PagamentoPix());
        double valorFinal = pagamento.realizarPagamento(0.0);
        assertEquals(0.0, valorFinal);
    }

    @Test
    void MetodoPagamentoStub(){
        Pagamento pagamento = new Pagamento(new MetodoPagamentoStub());
        double valorFinal = pagamento.realizarPagamento(10.0);
        assertEquals(5.0, valorFinal);
    }

}