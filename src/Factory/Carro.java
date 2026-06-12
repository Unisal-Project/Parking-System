package Factory;

import Camera.Andar;
import Camera.TipoVaga;
import builder.Ticket;

/**
 *
 * representa o tipo carro no sistema
 *@author Pedro Monteiro
 * @Verson 1.0
 */

public class Carro extends Veiculo {
    /** valor calculado da tarifa*/
    double valor;

    /**
     * constroi o tipo carro com uma placa
     * @param placa a placa do veiculo
     */
    public Carro(String placa) {
        super(placa, TipoVeiculo.CARRO);
    }

    /**
     * calcula a tarifa devida pelo carro com base no tempo de permanecia
     * @param minutos o tempo de permanecia do veiculo
     * @return o valor total que deve ser pago
     */
    @Override
    public double CalcularTarifa(double minutos, Ticket ticket) {
        if (minutos <= 60) {
            valor = 10;
        } else {
            double minutosExcedidos = minutos - 60;
            valor = 10 + (minutosExcedidos * (5.0 / 60));
        }

        Andar andar = ticket.getAndar();
        if (andar.getTipoVaga() == TipoVaga.COBERTA) {
            valor += 1.0;
        }

        return valor;
    }
}
