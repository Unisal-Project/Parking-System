package Facade;

import Camera.Andar;
import Camera.TipoVaga;
import Factory.TicketStub;
import builder.StatusTicket;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pedro Monteiro
 *  @Verson 1.0
 */
public class testSaidaVeiculos {

    /**
     * RESUMO: Verificar o comportamento da cancela ao registrar a saída
     * de um veículo, de acordo com a situação de pagamento do ticket
     * PRÉ CONDIÇÃO: EstacionamentoFacade iniciado e Ticket (stub)
     * associado a um Andar coberto
     * ENTRADAS: ticket.status = PAGO
     * AÇÃO: Chamar facade.registrarSaida(ticket)
     * RESULTADO: Retorna true, a cancela aberta e ticket.status passa a
     * FINALIZADO
     * PÓS CONDIÇÃO: Cancela liberada e status do ticket atualizado para
     * FINALIZADO
     */
    @Test
    void testRegistrarSaidaTicketPago(){
        EstacionamentoFacade facade = new EstacionamentoFacade(10);
        Andar andar = new Andar(1, TipoVaga.COBERTA);
        TicketStub ticket = new TicketStub(andar, StatusTicket.PAGO);

        boolean resultado = facade.registrarSaida(ticket);

        assertTrue(resultado);
        assertEquals(StatusTicket.FINALIZADO, ticket.getStatus());

    }

    /**
     * RESUMO: Verificar o comportamento da cancela ao registrar a saída
     * de um veículo, de acordo com a situação de pagamento do ticket.
     * PRÉ CONDIÇÃO: EstacionamentoFacade iniciado e Ticket (stub)
     * associado a um Andar coberto
     * ENTRADAS: ticket.status = PENDENTE_PAGAMENTO
     * AÇÃO: Chamar facade.registrarSaida(ticket)
     * RESULTADO: Retorna false, a cancela permanece fechada;
     * ticket.status permanece PENDENTE_PAGAMENTO.
     * PÓS CONDIÇÃO: Cancela não liberada e  status do ticket não altera
     */
    @Test
    void testRegistrarSaidaTicketNaoPago(){
        EstacionamentoFacade facade = new EstacionamentoFacade(10);
        Andar andar = new Andar(1, TipoVaga.COBERTA);
        TicketStub ticket = new TicketStub(andar, StatusTicket.PENDENTE_PAGAMENTO);

        boolean resultado = facade.registrarSaida(ticket);

        assertFalse(resultado);
        assertEquals(StatusTicket.PENDENTE_PAGAMENTO, ticket.getStatus());

    }
}