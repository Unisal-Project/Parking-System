package Factory;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class testCriarVeiculoCarrro {

    @Test
    void testCriarVeiculoCarro() {
        Veiculo veiculo = VeiculoFactory.criarVeiculo("BRA2E19", TipoVeiculo.CARRO);

        assertTrue(veiculo instanceof Carro);
    }

    @Test
    void testCriarVeiculoMoto() {
        Veiculo veiculo = VeiculoFactory.criarVeiculo("BRA2E19", TipoVeiculo.MOTO);

        assertTrue(veiculo instanceof Moto);
    }

    @Test
    void testCriarVeiculoPlacaNull() {
         assertThrows(IllegalArgumentException.class, () -> {
            VeiculoFactory.criarVeiculo(null, TipoVeiculo.CARRO);
        });

    }

    @Test
    void testCriarVeiculoTipoNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            VeiculoFactory.criarVeiculo("ABC1234", null);
        });
    }

    }

