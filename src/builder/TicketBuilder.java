package builder;

import Factory.Veiculo;

import java.time.LocalDateTime;

/**
 * Classe responsável pela construção de objetos do tipo Ticket utilizando o padrão Builder.
 * Permite a criação fluida de um ticket definindo veículo, data de entrada e status.
 */
public class TicketBuilder {
    /** O objeto Ticket que está sendo construído. */
    private Ticket ticket;

    /**
     * Construtor do TicketBuilder. Inicializa uma nova instância de Ticket.
     */
    public TicketBuilder() {
        this.ticket = new Ticket();
    }

    /**
     * Define o veículo associado ao ticket.
     * @param veiculo O veículo que está entrando no estacionamento.
     * @return A própria instância do builder para encadeamento.
     */
    public TicketBuilder comVeiculo(Veiculo veiculo){
        this.ticket.setVeiculo(veiculo);
        return this;
    }

    /**
     * Define a data e hora de entrada do veículo.
     * @param data Objeto LocalDateTime representando o momento da entrada.
     * @return A própria instância do builder para encadeamento.
     */
    public TicketBuilder comEntrada(LocalDateTime data){
        this.ticket.setDataEntrada(data);
        return this;
    }

    /**
     * Define o status inicial do ticket.
     * @param status O status do ticket (ex: PENDENTE_PAGAMENTO).
     * @return A própria instância do builder para encadeamento.
     */
    public TicketBuilder comStatus(StatusTicket status) {
        this.ticket.setStatus(status);
        return this;
    }

    /**
     * Finaliza a construção e retorna o objeto Ticket configurado.
     * @return O objeto Ticket construído.
     */
    public Ticket build() {
        return this.ticket;
    }
}
