package Factory;

public class Moto  extends Veiculo {
    double valor;

    public Moto(String placa) {
        super(placa, TipoVeiculo.MOTO);
    }

    @Override
    public double CalcularTarifa(double minutos) {
        if (minutos <= 60) {
            valor = 7.0;
        } else {
            double minutosExedidos = minutos - 60;
            valor = 7.0 + (minutosExedidos * (2.0 / 60));
        }
        return valor;
    }
}

