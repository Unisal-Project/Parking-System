package builder;
import Camera.Andar;
import Factory.Veiculo;
import Strategy.Pagamento;

import java.time.LocalDateTime;

public class Ticket {

    private int id;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private Veiculo veiculo;
    private StatusTicket status;
    private Pagamento pagamento;
    private Andar andar;

    public boolean estaPago() {
        return this.status == StatusTicket.PAGO || this.status == StatusTicket.FINALIZADO;
    }
    public void finalizar() {
        this.status = StatusTicket.FINALIZADO;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setStatus(StatusTicket status) {
        this.status = status;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void setAndar(Andar andar) {
        this.andar = andar;
    }

    public int getId() { return id; }
    public LocalDateTime getDataEntrada() { return dataEntrada; }
    public LocalDateTime getDataSaida() { return dataSaida; }
    public Veiculo getVeiculo() { return veiculo; }
    public StatusTicket getStatus() { return status; }
    public Pagamento getPagamento() { return pagamento; }
    public Andar getAndar() { return andar; }
}
