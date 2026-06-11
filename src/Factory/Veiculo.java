package Factory;

/**
 * classe que representa um veiculo no sistema de estacionamento
 * metodo de calculo de tarifa que devem ser implementadas em cada tipo
 */

public abstract class Veiculo {
    /**
     * placa do veiculo
     * tipo do veiculo , moto ou carro
     */
     private String placa;
     private TipoVeiculo  tipo;

    /**
     * constroi um veiculo com a placa e o tipo
     * @param placa a placa de indentificação do veiculo
     * @param tipo o tipo de veiculo carro ou moto
     */
     public Veiculo(String placa, TipoVeiculo tipo){
         this.placa = placa;
         this.tipo =tipo;
     }

    /**
     * retorna o tipo do veiculo
     * @return o tipo do veiculo carro ou moto
     */

    public TipoVeiculo getTipoVeiculo() {
        return tipo;
    }

    /**
     * retorna a placa do veiculo
     * @return placa do veiculo
     */

    public String getPlaca() {
        return placa;
    }

    /**
     * calcula a tarifa com base nas regras de negocio de cada tipo
     * @param minutos o tempo de permanecia do veiculo
     * @return o valor total a ser cobrado
     */

    public abstract double CalcularTarifa(double minutos );//Ticket ticket

}
