package builder;

import java.time.LocalDateTime;

public class TicketBuilder {
    private Ticket ticket;

    public TicketBuilder() {
        this.ticket = new Ticket();
    }

    public TicketBuilder comVeiculo(Veiculo veiculo){
        this.ticket.setVeiculo(veiculo);
        return this;
    }

    public TicketBuilder comEntrada(LocalDateTime data){
        this.ticket.setDataEntrada(data);
        return this;
    }

    public TicketBuilder comStatus(StatusTicket status) {
        this.ticket.setStatus(status);
        return this;
    }

    public Ticket build() {
        return this.ticket;
    }
}
