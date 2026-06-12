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
     * Caso de Teste: Atualização da Localização de um Ticket
     *
     * Resumo:
     * Verifica se o método atualizarLocalizacao atualiza corretamente
     * o andar associado a um ticket já existente.
     *
     * Pré-condição:
     * - Um objeto EstacionamentoFacade deve estar instanciado.
     * - Um veículo deve estar associado a um ticket.
     * - O ticket deve possuir uma localização inicial cadastrada.
     *
     * Entradas:
     * - Ticket associado ao veículo de placa "ABC1234".
     * - Andar inicial: número 1, tipo COBERTA.
     * - Novo andar: número 2, tipo DESCOBERTA.
     *
     * Ação:
     * - Executar o método atualizarLocalizacao(ticket, novoAndar).
     *
     * Resultado Esperado:
     * - O ticket deve passar a referenciar o novo andar.
     * - O número do andar deve ser igual a 2.
     * - O tipo da vaga deve ser DESCOBERTA.
     *
     * Pós-condição:
     * - A localização do ticket foi atualizada com sucesso.
     * - O ticket deixa de apontar para o andar inicial.
     */
    @Test
    void testAtualizarLocTicket() {
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