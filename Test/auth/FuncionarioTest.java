package auth;

import builder.StatusTicket;
import builder.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe responsável por testar os comportamentos da classe Funcionario.
 *
 * Os testes verificam:
 *
 * Validação de tickets pagos;
 * Validação de tickets pendentes;
 * Validação de tickets nulos.
 *
 *
 * @author Luis Filippe Reis Nogueira
 *
 */
public class FuncionarioTest {

    private Funcionario funcionario;

    @BeforeEach
    void setUp() {
        funcionario = new Funcionario("João Silva", "123.456.789-00", 1, Cargo.ATENDENTE);
    }


    @Test
    void ValidarTicketPago() {
        Ticket ticket = new Ticket();
        ticket.setStatus(StatusTicket.PAGO);
        assertTrue(funcionario.validarTicket(ticket), "O ticket pago deve ser válido.");
    }

    @Test
    void ValidarTicketFinalizado() {
        Ticket ticket = new Ticket();
        ticket.setStatus(StatusTicket.FINALIZADO);
        assertTrue(funcionario.validarTicket(ticket), "O ticket finalizado deve ser válido.");
    }

    @Test
    void ValidarTicketPendente() {
        Ticket ticket = new Ticket();
        ticket.setStatus(StatusTicket.PENDENTE_PAGAMENTO);
        assertFalse(funcionario.validarTicket(ticket), "O ticket pendente de pagamento deve ser inválido.");
    }

    @Test
    void ValidarTicketNulo() {
        assertFalse(funcionario.validarTicket(null), "Um ticket nulo deve ser inválido.");
    }

    @Test
    void VerificarDadosFuncionario() {
        assertEquals("João Silva", funcionario.getNome());
        assertEquals("123.456.789-00", funcionario.getCpf());
        assertEquals(1, funcionario.getId());
        assertEquals(Cargo.ATENDENTE, funcionario.getCargo());
    }
}
