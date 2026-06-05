public class PagamentoDinheiro implements MetodoPagamento{
    public void pagar(double valor) {
        System.out.println("Pagamento via Dinheiro no valor de R$: " + valor);
    }
}