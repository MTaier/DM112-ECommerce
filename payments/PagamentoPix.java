package payments;

import javax.swing.JOptionPane;

public class PagamentoPix implements Pagamento {
    private String chavePix;

    public PagamentoPix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void efetuarPagamento(double valor) {
        JOptionPane.showMessageDialog(null, "Pagamento de R$ " + valor + " realizado via Pix");
    }
}