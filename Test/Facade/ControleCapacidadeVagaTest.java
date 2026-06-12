package Facade;

import Factory.TipoVeiculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste dedicada a validar a lógica de "Vaga Disponível" no ControleCapacidade.
 * 
 * Foca especificamente no método temVagaDisponivel e como ele se comporta
 * conforme o preenchimento do estacionamento ocorre.
 */
public class ControleCapacidadeVagaTest {

    private ControleCapacidade controle;
    private final int TOTAL_VAGAS = 10; // 7 Carros, 3 Motos

    @BeforeEach
    void setUp() {
        controle = new ControleCapacidade(TOTAL_VAGAS);
    }

    @Test
    void TestarVagaDisponivelInicialmente() {
        // Inicialmente todas as vagas devem estar disponíveis
        assertTrue(controle.temVagaDisponivel(TipoVeiculo.CARRO), "Deveria ter vaga para carro inicialmente.");
        assertTrue(controle.temVagaDisponivel(TipoVeiculo.MOTO), "Deveria tener vaga para moto inicialmente.");
    }

    @Test
    void TestarEsgotamentoDeVagasCarro() {
        // Preenche todas as 7 vagas de carro
        for (int i = 0; i < 7; i++) {
            assertTrue(controle.temVagaDisponivel(TipoVeiculo.CARRO), "Deveria ter vaga para o carro " + (i+1));
            controle.incrementarVeiculo(TipoVeiculo.CARRO);
        }

        // Agora não deve ter mais vagas para carros
        assertFalse(controle.temVagaDisponivel(TipoVeiculo.CARRO), "Não deveria ter mais vagas para carros.");
        
        // Mas ainda deve ter para motos
        assertTrue(controle.temVagaDisponivel(TipoVeiculo.MOTO), "Motos ainda deveriam ter vagas (vagas independentes).");
    }

    @Test
    void TestarEsgotamentoDeVagasMoto() {
        // Preenche todas as 3 vagas de moto
        for (int i = 0; i < 3; i++) {
            assertTrue(controle.temVagaDisponivel(TipoVeiculo.MOTO), "Deveria ter vaga para a moto " + (i+1));
            controle.incrementarVeiculo(TipoVeiculo.MOTO);
        }

        // Agora não deve ter mais vagas para motos
        assertFalse(controle.temVagaDisponivel(TipoVeiculo.MOTO), "Não deveria ter mais vagas para motos.");
        
        // Mas ainda deve ter para carros
        assertTrue(controle.temVagaDisponivel(TipoVeiculo.CARRO), "Carros ainda deveriam ter vagas.");
    }

    @Test
    void TestarLiberacaoDeVaga() {
        // Enche as vagas de carro
        for (int i = 0; i < 7; i++) {
            controle.incrementarVeiculo(TipoVeiculo.CARRO);
        }
        assertFalse(controle.temVagaDisponivel(TipoVeiculo.CARRO));

        // Decrementa um carro (saiu um veículo)
        controle.decrementarVeiculo(TipoVeiculo.CARRO);

        // A vaga deve estar disponível novamente
        assertTrue(controle.temVagaDisponivel(TipoVeiculo.CARRO), "Vaga de carro deveria estar disponível após saída.");
    }
}
