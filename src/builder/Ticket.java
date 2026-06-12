package builder;
import Camera.Andar;
import Factory.Veiculo;
import Strategy.Pagamento;

import java.time.LocalDateTime;

/**
 * Representa um ticket de estacionamento contendo informações sobre a permanência do veículo.
 * Armazena dados de entrada, saída, veículo associado, status do pagamento e localização.
 */
public class Ticket {

    /** Identificador único do ticket. */
    private int id;
    /** Data e hora de entrada do veículo. */
    private LocalDateTime dataEntrada;
    /** Data e hora de saída do veículo. */
    private LocalDateTime dataSaida;
    /** Veículo associado ao ticket. */
    private Veiculo veiculo;
    /** Status atual do ticket (ex: PENDENTE_PAGAMENTO, PAGO). */
    private StatusTicket status;
    /** Método de pagamento utilizado. */
    private Pagamento pagamento;
    /** Andar onde o veículo foi estacionado. */
    private Andar andar;

    /**
     * Verifica se o ticket já foi pago ou finalizado.
     * @return true se o status for PAGO ou FINALIZADO.
     */
    public boolean estaPago() {
        return this.status == StatusTicket.PAGO || this.status == StatusTicket.FINALIZADO;
    }

    /**
     * Altera o status do ticket para FINALIZADO.
     */
    public void finalizar() {
        this.status = StatusTicket.FINALIZADO;
    }

    /**
     * Define o veículo associado ao ticket.
     * @param veiculo O veículo estacionado.
     */
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    /**
     * Define a data e hora de entrada.
     * @param dataEntrada Momento da entrada.
     */
    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * Define o status do ticket.
     * @param status Novo status.
     */
    public void setStatus(StatusTicket status) {
        this.status = status;
    }

    /**
     * Define a data e hora de saída.
     * @param dataSaida Momento da saída.
     */
    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    /**
     * Define o objeto de pagamento associado.
     * @param pagamento Estratégia de pagamento.
     */
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    /**
     * Define o andar de localização do veículo.
     * @param andar O andar onde o veículo está.
     */
    public void setAndar(Andar andar) {
        this.andar = andar;
    }

    // Métodos Getter
    public int getId() { return id; }
    public LocalDateTime getDataEntrada() { return dataEntrada; }
    public LocalDateTime getDataSaida() { return dataSaida; }
    public Veiculo getVeiculo() { return veiculo; }
    public StatusTicket getStatus() { return status; }
    public Pagamento getPagamento() { return pagamento; }
    public Andar getAndar() { return andar; }
}
