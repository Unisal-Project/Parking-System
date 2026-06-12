package Factory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testCriarVeiculo {

    /**
     * RESUMO: Verificar se VeiculoFactory cria a instância correta de
     * acordo com o tipo de veículo informado.
     * PRÉ CONDIÇÃO: Sistema iniciado; enum TipoVeiculo disponível com
     * os valores CARRO e MOTO.
     * ENTRADAS: placa="BRA2E19", tipo=CARRO
     * AÇÃO: Chamar VeiculoFactory.criarVeiculo(placa, tipo).
     * RESULTADO: Objeto retornado é uma instância de Carro.
     * PÓS CONDIÇÃO: Objeto Veiculo criado e disponível para registro
     * de entrada no estacionamento.
     */
    @Test
    void testCriarVeiculoCarro() {
        Veiculo veiculo = VeiculoFactory.criarVeiculo("BRA2E19", TipoVeiculo.CARRO);

        assertTrue(veiculo instanceof Carro);
    }

    /**
     * RESUMO: Verificar se VeiculoFactory cria a instância correta de
     * acordo com o tipo de veículo informado.
     * PRÉ CONDIÇÃO: Sistema iniciado; enum TipoVeiculo disponível com
     * os valores CARRO e MOTO.
     * ENTRADAS: placa="BRA2E19", tipo=MOTO
     * AÇÃO: Chamar VeiculoFactory.criarVeiculo(placa, tipo).
     * RESULTADO: Objeto retornado é uma instância de Moto.
     * PÓS CONDIÇÃO: Objeto Veiculo criado e disponível para registro
     * de entrada no estacionamento.
     */
    @Test
    void testCriarVeiculoMoto() {
        Veiculo veiculo = VeiculoFactory.criarVeiculo("BRA2E19", TipoVeiculo.MOTO);

        assertTrue(veiculo instanceof Moto);
    }

    /**
     * RESUMO: Verificar se o sistema impede a criação de um veículo
     * quando a placa não é informada.
     * PRÉ CONDIÇÃO: Sistema iniciado; VeiculoFactory disponível.
     * ENTRADAS: placa = null, tipo = CARRO
     * AÇÃO: Chamar VeiculoFactory.criarVeiculo(null, TipoVeiculo.CARRO).
     * RESULTADO: O método lança IllegalArgumentException
     * "Placa não pode ser nula!".
     * PÓS CONDIÇÃO: Nenhum veículo é criado; nenhuma vaga é ocupada.
     */
    @Test
    void testCriarVeiculoPlacaNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            VeiculoFactory.criarVeiculo(null, TipoVeiculo.CARRO);
        });

    }

    /**
     * RESUMO: Verificar se o sistema impede a criação de um veículo
     * quando o tipo informado não é reconhecido.
     * PRÉ CONDIÇÃO: Sistema iniciado; VeiculoFactory disponível.
     * ENTRADAS: placa = "ABC1234", tipo = null
     * AÇÃO: Chamar VeiculoFactory.criarVeiculo
     * RESULTADO: O método lança IllegalArgumentException
     * "Tipo de veículo inválido: null".
     * PÓS CONDIÇÃO: Nenhum veículo é criado; nenhuma vaga é ocupada.
     */
    @Test
    void testCriarVeiculoTipoNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            VeiculoFactory.criarVeiculo("ABC1234", null);
        });
    }

}