package Facade;

import Camera.Andar;
import Factory.*;
import Strategy.*;
import auth.*;
import builder.*;

/**
 * centraliza e simplifica  o sistema e as principais operações
 */
public class EstacionamentoFacade {
    /** controle de capacidade de vagass do estacionametno*/

    private ControleCapacidade controleCapacidade;

    /**
     * inicializa o controle de capacidade com o total de vaggas informadas
     * @param totalVagas o numero total de vagas no estacionamento
     */
    public EstacionamentoFacade(int totalVagas) {
        this.controleCapacidade = new ControleCapacidade(totalVagas);
    }

    /**
     * registra a entrada de um veiculo no estacionamento
     * @param placa placa do veiculo
     * @param tipo o tipo do veiculo moto ou carro
     * @return veiculo criado
     */
    public Veiculo registrarEntrada(String placa, TipoVeiculo tipo){
        Veiculo veiculo = VeiculoFactory.criarVeiculo(placa, tipo);

        System.out.println("Entrada registrada com sucesso");
        System.out.println("Placa: " + placa);
        System.out.println("Tipo: " + tipo);

        return veiculo;
    }

    /**
     *  Registra o pagamento de um valor utilizando o metodo de pagamento informado.
     * @param valor valor a ser pago
     * @param metodoPagamento metodo de pagamento escolido
     * @return o valor final do pagamento
     */
    public double registrarPagamento(double valor, MetodoPagamento metodoPagamento){
        Pagamento pagamento = new Pagamento(metodoPagamento);

        double valorFinal = pagamento.realizarPagamento(valor);

        System.out.println("Pagamento realizado com sucesso");
        System.out.println("Valor final: R$ " + valorFinal);

        return valorFinal;
    }

    /**
     * Registra a saída de um veículo do estacionamento.
     * @param ticket o ticket referente ao veículo que está saindo
     * @return true se a cancela for aberta e false se o pagamento estiver pendente
     */
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

    /**
     * atualiza a localização de um ticket desde que haja vaga
     * @param ticket o ticket atual cuja a localização é atualizada
     * @param novoAndar o andar para qual o veiculo foi movido
     * @return true se a localização for atualizada e false se não houver vagas disponiveis
     */
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