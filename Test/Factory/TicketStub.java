package Factory;

import builder.Ticket;
import builder.StatusTicket;
import Camera.Andar;

public class TicketStub extends Ticket {
    private Andar andar;

    public TicketStub(Andar andar) {
        this.andar = andar;
    }

    public TicketStub(Andar andar, StatusTicket status) {
        this.andar = andar;
        setStatus(status);
    }

    @Override
    public Andar getAndar() {
        return andar;
    }
}