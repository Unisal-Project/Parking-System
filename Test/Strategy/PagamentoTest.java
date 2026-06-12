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
     * Caso de Teste: Pagamento por Cartão
     *
     * Resumo:
     * Verifica se o pagamento realizado com cartão retorna
     * o valor original sem aplicação de descontos.
     *
     * Pré-condição:
     * - Um objeto Pagamento deve ser criado utilizando
     *   a estratégia PagamentoCartao.
     *
     * Entradas:
     * - Valor do pagamento: 10.0
     *
     * Ação:
     * - Executar o método realizarPagamento(10.0).
     *
     * Resultado Esperado:
     * - O valor retornado deve ser igual a 10.0.
     *
     * Pós-condição:
     * - O pagamento foi processado sem alterações no valor.
     */
    @Test
    void PagamentoCartao() {
        Pagamento pagamento = new Pagamento(new PagamentoCartao());
        double valorFinal = pagamento.realizarPagamento(10.0);
        assertEquals(10.0, valorFinal);
    }

    /**
     * Caso de Teste: Pagamento via Pix
     *
     * Resumo:
     * Verifica se o pagamento via Pix aplica corretamente
     * o desconto de 5%.
     *
     * Pré-condição:
     * - Um objeto Pagamento deve ser criado utilizando
     *   a estratégia PagamentoPix.
     *
     * Entradas:
     * - Valor do pagamento: 10.0
     *
     * Ação:
     * - Executar o método realizarPagamento(10.0).
     *
     * Resultado Esperado:
     * - O valor retornado deve ser igual a 9.5.
     *
     * Pós-condição:
     * - O pagamento foi processado com desconto de 5%.
     */
    @Test
    void PagamentoPix() {
        Pagamento pagamento = new Pagamento(new PagamentoPix());
        double valorFinal = pagamento.realizarPagamento(10.0);
        assertEquals(9.5, valorFinal);
    }

    /**
     * Caso de Teste: Pagamento em Dinheiro
     *
     * Resumo:
     * Verifica se o pagamento em dinheiro aplica corretamente
     * o desconto de 10%.
     *
     * Pré-condição:
     * - Um objeto Pagamento deve ser criado utilizando
     *   a estratégia PagamentoDinheiro.
     *
     * Entradas:
     * - Valor do pagamento: 10.0
     *
     * Ação:
     * - Executar o método realizarPagamento(10.0).
     *
     * Resultado Esperado:
     * - O valor retornado deve ser igual a 9.0.
     *
     * Pós-condição:
     * - O pagamento foi processado com desconto de 10%.
     */
    @Test
    void PagamentoDinheiro() {
        Pagamento pagamento = new Pagamento(new PagamentoDinheiro());
        double valorFinal = pagamento.realizarPagamento(10.0);
        assertEquals(9.0, valorFinal);
    }

    /**
     * Caso de Teste: Pagamento Pix com Valor Zero
     *
     * Resumo:
     * Verifica o comportamento do sistema quando um pagamento
     * via Pix é realizado com valor igual a zero.
     *
     * Pré-condição:
     * - Um objeto Pagamento deve ser criado utilizando
     *   a estratégia PagamentoPix.
     *
     * Entradas:
     * - Valor do pagamento: 0.0
     *
     * Ação:
     * - Executar o método realizarPagamento(0.0).
     *
     * Resultado Esperado:
     * - O valor retornado deve ser igual a 0.0.
     *
     * Pós-condição:
     * - O pagamento é processado sem erros e permanece com valor zero.
     */
    @Test
    void PagamentoPixValorZero() {
        Pagamento pagamento = new Pagamento(new PagamentoPix());
        double valorFinal = pagamento.realizarPagamento(0.0);
        assertEquals(0.0, valorFinal);
    }

    /**
     * Caso de Teste: Método de Pagamento Stub
     *
     * Resumo:
     * Verifica se a implementação Stub retorna o valor
     * previamente definido para fins de teste.
     *
     * Pré-condição:
     * - Um objeto Pagamento deve ser criado utilizando
     *   MetodoPagamentoStub.
     *
     * Entradas:
     * - Valor do pagamento: 10.0
     *
     * Ação:
     * - Executar o método realizarPagamento(10.0).
     *
     * Resultado Esperado:
     * - O valor retornado deve ser igual a 5.0.
     *
     * Pós-condição:
     * - O comportamento da estratégia simulada foi validado.
     */
    @Test
    void MetodoPagamentoStub() {
        Pagamento pagamento = new Pagamento(new MetodoPagamentoStub());
        double valorFinal = pagamento.realizarPagamento(10.0);
        assertEquals(5.0, valorFinal);
    }
}