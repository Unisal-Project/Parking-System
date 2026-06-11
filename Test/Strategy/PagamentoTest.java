package Strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe responsável por testar o funcionamento das estratégias
 * de pagamento do sistema de estacionamento.
 *
 * Os testes verificam se cada implementação da interface
 * MetodoPagamento aplica corretamente suas regras de negócio,
 * garantindo que o padrão Strategy esteja funcionando conforme esperado.
 *
 * @author Pedro Fonseca Martins
 * @version 1.0
 */
public class PagamentoTest {

    /**
     * Verifica se o pagamento por cartão retorna o valor original
     * sem alterações.
     */
    @Test
    void PagamentoCartao() {
        Pagamento pagamento = new Pagamento(new PagamentoCartao());
        double valorFinal = pagamento.realizarPagamento(10.0);
        assertEquals(10.0, valorFinal);
    }

    /**
     * Verifica se o pagamento via Pix aplica corretamente
     * o desconto de 5%.
     */
    @Test
    void PagamentoPix() {
        Pagamento pagamento = new Pagamento(new PagamentoPix());
        double valorFinal = pagamento.realizarPagamento(10.0);
        assertEquals(9.5, valorFinal);
    }

    /**
     * Verifica se o pagamento em dinheiro aplica corretamente
     * o desconto de 10%.
     */
    @Test
    void PagamentoDinheiro() {
        Pagamento pagamento = new Pagamento(new PagamentoDinheiro());
        double valorFinal = pagamento.realizarPagamento(10.0);
        assertEquals(9.0, valorFinal);
    }

    /**
     * Verifica o comportamento do pagamento via Pix quando
     * o valor informado é igual a zero.
     */
    @Test
    void PagamentoPixValorZero() {
        Pagamento pagamento = new Pagamento(new PagamentoPix());
        double valorFinal = pagamento.realizarPagamento(0.0);
        assertEquals(0.0, valorFinal);
    }

    /**
     * Verifica se o objeto Stub implementa corretamente
     * a interface MetodoPagamento para fins de teste.
     */
    @Test
    void MetodoPagamentoStub() {
        Pagamento pagamento = new Pagamento(new MetodoPagamentoStub());
        double valorFinal = pagamento.realizarPagamento(10.0);
        assertEquals(5.0, valorFinal);
    }
}