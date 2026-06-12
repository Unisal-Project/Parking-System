package Facade;

import Camera.Andar;
import Camera.TipoVaga;
import Factory.TicketStub;
import builder.StatusTicket;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testSaidaVeiculos {

    @Test
    void testRegistrarSaidaTicketPago(){
        EstacionamentoFacade facade = new EstacionamentoFacade(10);
        Andar andar = new Andar(1, TipoVaga.COBERTA);
        TicketStub ticket = new TicketStub(andar, StatusTicket.PAGO);

        boolean resultado = facade.registrarSaida(ticket);

        assertTrue(resultado);
        assertEquals(StatusTicket.FINALIZADO, ticket.getStatus());

    }

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
