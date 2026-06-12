package Facade;

import Camera.*;
import Factory.*;
import builder.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe responsável por testar o método atualizarLocalizacao
 * da classe EstacionamentoFacade.
 *
 * O teste verifica se a fachada consegue atualizar corretamente
 * o andar/localização associado a um ticket.
 *
 * @author Pedro Fonseca Martins
 * @version 1.0
 */
public class AtualizaLocTest {

    /**
     * Verifica se o método atualizarLocalizacao atualiza
     * corretamente o andar associado ao ticket.
     */
    @Test
    void deveAtualizarLocalizacaoDoTicket() {
        EstacionamentoFacade facade = new EstacionamentoFacade(100);

        Veiculo carro = new Carro("ABC1234");

        Andar andarInicial = new Andar(1, TipoVaga.COBERTA);
        Andar novoAndar = new Andar(2, TipoVaga.DESCOBERTA);

        Ticket ticket = new Ticket();
        ticket.setVeiculo(carro);
        ticket.setAndar(andarInicial);

        facade.atualizarLocalizacao(ticket, novoAndar);

        assertEquals(novoAndar, ticket.getAndar());
        assertEquals(2, ticket.getAndar().getNumero());
        assertEquals(TipoVaga.DESCOBERTA, ticket.getAndar().getTipoVaga());
    }
}