package Factory;

import Camera.Andar;
import Camera.TipoVaga;
import builder.Ticket;

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
    public double CalcularTarifa(double minutos, Ticket ticket) {
        if (minutos <= 60) {
            valor = 7.0;
        } else {
            double minutosExcedidos = minutos - 60;
            valor = 7.0 + (minutosExcedidos * (2.0 / 60));
        }

        Andar andar = ticket.getAndar();
        if (andar.getTipoVaga() == TipoVaga.COBERTA) {
            valor += 1.0;
        }

        return valor;
    }
}

