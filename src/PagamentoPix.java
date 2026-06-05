public class PagamentoPix implements MetodoPagamento{
    public void pagar(double valor) {
        System.out.println("Pagamento via Pix no valor de R$: " + valor);
    }
}