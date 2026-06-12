package builder;

import Factory.Carro;
import Factory.Veiculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste para validar o funcionamento do TicketBuilder.
 * 
 * Segue o padrão de testes do projeto, garantindo que o builder
 * configure corretamente todos os campos do Ticket.
 */
public class TicketBuilderTest {

    private TicketBuilder builder;
    private Veiculo carro;
    private LocalDateTime agora;

    @BeforeEach
    void setUp() {
        builder = new TicketBuilder();
        carro = new Carro("ABC-1234");
        agora = LocalDateTime.now();
    }

    @Test
    void TestarCriacaoCompletaDoTicket() {
        // Executa o builder com todos os parâmetros
        Ticket ticket = builder
                .comVeiculo(carro)
                .comEntrada(agora)
                .comStatus(StatusTicket.PENDENTE_PAGAMENTO)
                .build();

        // Valida se os campos foram preenchidos corretamente
        assertNotNull(ticket, "O ticket não deveria ser nulo.");
        assertEquals(carro, ticket.getVeiculo(), "O veículo deve ser o mesmo que foi passado.");
        assertEquals(agora, ticket.getDataEntrada(), "A data de entrada deve ser a mesma que foi passada.");
        assertEquals(StatusTicket.PENDENTE_PAGAMENTO, ticket.getStatus(), "O status deve ser PENDENTE_PAGAMENTO.");
    }

    @Test
    void TestarCriacaoParcialTicket() {
        // Testa a criação apenas com o veículo
        Ticket ticket = builder.comVeiculo(carro).build();

        assertNotNull(ticket);
        assertEquals(carro, ticket.getVeiculo());
        assertNull(ticket.getDataEntrada(), "Data de entrada deveria ser nula se não informada.");
        assertNull(ticket.getStatus(), "Status deveria ser nulo se não informado.");
    }

    @Test
    void TestarAlteracaoDeStatusNoBuilder() {
        // Testa se o builder permite definir o status PAGO
        Ticket ticket = builder.comStatus(StatusTicket.PAGO).build();

        assertEquals(StatusTicket.PAGO, ticket.getStatus(), "O status deve ser PAGO.");
        assertTrue(ticket.estaPago(), "O ticket deveria constar como pago.");
    }
}
