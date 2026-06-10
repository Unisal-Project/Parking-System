package Facade;

import Factory.*;
import Strategy.*;
import auth.*;
import builder.*;

public class EstacionamentoFacade {

    public Veiculo registrarEntrada(String placa, TipoVeiculo tipo){
        Veiculo veiculo = VeiculoFactory.criarVeiculo(placa, tipo);

        System.out.println("Entrada registrada com sucesso");
        System.out.println("Placa: " + placa);
        System.out.println("Tipo: " + tipo);

        return veiculo;
    }

    public double registrarPagamento(double valor, MetodoPagamento metodoPagamento){
        Pagamento pagamento = new Pagamento(metodoPagamento);

        double valorFinal = pagamento.realizarPagamento(valor);

        System.out.println("Pagamento realizado com sucesso");
        System.out.println("Valor final: R$ " + valorFinal);

        return valorFinal;
    }

}