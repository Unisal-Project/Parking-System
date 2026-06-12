package Factory;

import Camera.Andar;
import builder.Ticket;

public class TicketStub extends Ticket {
    private Andar andar;

    public TicketStub(Andar andar) {
        this.andar = andar;
    }

    @Override
    public Andar getAndar() {
        return andar;
    }

}

