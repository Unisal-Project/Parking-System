package Factory;

/**
 * responsavel pela criação de intancias e centraliza a logica
 *@author Pedro Monteiro
 *  @Verson 1.0
 */
public class VeiculoFactory {
    /**
     * cria uma instancia a partir de um tipo informado
     * @param placa a placa do veicula a ser criado
     * @param tipo o tipo de veiculo carro ou moto
     * @return uma instancia carro ou moto , depende do tipo
     * @throws IllegalArgumentException se o tipo não for reconhecido
     */

    public static Veiculo criarVeiculo(String placa, TipoVeiculo tipo) {
        if (placa == null) {
            throw new IllegalArgumentException("Placa não pode ser nula!");
        }

    if (tipo==TipoVeiculo.CARRO){
        return new Carro(placa);
    }
    if(tipo==TipoVeiculo.MOTO){
        return new Moto(placa);
    }
    else {
        throw new IllegalArgumentException("tipo não encontrado!"+ tipo);
    }
    }
}
