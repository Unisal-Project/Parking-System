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


    /**
     * Verifica a validação de um ticket com status PAGO.
     *
     * Pré-condição: Funcionário instanciado.
     * Entradas: Ticket com status PAGO.
     * Ação: Chama funcionario.validarTicket(ticket).
     * Resultados: O retorno deve ser verdadeiro.
     * Pós-condição: O estado do ticket não é alterado.
     */
    @Test
    void ValidarTicketPago() {
        Ticket ticket = new Ticket();
        ticket.setStatus(StatusTicket.PAGO);
        assertTrue(funcionario.validarTicket(ticket), "O ticket pago deve ser válido.");
    }

    /**
     * Verifica a validação de um ticket com status FINALIZADO.
     *
     * Pré-condição: Funcionário instanciado.
     * Entradas: Ticket com status FINALIZADO.
     * Ação: Chama funcionario.validarTicket(ticket).
     * Resultados: O retorno deve ser verdadeiro.
     * Pós-condição: O estado do ticket não é alterado.
     */
    @Test
    void ValidarTicketFinalizado() {
        Ticket ticket = new Ticket();
        ticket.setStatus(StatusTicket.FINALIZADO);
        assertTrue(funcionario.validarTicket(ticket), "O ticket finalizado deve ser válido.");
    }

    /**
     * Verifica a validação de um ticket com status PENDENTE_PAGAMENTO.
     *
     * Pré-condição: Funcionário instanciado.
     * Entradas: Ticket com status PENDENTE_PAGAMENTO.
     * Ação: Chama funcionario.validarTicket(ticket).
     * Resultados: O retorno deve ser falso.
     * Pós-condição: O estado do ticket não é alterado.
     */
    @Test
    void ValidarTicketPendente() {
        Ticket ticket = new Ticket();
        ticket.setStatus(StatusTicket.PENDENTE_PAGAMENTO);
        assertFalse(funcionario.validarTicket(ticket), "O ticket pendente de pagamento deve ser inválido.");
    }

    /**
     * Verifica o comportamento ao validar um ticket nulo.
     *
     * Pré-condição: Funcionário instanciado.
     * Entradas: null.
     * Ação: Chama funcionario.validarTicket(null).
     * Resultados: O retorno deve ser falso.
     * Pós-condição: Nenhuma exceção é lançada.
     */
    @Test
    void ValidarTicketNulo() {
        assertFalse(funcionario.validarTicket(null), "Um ticket nulo deve ser inválido.");
    }

    /**
     * Verifica se os dados do funcionário foram inicializados corretamente.
     *
     * Pré-condição: Funcionário criado no setUp().
     * Entradas: Nenhuma.
     * Ação: Verifica os atributos nome, cpf, id e cargo.
     * Resultados: Os valores devem coincidir com os fornecidos no construtor.
     * Pós-condição: Os dados do funcionário permanecem íntegros.
     */
    @Test
    void VerificarDadosFuncionario() {
        assertEquals("João Silva", funcionario.getNome());
        assertEquals("123.456.789-00", funcionario.getCpf());
        assertEquals(1, funcionario.getId());
        assertEquals(Cargo.ATENDENTE, funcionario.getCargo());
    }
}
