package Factory;

public abstract class Veiculo {
     private String placa;
     private TipoVeiculo  tipo;

     public Veiculo(String placa, TipoVeiculo tipo){
         this.placa = placa;
         this.tipo =tipo;
     }

    public TipoVeiculo getTipoVeiculo() {
        return tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public abstract double CalcularTarifa(double minutos );//Ticket ticket

}
