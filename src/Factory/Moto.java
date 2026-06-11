package Factory;

/**
 * representa o tipo moto no sistema
 */

public class Moto  extends Veiculo {
   /** valor calculado da tarifa*/
    double valor;

    /**
     * constroi o tipo moto com uma placa
     * @param placa a placa do veiculo
     */
    public Moto(String placa) {
        super(placa, TipoVeiculo.MOTO);
    }

    /**
     * calcula a tarifa devida pela moto com base no tempo de permanecia
     * @param minutos o tempo de permanecia do veiculo
     * @return o valor total que deve ser pago
     */
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

