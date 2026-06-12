package Factory;

import Camera.TipoVaga;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testCalcularTarifa {

    @Test
    void testCalcularTarifaCarroHoraCheiaDescoberta(){
        Carro carro = new Carro("BRA2E19");
        AndarStub andar = new AndarStub(TipoVaga.DESCOBERTA);
        TicketStub ticket = new TicketStub(andar);

        double resultado = carro.CalcularTarifa(60, ticket);

        assertEquals(10.0, resultado, 0.01);
    }

    @Test
    void testCalcularTarifaCarroHoraCheiaCoberta(){
        Carro carro = new Carro("BRA2E19");
        AndarStub andar = new AndarStub(TipoVaga.COBERTA);
        TicketStub ticket = new TicketStub(andar);

        double resultado = carro.CalcularTarifa(60,ticket);

        assertEquals(11.0 , resultado ,0.01 );
    }

    @Test
    void testCalcularTarifaCarroHoraFracionadaDescoberta(){
        Carro carro = new Carro("BRA2E19");
        AndarStub andar = new AndarStub(TipoVaga.DESCOBERTA);
        TicketStub ticket = new TicketStub(andar);

        double resultado = carro.CalcularTarifa(85, ticket);

        assertEquals(12.08, resultado, 0.01);
    }
    @Test
    void testCalcularTarifaCarroHoraFracionadaCoberta(){
        Carro carro = new Carro("BRA2E19");
        AndarStub andar = new AndarStub(TipoVaga.COBERTA);
        TicketStub ticket = new TicketStub(andar);

        double resultado = carro.CalcularTarifa(85,ticket);

        assertEquals(13.08 , resultado ,0.01 );
    }

    @Test
    void testCalcularTarifaMotoHoraCheiaDescoberta(){
        Moto moto = new Moto("BRA2E19");
        AndarStub andar = new AndarStub(TipoVaga.DESCOBERTA);
        TicketStub ticket = new TicketStub(andar);

        double resultado = moto.CalcularTarifa(60, ticket);

        assertEquals(7.00, resultado, 0.01);
    }

    @Test
    void testCalcularTarifaMotoHoraCheiaCoberta(){
        Moto moto = new Moto("BRA2E19");
        AndarStub andar = new AndarStub(TipoVaga.COBERTA);
        TicketStub ticket = new TicketStub(andar);

        double resultado = moto.CalcularTarifa(60,ticket);

        assertEquals(8.00 , resultado ,0.01 );
    }

    @Test
    void testCalcularTarifaMotoHoraFracionadaDescoberta(){
        Moto moto = new Moto("BRA2E19");
        AndarStub andar = new AndarStub(TipoVaga.DESCOBERTA);
        TicketStub ticket = new TicketStub(andar);

        double resultado = moto.CalcularTarifa(85, ticket);

        assertEquals(7.83, resultado, 0.01);
    }
    @Test
    void testCalcularTarifaMotoHoraFracionadaCoberta(){
        Moto moto = new Moto("BRA2E19");
        AndarStub andar = new AndarStub(TipoVaga.COBERTA);
        TicketStub ticket = new TicketStub(andar);

        double resultado = moto.CalcularTarifa(85,ticket);

        assertEquals(8.83 , resultado ,0.01 );
    }



}
