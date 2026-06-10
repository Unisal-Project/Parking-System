package Facade;
import Factory.*;
import builder.*;

public class ControleCapacidade {
    private int totalVagaCarro;
    private int vagasCarroOcupada;
    private int totalVagaMoto;
    private int vagaMotoOcupada;

    public ControleCapacidade(int totalVagas) {
        this.totalVagaCarro = (int) (totalVagas * 0.7);
        this.totalVagaMoto = (int) (totalVagas * 0.3);
        this.vagasCarroOcupada = 0;
        this.vagaMotoOcupada = 0;
    }

    public boolean temVagaDisponivel(TipoVeiculo tipo) {
        if (tipo == TipoVeiculo.CARRO) {
            return vagasCarroOcupada < totalVagaCarro;
        } else {
            return vagaMotoOcupada < totalVagaMoto;
        }
}

    public void incrementarVeiculo(TipoVeiculo tipo) {
        if (tipo == TipoVeiculo.CARRO) {
            vagasCarroOcupada++;
        } else {
            vagaMotoOcupada++;
        }
    }

    public void decrementarVeiculo(TipoVeiculo tipo){
        if (tipo == TipoVeiculo.CARRO) {
            vagasCarroOcupada--;
        } else {
            vagaMotoOcupada--;
        }
    }

    public int consultarDisponiveis(TipoVeiculo tipo) {
        if (tipo == TipoVeiculo.CARRO) {
            return totalVagaCarro - vagasCarroOcupada;
        } else {
            return totalVagaMoto - vagaMotoOcupada;
        }
    }

}
