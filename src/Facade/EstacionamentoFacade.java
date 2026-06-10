package Facade;

import Camera.Andar;
import Factory.*;
import Strategy.*;
import auth.*;
import builder.*;

public class EstacionamentoFacade {
    private ControleCapacidade controleCapacidade;

    public EstacionamentoFacade(int totalVagas) {
        this.controleCapacidade = new ControleCapacidade(totalVagas);
    }

    public Veiculo registrarEntrada(String placa, TipoVeiculo tipo){
        Veiculo veiculo = VeiculoFactory.criarVeiculo(placa, tipo);

        System.out.println("Entrada registrada com sucesso");
        System.out.println("Placa: " + placa);
        System.out.println("Tipo: " + tipo);

        return veiculo;
    }

    public double registrarPagamento(double valor, MetodoPagamento metodoPagamento){
        Pagamento pagamento = new Pagamento(metodoPagamento);

        double valorFinal = pagamento.realizarPagamento(valor);

        System.out.println("Pagamento realizado com sucesso");
        System.out.println("Valor final: R$ " + valorFinal);

        return valorFinal;
    }
    public boolean registrarSaida(Ticket ticket) {

        if (!ticket.estaPago()) {
            System.out.println("Pagamento pendente. Cancela permanece fechada.");
            return false;
        }

        Andar andar = ticket.getAndar();
        Cancela cancela = new Cancela(andar);

        boolean cancelaAberta = cancela.abrirCancela();

        ticket.finalizar();

        System.out.println("Pagamento confirmado. Cancela liberada.");
        System.out.println("Status do ticket: " + ticket.getStatus());

        return cancelaAberta;
    }

    public boolean atualizarLocalizacao(Ticket ticket, Andar novoAndar) {

        TipoVeiculo tipo = ticket.getVeiculo().getTipoVeiculo();

        if (controleCapacidade.temVagaDisponivel(tipo)) {
            ticket.setAndar(novoAndar);
            System.out.println("Localização atualizada para: Andar " + novoAndar.getNumero());
            return true;
        } else {
            System.out.println("Sem vaga disponível no novo andar. Localização mantida.");
            return false;
        }
    }

}