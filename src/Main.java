import java.util.*;

public class Main {
    public static void main(String[] args) {
        Pagamento pagPix = new Pagamento(new PagamentoPix());
        Pagamento pagCartao =  new Pagamento(new PagamentoCartao());
        Pagamento PagDinheiro = new  Pagamento(new PagamentoDinheiro());

    }
}