package Factory;

public class Carro extends Veiculo {
    double valor;

    public Carro(String placa) {
        super(placa, TipoVeiculo.CARRO);
    }

    @Override
    public double CalcularTarifa(double minutos) {// Ticket ticket
        if (minutos <= 60) {
            valor = 10;
        } else {
            double minutosExedidos = minutos - 60;
            valor = 10 + (minutosExedidos * (5.0 / 60));
        }
    return valor;

    }
}
