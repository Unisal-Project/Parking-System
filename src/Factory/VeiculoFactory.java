package Factory;

public class VeiculoFactory {

    public static Veiculo criarVeiculo(String placa, TipoVeiculo tipo) {
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
