package Facade;

import Factory.TipoVeiculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe responsável por testar os comportamentos da classe ControleCapacidade.
 * 
 * Este teste utiliza apenas a API pública da classe para validar:
 * - A regra de negócio de distribuição de vagas (70% Carros / 30% Motos).
 * - O funcionamento do método de consulta de vagas disponíveis.
 * - O impacto de entradas e saídas no saldo de vagas.
 */
public class ControleCapacidadeTest {

    private ControleCapacidade controle;
    private final int TOTAL_VAGAS = 100;

    @BeforeEach
    void setUp() {
        // Inicializa a classe com 100 vagas para facilitar os cálculos de porcentagem
        controle = new ControleCapacidade(TOTAL_VAGAS);
    }

    @Test
    void TestarDistribuicaoInicialVagas() {
        // Verifica se a regra de 70% para carros e 30% para motos foi aplicada no construtor
        assertEquals(70, controle.consultarDisponiveis(TipoVeiculo.CARRO), "Deveria iniciar com 70 vagas para carros.");
        assertEquals(30, controle.consultarDisponiveis(TipoVeiculo.MOTO), "Deveria iniciar com 30 vagas para motos.");
    }

    @Test
    void TestarIncrementoEVagasDisponiveis() {
        // Simula a entrada de um carro
        controle.incrementarVeiculo(TipoVeiculo.CARRO);
        assertEquals(69, controle.consultarDisponiveis(TipoVeiculo.CARRO), "Vagas de carro deveriam diminuir para 69.");

        // Simula a entrada de uma moto
        controle.incrementarVeiculo(TipoVeiculo.MOTO);
        assertEquals(29, controle.consultarDisponiveis(TipoVeiculo.MOTO), "Vagas de moto deveriam diminuir para 29.");
    }

    @Test
    void TestarDecrementoEVagasDisponiveis() {
        // Simula entrada e saída
        controle.incrementarVeiculo(TipoVeiculo.CARRO);
        controle.decrementarVeiculo(TipoVeiculo.CARRO);
        
        assertEquals(70, controle.consultarDisponiveis(TipoVeiculo.CARRO), "Vagas de carro deveriam voltar para 70 após saída.");
    }

    @Test
    void TestarLimiteDeVagas() {
        // Enche todas as vagas de carro (70)
        for (int i = 0; i < 70; i++) {
            controle.incrementarVeiculo(TipoVeiculo.CARRO);
        }
        
        assertFalse(controle.temVagaDisponivel(TipoVeiculo.CARRO), "Não deveria haver vagas disponíveis após 70 carros.");
        assertEquals(0, controle.consultarDisponiveis(TipoVeiculo.CARRO), "O saldo de vagas deveria ser 0.");
    }
}
