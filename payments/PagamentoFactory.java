package payments;

public class PagamentoFactory {
    public static Pagamento criarPagamento(String tipo, String info) {
        switch (tipo) {
            case "Cartão":
                return new PagamentoCartaoCredito(info, "Cliente");
            case "Pix":
                return new PagamentoPix(info);
            default:
                throw new IllegalArgumentException("Método de pagamento inválido");
        }
    }
}