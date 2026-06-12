package Facade;

import Factory.Carro;
import Factory.Moto;
import Factory.TipoVeiculo;
import Factory.Veiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testEntradaVeiculos {

    @Test
    void testRegistrarEntradaCarroComVaga(){
        EstacionamentoFacade facade = new EstacionamentoFacade(10);

        Veiculo veiculo = facade.registrarEntrada("BRA2E19", TipoVeiculo.CARRO);

        Assertions.assertTrue(veiculo instanceof Carro);

    }

    @Test
    void testRegistrarEntradaCarroSemVaga(){
        EstacionamentoFacade facade = new EstacionamentoFacade(0);

        assertThrows(IllegalStateException.class, () -> {
            facade.registrarEntrada("BRA2E19", TipoVeiculo.CARRO);
        });
    }
    @Test
    void testRegistrarEntradaMotoComVaga(){
        EstacionamentoFacade facade = new EstacionamentoFacade(10);

        Veiculo veiculo = facade.registrarEntrada("BRA2E19", TipoVeiculo.MOTO);

        Assertions.assertTrue(veiculo instanceof Moto);

    }

    @Test
    void testRegistrarEntradaMotoSemVaga(){
        EstacionamentoFacade facade = new EstacionamentoFacade(0);

        assertThrows(IllegalStateException.class, () -> {
            facade.registrarEntrada("BRA2E19", TipoVeiculo.MOTO);
        });
    }

}

