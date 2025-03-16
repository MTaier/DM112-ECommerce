package UI;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controllers.PedidoController;
import payments.Pagamento;
import payments.PagamentoFactory;

class PagamentoPixUI extends JFrame {
    private JLabel lblQRCode;

    public PagamentoPixUI(PedidoController pedidoController) {
        setTitle("Pagamento via Pix");
        setSize(300, 300);
        setLayout(new FlowLayout());

        lblQRCode = new JLabel("[QR Code Gerado]"); // Aqui você pode gerar uma imagem real
        add(lblQRCode);

        JButton btnConfirmar = new JButton("Confirmar Pagamento");
        add(btnConfirmar);

        btnConfirmar.addActionListener(e -> {
            Pagamento pagamento = PagamentoFactory.criarPagamento("Pix", "QRCode12345");
            pedidoController.finalizarPedido(pagamento);
            JOptionPane.showMessageDialog(this, "Pagamento via Pix realizado com sucesso!");
            dispose();
        });
    }
}