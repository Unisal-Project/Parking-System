package Facade;
import Factory.*;
import builder.*;

/**
 * controla a capacidade de vagas no estacionamento
 *  sendo 70% do total de vagas para carros
 *  e 30% disponiveis para motos
 */
public class ControleCapacidade {
    /**
     * numeros total de vagas destinadas a carros
     * numeros de vagas para carros atualmente ocupadas
     *  numeros total de vagas destinadas a motos
     *  numeros de vagas para motos atualmente ocupadas
     */
    private int totalVagaCarro;
    private int vagasCarroOcupada;
    private int totalVagaMoto;
    private int vagaMotoOcupada;

    /**
     * Constrói o controle de capacidade com base no total de vagas
     * sendo 70% do total de vagas para carros
     *  e 30% disponiveis para motos
     * @param totalVagas numero total de vagas do estacionamento
     */
    public ControleCapacidade(int totalVagas) {
        this.totalVagaCarro = (int) (totalVagas * 0.7);
        this.totalVagaMoto = (int) (totalVagas * 0.3);
        this.vagasCarroOcupada = 0;
        this.vagaMotoOcupada = 0;
    }

    /**
     * Verifica se há vaga disponível para o tipo de veículo informado
     * @param tipo o tipo de veículo carro ou moto
     * @return true se houver vaga e false se não houver vaga disponiveis
     */
    public boolean temVagaDisponivel(TipoVeiculo tipo) {
        if (tipo == TipoVeiculo.CARRO) {
            return vagasCarroOcupada < totalVagaCarro;
        } else {
            return vagaMotoOcupada < totalVagaMoto;
        }
}

    /**
     * Incrementa a contagem de vagas ocupadas para o tipo de veículo informado
     * @param tipo o tipo de veículo carro ou moto
     */
    public void incrementarVeiculo(TipoVeiculo tipo) {
        if (tipo == TipoVeiculo.CARRO) {
            vagasCarroOcupada++;
        } else {
            vagaMotoOcupada++;
        }
    }
    /**
     * decrementa a contagem de vagas ocupadas para o tipo de veículo informado
     * @param tipo o tipo de veículo carro ou moto
     */
    public void decrementarVeiculo(TipoVeiculo tipo){
        if (tipo == TipoVeiculo.CARRO) {
            vagasCarroOcupada--;
        } else {
            vagaMotoOcupada--;
        }
    }
    /**
     * Consulta a quantidade de vagas disponiveis para o tipo de veículo informado
     *
     * @param tipo o tipo de veículo carros ou motos
     * @return o numero de vagas livres para o tipo informado
     */
    public int consultarDisponiveis(TipoVeiculo tipo) {
        if (tipo == TipoVeiculo.CARRO) {
            return totalVagaCarro - vagasCarroOcupada;
        } else {
            return totalVagaMoto - vagaMotoOcupada;
        }
    }

}
