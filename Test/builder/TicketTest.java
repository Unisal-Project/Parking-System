package builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe responsável por testar os comportamentos da classe Ticket.
 *
 * Os testes verificam:
 * <ul>
 *     <li>Se um ticket pago é identificado corretamente;</li>
 *     <li>Se um ticket pendente não é considerado pago;</li>
 *     <li>Se o ticket é finalizado corretamente.</li>
 * </ul>
 *
 * @author Pedro Fonseca Martins
 * @version 1.0
 */
public class TicketTest {

    /**
     * Caso de Teste: Verificação de Ticket Pago
     *
     * Resumo:
     * Verifica se o método estaPago retorna verdadeiro
     * quando o ticket possui status PAGO.
     *
     * Pré-condição:
     * - Um objeto Ticket deve estar instanciado.
     * - O status do ticket deve ser definido como PAGO.
     *
     * Entradas:
     * - StatusTicket.PAGO
     *
     * Ação:
     * - Executar o método estaPago().
     *
     * Resultado Esperado:
     * - O método deve retornar true.
     *
     * Pós-condição:
     * - O ticket permanece com status PAGO.
     */
    @Test
    void testRetornarTrueQuandoTicketEstiverPago() {
        Ticket ticket = new Ticket();

        ticket.setStatus(StatusTicket.PAGO);

        assertTrue(ticket.estaPago());
    }

    /**
     * Caso de Teste: Verificação de Ticket Não Pago
     *
     * Resumo:
     * Verifica se o método estaPago retorna falso
     * quando o ticket possui status PENDENTE_PAGAMENTO.
     *
     * Pré-condição:
     * - Um objeto Ticket deve estar instanciado.
     * - O status do ticket deve ser definido como PENDENTE_PAGAMENTO.
     *
     * Entradas:
     * - StatusTicket.PENDENTE_PAGAMENTO
     *
     * Ação:
     * - Executar o método estaPago().
     *
     * Resultado Esperado:
     * - O método deve retornar false.
     *
     * Pós-condição:
     * - O ticket permanece com status PENDENTE_PAGAMENTO.
     */
    @Test
    void testRetornarFalseQuandoTicketNaoEstiverPago() {
        Ticket ticket = new Ticket();

        ticket.setStatus(StatusTicket.PENDENTE_PAGAMENTO);

        assertFalse(ticket.estaPago());
    }

    /**
     * Caso de Teste: Finalização de Ticket
     *
     * Resumo:
     * Verifica se o método finalizar altera corretamente
     * o status do ticket para FINALIZADO.
     *
     * Pré-condição:
     * - Um objeto Ticket deve estar instanciado.
     * - O ticket deve possuir status PAGO.
     *
     * Entradas:
     * - StatusTicket.PAGO
     *
     * Ação:
     * - Executar o método finalizar().
     *
     * Resultado Esperado:
     * - O status do ticket deve ser alterado para FINALIZADO.
     *
     * Pós-condição:
     * - O ticket encontra-se finalizado e não pode mais
     *   representar um estacionamento em andamento.
     */
    @Test
    void testFinalizarTicket() {
        Ticket ticket = new Ticket();

        ticket.setStatus(StatusTicket.PAGO);

        ticket.finalizar();

        assertEquals(StatusTicket.FINALIZADO, ticket.getStatus());
    }
}