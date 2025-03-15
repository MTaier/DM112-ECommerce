package payments;

import javax.swing.JOptionPane;

public class PagamentoCartaoCredito implements Pagamento {
    private String numeroCartao;
    private String titular;

    public PagamentoCartaoCredito(String numeroCartao, String titular) {
        this.numeroCartao = numeroCartao;
        this.titular = titular;
    }

    @Override
    public void efetuarPagamento(double valor) {
        JOptionPane.showMessageDialog(null, "Pagamento de R$ " + valor + " realizado com Cartão de Crédito");
    }
}