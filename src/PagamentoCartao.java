public class PagamentoCartao implements MetodoPagamento{
    public void pagar(double valor) {
        System.out.println("Pagamento via Cartao no valor de R$: " + valor);
    }
}