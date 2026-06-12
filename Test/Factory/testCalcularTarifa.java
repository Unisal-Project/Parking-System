package Factory;

import Camera.TipoVaga;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testCalcularTarifa {

    /**
     * RESUMO: Verificar o cálculo da tarifa de um carro considerando o
     * tempo de permanência e o tipo de vaga coberta ou descoberta
     * PRÉ CONDIÇÃO: Carro criado via Factory e Ticket associado a um
     * Andar com tipoVaga = DESCOBERTA
     * ENTRADAS: minutos = 60, tipoVaga = DESCOBERTA
     * AÇÃO: Chamar carro.CalcularTarifa(60, ticket)
     * RESULTADO: R$ 10,00
     * PÓS CONDIÇÃO: Valor calculado disponível para ser utilizado no
     * registro de pagamento
     */
    @Test
    void testCalcularTarifaCarroHoraCheiaDescoberta(){
        Carro carro = new Carro("BRA2E19");
        AndarStub andar = new AndarStub(TipoVaga.DESCOBERTA);
        TicketStub ticket = new TicketStub(andar);

        double resultado = carro.CalcularTarifa(60, ticket);

        assertEquals(10.0, resultado, 0.01);
    }

    /**
     * RESUMO: Verificar o cálculo da tarifa de um carro considerando o
     * tempo de permanência e o tipo de vaga coberta ou descoberta
     * PRÉ CONDIÇÃO: Carro criado via Factory e  Ticket associado a um
     * Andar com tipoVaga = COBERTA.
     * ENTRADAS: minutos = 60, tipoVaga = COBERTA
     * AÇÃO: Chamar carro.CalcularTarifa(60, ticket)
     * RESULTADO: R$ 11,00, R$ 10,00 + acréscimo de R$ 1,00 pela cobertura
     * PÓS CONDIÇÃO: Valor calculado disponível para ser utilizado no
     * registro de pagamento
     */
    @Test
    void testCalcularTarifaCarroHoraCheiaCoberta(){
        Carro carro = new Carro("BRA2E19");
        AndarStub andar = new AndarStub(TipoVaga.COBERTA);
        TicketStub ticket = new TicketStub(andar);

        double resultado = carro.CalcularTarifa(60,ticket);

        assertEquals(11.0 , resultado ,0.01 );
    }

    /**
     * RESUMO: Verificar o cálculo da tarifa de um carro considerando o
     * tempo de permanência e o tipo de vaga coberta ou descoberta
     * PRÉ CONDIÇÃO: Carro criado via Factory e  Ticket associado a um
     * Andar com tipoVaga = DESCOBERTA.
     * ENTRADAS: minutos = 85, tipoVaga = DESCOBERTA
     * AÇÃO: Chamar carro.CalcularTarifa(85, ticket).
     * RESULTADO: R$ 12,08, R$ 10,00 + 25min excedentes × R$5,00/60min
     * PÓS CONDIÇÃO: Valor calculado disponível para ser utilizado no
     * registro de pagamento
     */
    @Test
    void testCalcularTarifaCarroHoraFracionadaDescoberta(){
        Carro carro = new Carro("BRA2E19");
        AndarStub andar = new AndarStub(TipoVaga.DESCOBERTA);
        TicketStub ticket = new TicketStub(andar);

        double resultado = carro.CalcularTarifa(85, ticket);

        assertEquals(12.08, resultado, 0.01);
    }

    /**
     * RESUMO: Verificar o cálculo da tarifa de um carro considerando o
     * tempo de permanência e o tipo de vaga coberta ou descoberta
     * PRÉ CONDIÇÃO: Carro criado via Factory e Ticket associado a um
     * Andar com tipoVaga = COBERTA.
     * ENTRADAS: minutos = 85, tipoVaga = COBERTA
     * AÇÃO: Chamar carro.CalcularTarifa(85, ticket)
     * RESULTADO: R$ 13,08, R$ 12,08 + acréscimo de R$ 1,00 pela cobertura
     * PÓS CONDIÇÃO: Valor calculado disponível para ser utilizado no
     * registro de pagamento
     */
    @Test
    void testCalcularTarifaCarroHoraFracionadaCoberta(){
        Carro carro = new Carro("BRA2E19");
        AndarStub andar = new AndarStub(TipoVaga.COBERTA);
        TicketStub ticket = new TicketStub(andar);

        double resultado = carro.CalcularTarifa(85,ticket);

        assertEquals(13.08 , resultado ,0.01 );
    }

    /**
     * RESUMO: Verificar o cálculo da tarifa de uma moto considerando o
     * tempo de permanência e o tipo de vaga coberta ou descoberta
     * PRÉ CONDIÇÃO: Moto criada via Factory e Ticket associado a um
     * Andar com tipoVaga = DESCOBERTA
     * ENTRADAS: minutos = 60, tipoVaga = DESCOBERTA
     * AÇÃO: Chamar moto.CalcularTarifa(60, ticket)
     * RESULTADO: R$ 7,00
     * PÓS CONDIÇÃO: Valor calculado disponível para ser utilizado no
     * registro de pagamento
     */
    @Test
    void testCalcularTarifaMotoHoraCheiaDescoberta(){
        Moto moto = new Moto("BRA2E19");
        AndarStub andar = new AndarStub(TipoVaga.DESCOBERTA);
        TicketStub ticket = new TicketStub(andar);

        double resultado = moto.CalcularTarifa(60, ticket);

        assertEquals(7.00, resultado, 0.01);
    }

    /**
     * RESUMO: Verificar o cálculo da tarifa de uma moto considerando o
     * tempo de permanência e o tipo de vaga coberta ou descoberta
     * PRÉ CONDIÇÃO: Moto criada via Factory e  Ticket associado a um
     * Andar com tipoVaga = COBERTA
     * ENTRADAS: minutos = 60, tipoVaga = COBERTA
     * AÇÃO: Chamar moto.CalcularTarifa(60, ticket).
     * RESULTADO: R$ 8,00, R$ 7,00 + acréscimo de R$ 1,00 pela cobertura
     * PÓS CONDIÇÃO: Valor calculado disponível para ser utilizado no
     * registro de pagamento
     */
    @Test
    void testCalcularTarifaMotoHoraCheiaCoberta(){
        Moto moto = new Moto("BRA2E19");
        AndarStub andar = new AndarStub(TipoVaga.COBERTA);
        TicketStub ticket = new TicketStub(andar);

        double resultado = moto.CalcularTarifa(60,ticket);

        assertEquals(8.00 , resultado ,0.01 );
    }

    /**
     * RESUMO: Verificar o cálculo da tarifa de uma moto considerando o
     * tempo de permanência e o tipo de vaga coberta ou descoberta
     * PRÉ CONDIÇÃO: Moto criada via Factory e  Ticket associado a um
     * Andar com tipoVaga = DESCOBERTA.
     * ENTRADAS: minutos = 85, tipoVaga = DESCOBERTA
     * AÇÃO: Chamar moto.CalcularTarifa(85, ticket).
     * RESULTADO: R$ 7,83, R$ 7,00 + 25min excedentes × R$2,00/60min
     * PÓS CONDIÇÃO: Valor calculado disponível para ser utilizado no
     * registro de pagamento
     */
    @Test
    void testCalcularTarifaMotoHoraFracionadaDescoberta(){
        Moto moto = new Moto("BRA2E19");
        AndarStub andar = new AndarStub(TipoVaga.DESCOBERTA);
        TicketStub ticket = new TicketStub(andar);

        double resultado = moto.CalcularTarifa(85, ticket);

        assertEquals(7.83, resultado, 0.01);
    }

    /**
     * RESUMO: Verificar o cálculo da tarifa de uma moto considerando o
     * tempo de permanência e o tipo de vaga coberta ou descoberta
     * PRÉ CONDIÇÃO: Moto criada via Factory e  Ticket associado a um
     * Andar com tipoVaga = COBERTA.
     * ENTRADAS: minutos = 85, tipoVaga = COBERTA
     * AÇÃO: Chamar moto.CalcularTarifa(85, ticket).
     * RESULTADO: R$ 8,83, R$ 7,83 + acréscimo de R$ 1,00 pela cobertura
     * PÓS CONDIÇÃO: Valor calculado disponível para ser utilizado no
     * registro de pagamento
     */
    @Test
    void testCalcularTarifaMotoHoraFracionadaCoberta(){
        Moto moto = new Moto("BRA2E19");
        AndarStub andar = new AndarStub(TipoVaga.COBERTA);
        TicketStub ticket = new TicketStub(andar);

        double resultado = moto.CalcularTarifa(85,ticket);

        assertEquals(8.83 , resultado ,0.01 );
    }

}