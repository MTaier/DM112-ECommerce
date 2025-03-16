package UI;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.PedidoController;
import payments.Pagamento;
import payments.PagamentoFactory;

class PagamentoCartaoUI extends JFrame {
    private JTextField txtNumeroCartao;
    private JButton btnConfirmar;

    public PagamentoCartaoUI(PedidoController pedidoController) {
        setTitle("Pagamento com Cartão");
        setSize(300, 200);
        setLayout(new FlowLayout());

        add(new JLabel("Número do Cartão:"));
        txtNumeroCartao = new JTextField(20);
        add(txtNumeroCartao);

        btnConfirmar = new JButton("Confirmar Pagamento");
        add(btnConfirmar);

        btnConfirmar.addActionListener(e -> {
            String numeroCartao = txtNumeroCartao.getText();
            if (numeroCartao.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Digite o número do cartão");
                return;
            }
            Pagamento pagamento = PagamentoFactory.criarPagamento("Cartão", numeroCartao);
            pedidoController.finalizarPedido(pagamento);
            JOptionPane.showMessageDialog(this, "Pagamento realizado com sucesso!");
            dispose();
        });
    }
}