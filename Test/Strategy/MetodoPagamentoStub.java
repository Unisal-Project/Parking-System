package Strategy;

/**
 * Implementação Stub da interface MetodoPagamento utilizada
 * exclusivamente para testes unitários.
 *
 * Esta classe simula o comportamento de uma estratégia de pagamento,
 * retornando sempre um valor fixo independentemente do valor informado.
 *
 * O objetivo é isolar a lógica da classe em teste, permitindo validar
 * o comportamento do sistema sem depender das implementações reais
 * dos métodos de pagamento.
 *
 * @author Pedro Fonseca Martins
 * @version 1.0
 */
public class MetodoPagamentoStub implements MetodoPagamento {

    /**
     * Simula o processamento de um pagamento retornando
     * sempre um valor fixo.
     *
     * @param valor Valor recebido para processamento.
     * @return Valor fixo de 5.0 utilizado para testes.
     */
    @Override
    public double pagar(double valor) {
        return 5.0;
    }
}