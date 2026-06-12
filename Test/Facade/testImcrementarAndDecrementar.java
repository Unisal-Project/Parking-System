package Facade;
import Factory.TipoVeiculo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Pedro Monteiro
 *  @Verson 1.0
 */

public class testImcrementarAndDecrementar {

    /**
     * RESUMO: Verificar se o controle de capacidade atualiza corretamente a
     * contagem de vagas disponíveis ao incrementar a ocupação de carros.
     * PRÉ CONDIÇÃO: ControleCapacidade iniciado com totalVagas = 10
     * ENTRADAS: incrementarVeiculo, carro
     * AÇÃO: Chamar consultarDisponiveis(CARRO) após o incremento.
     * RESULTADO: consultarDisponiveis(CARRO) = 6.
     * PÓS CONDIÇÃO: Contador de carros ocupados refletindo a entrada registrada.
     */
    @Test
    void testIncrementarVeiculoCarro(){
        ControleCapacidade controle = new ControleCapacidade(10);

        controle.incrementarVeiculo(TipoVeiculo.CARRO);

        assertEquals (6 , controle.consultarDisponiveis(TipoVeiculo.CARRO));

    }

    /**
     * RESUMO: Verificar se o controle de capacidade atualiza corretamente a
     * contagem de vagas disponíveis ao incrementar e decrementar a ocupação de carros.
     * PRÉ CONDIÇÃO: ControleCapacidade iniciado com totalVagas = 10
     * ENTRADAS: incrementarVeiculo(CARRO), em seguida de decrementarVeiculo(CARRO)
     * AÇÃO: Chamar consultarDisponiveis(CARRO) após as duas operações.
     * RESULTADO: consultarDisponiveis(CARRO) = 7.
     * PÓS CONDIÇÃO: Contador de carros ocupados retorna ao valor original
     * após entrada e saída.
     */
    @Test
    void testDecrementarVeiculoCarro(){
        ControleCapacidade controle = new ControleCapacidade(10);

        controle.incrementarVeiculo(TipoVeiculo.CARRO);
        controle.decrementarVeiculo(TipoVeiculo.CARRO);

        assertEquals (7 , controle.consultarDisponiveis(TipoVeiculo.CARRO));

    }

    /**
     * RESUMO: Verificar se o controle de capacidade atualiza corretamente a
     * contagem de vagas disponíveis ao incrementar a ocupação de motos.
     * PRÉ CONDIÇÃO: ControleCapacidade iniciado com totalVagas = 10
     * ENTRADAS: incrementarVeiculo(MOTO)
     * AÇÃO: Chamar consultarDisponiveis(MOTO) após o incremento.
     * RESULTADO: consultarDisponiveis(MOTO) = 2.
     * PÓS CONDIÇÃO: Contador de motos ocupadas refletindo a entrada registrada.
     */
    @Test
    void testIncrementarVeiculoMoto(){
        ControleCapacidade controle = new ControleCapacidade(10);

        controle.incrementarVeiculo(TipoVeiculo.MOTO);

        assertEquals (2 , controle.consultarDisponiveis(TipoVeiculo.MOTO));

    }

    /**
     * RESUMO: Verificar se o controle de capacidade atualiza corretamente a
     * contagem de vagas disponíveis ao incrementar e decrementar a ocupação de motos.
     * PRÉ CONDIÇÃO: ControleCapacidade iniciado com totalVagas = 10
     * ENTRADAS: incrementarVeiculo(MOTO) seguido de decrementarVeiculo(MOTO)
     * AÇÃO: Chamar consultarDisponiveis(MOTO) após as duas operações.
     * RESULTADO: consultarDisponiveis(MOTO) = 3.
     * PÓS CONDIÇÃO: Contador de motos ocupadas retorna ao valor original
     * após entrada e saída.
     */
    @Test
    void testDecrementarVeiculoMoto(){
        ControleCapacidade controle = new ControleCapacidade(10);

        controle.incrementarVeiculo(TipoVeiculo.MOTO);
        controle.decrementarVeiculo(TipoVeiculo.MOTO);

        assertEquals (3 , controle.consultarDisponiveis(TipoVeiculo.MOTO));

    }

}