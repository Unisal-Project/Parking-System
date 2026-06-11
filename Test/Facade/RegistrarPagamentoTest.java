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
     * Verifica se o método registrarPagamento da fachada
     * processa corretamente um pagamento utilizando Pix.
     *
     * Este teste não tem como objetivo testar todas as formas
     * de pagamento, pois isso já é responsabilidade da classe
     * PagamentoTest. Aqui o objetivo é garantir que o Facade
     * consegue acessar e utilizar o módulo de pagamento corretamente.
     */
    @Test
    void RegistrarPagamento() {
        EstacionamentoFacade estFacade = new EstacionamentoFacade(100);
        double valorFinal = estFacade.registrarPagamento(100.0, new PagamentoPix());
        assertEquals(95.0, valorFinal);
    }
}