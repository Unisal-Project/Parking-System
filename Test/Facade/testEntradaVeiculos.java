package Facade;

import Factory.Carro;
import Factory.Moto;
import Factory.TipoVeiculo;
import Factory.Veiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Pedro Monteiro
 *  @Verson 1.0
 */

public class testEntradaVeiculos {

    /**
     * RESUMO: Verificar se o sistema registra corretamente a entrada de
     * um veículo quando há vaga disponível para o seu tipo.
     * PRÉ CONDIÇÃO: EstacionamentoFacade iniciado com totalVagas = 10
     * ENTRADAS: placa="BRA2E19", tipo=CARRO
     * AÇÃO: Chamar facade.registrarEntrada(placa, tipo).
     * RESULTADO: Retorna uma instância de Carro e a contagem de vagas
     * ocupadas para carro é incrementada em 1.
     * PÓS CONDIÇÃO: Veículo registrado e contabilizado em
     * ControleCapacidade; vaga de carro passa a constar como ocupada.
     */
    @Test
    void testRegistrarEntradaCarroComVaga(){
        EstacionamentoFacade facade = new EstacionamentoFacade(10);

        Veiculo veiculo = facade.registrarEntrada("BRA2E19", TipoVeiculo.CARRO);

        Assertions.assertTrue(veiculo instanceof Carro);

    }

    /**
     * RESUMO: Verificar se o sistema impede o registro de entrada
     * quando não há vagas disponíveis para o tipo de veículo.
     * PRÉ CONDIÇÃO: EstacionamentoFacade iniciado com totalVagas = 0
     * ENTRADAS: placa="BRA2E19", tipo=CARRO
     * AÇÃO: Chamar facade.registrarEntrada(placa, tipo).
     * RESULTADO: O método lança IllegalStateException, informando que
     * não há vagas disponíveis para o tipo carro.
     * PÓS CONDIÇÃO: Nenhum veículo é registrado e contagem de vagas
     * ocupadas permanece iguais.
     */
    @Test
    void testRegistrarEntradaCarroSemVaga(){
        EstacionamentoFacade facade = new EstacionamentoFacade(0);

        assertThrows(IllegalStateException.class, () -> {
            facade.registrarEntrada("BRA2E19", TipoVeiculo.CARRO);
        });
    }

    /**
     * RESUMO: Verificar se o sistema registra corretamente a entrada de
     * um veículo quando há vaga disponível para o seu tipo.
     * PRÉ CONDIÇÃO: EstacionamentoFacade iniciado com totalVagas = 10
     * ENTRADAS: placa="BRA2E19", tipo=MOTO
     * AÇÃO: Chamar facade.registrarEntrada(placa, tipo).
     * RESULTADO: Retorna uma instância de Moto e a contagem de vagas
     * ocupadas para moto é incrementada em 1.
     * PÓS CONDIÇÃO: Veículo registrado e contabilizado em
     * ControleCapacidade; vaga de moto passa a constar como ocupada.
     */
    @Test
    void testRegistrarEntradaMotoComVaga(){
        EstacionamentoFacade facade = new EstacionamentoFacade(10);

        Veiculo veiculo = facade.registrarEntrada("BRA2E19", TipoVeiculo.MOTO);

        Assertions.assertTrue(veiculo instanceof Moto);

    }

    /**
     * RESUMO: Verificar se o sistema impede o registro de entrada
     * quando não há vagas disponíveis para o tipo de veículo.
     * PRÉ CONDIÇÃO: EstacionamentoFacade iniciado com totalVagas = 0
     * (0 vagas para carro e 0 para moto).
     * ENTRADAS: placa="BRA2E19", tipo=MOTO
     * AÇÃO: Chamar facade.registrarEntrada(placa, tipo).
     * RESULTADO: O método lança IllegalStateException, informando que
     * não há vagas disponíveis para o tipo moto.
     * PÓS CONDIÇÃO: Nenhum veículo é registrado e contagem de vagas
     * ocupadas permanece iguais
     */
    @Test
    void testRegistrarEntradaMotoSemVaga(){
        EstacionamentoFacade facade = new EstacionamentoFacade(0);

        assertThrows(IllegalStateException.class, () -> {
            facade.registrarEntrada("BRA2E19", TipoVeiculo.MOTO);
        });
    }

}