package Facade;

import Strategy.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe responsável por testar os comportamentos da fachada
 * do sistema de estacionamento.
 *
 * Este teste verifica se a fachada consegue registrar um pagamento
 * utilizando uma estratégia de pagamento.
 *
 * @author Pedro Fonseca Martins
 * @version 1.0
 */
public class RegistrarPagamentoTest {

    /**
     * Caso de Teste: Registro de Pagamento pela Fachada
     *
     * Resumo:
     * Verifica se o método registrarPagamento da classe
     * EstacionamentoFacade processa corretamente um pagamento
     * utilizando a estratégia Pix.
     *
     * Pré-condição:
     * - Um objeto EstacionamentoFacade deve estar instanciado.
     * - A estratégia de pagamento Pix deve estar disponível.
     *
     * Entradas:
     * - Valor do pagamento: 100.0
     * - Estratégia de pagamento: PagamentoPix
     *
     * Ação:
     * - Executar o método registrarPagamento(100.0, new PagamentoPix()).
     *
     * Resultado Esperado:
     * - O valor retornado deve ser igual a 95.0.
     * - O desconto de 5% do Pix deve ser aplicado corretamente.
     *
     * Pós-condição:
     * - O pagamento foi processado pela fachada.
     * - O valor final corresponde ao cálculo realizado pela
     *   estratégia de pagamento selecionada.
     *
     * Observação:
     * - Este teste valida apenas a integração da fachada com
     *   o módulo de pagamento.
     * - As regras específicas de Cartão, Pix e Dinheiro são
     *   testadas separadamente na classe PagamentoTest.
     */
    @Test
    void RegistrarPagamento() {
        EstacionamentoFacade estFacade = new EstacionamentoFacade(100);

        double valorFinal = estFacade.registrarPagamento(
                100.0,
                new PagamentoPix()
        );

        assertEquals(95.0, valorFinal);
    }
}