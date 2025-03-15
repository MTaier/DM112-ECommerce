package UI;

import models.*;
import payments.*;
import controllers.*;
import javax.swing.*;
import java.awt.*;

public class EcommerceUI extends JFrame {
    private PedidoController pedidoController;
    private JComboBox<String> produtoBox;
    private JButton btnAdicionar, btnFinalizar;
    private JRadioButton rbCartao, rbPix;
    private JTextArea carrinhoTextArea;

    public EcommerceUI() {
        setTitle("Gerenciamento de Pedidos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        pedidoController = new PedidoController();

        produtoBox = new JComboBox<>(new String[] { "Notebook - R$4500.00", "Mouse - R$150.00", "Teclado - R$200.00" });
        btnAdicionar = new JButton("Adicionar Produto");
        btnFinalizar = new JButton("Finalizar Pedido");
        rbCartao = new JRadioButton("Cartão de Crédito");
        rbPix = new JRadioButton("Pix");
        carrinhoTextArea = new JTextArea(10, 30);
        carrinhoTextArea.setEditable(false);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbCartao);
        bg.add(rbPix);

        add(produtoBox);
        add(btnAdicionar);
        add(rbCartao);
        add(rbPix);
        add(btnFinalizar);
        add(new JScrollPane(carrinhoTextArea));

        btnAdicionar.addActionListener(e -> {
            String selecionado = (String) produtoBox.getSelectedItem();
            Produto produto = null;
            if (selecionado.contains("Notebook")) {
                produto = new Produto("Notebook", 4500, "Eletrônicos");
            } else if (selecionado.contains("Mouse")) {
                produto = new Produto("Mouse", 150, "Acessórios");
            } else if (selecionado.contains("Teclado")) {
                produto = new Produto("Teclado", 200, "Acessórios");
            }
            pedidoController.adicionarProduto(produto);
            atualizarCarrinho();
        });

        btnFinalizar.addActionListener(e -> {
            if (!rbCartao.isSelected() && !rbPix.isSelected()) {
                JOptionPane.showMessageDialog(null, "Selecione um método de pagamento");
                return;
            }
            String metodoPagamento = rbCartao.isSelected() ? "Cartão" : "Pix";
            Pagamento pagamento = PagamentoFactory.criarPagamento(metodoPagamento, "1234-5678-9012-3456");
            pedidoController.finalizarPedido(pagamento);
            carrinhoTextArea.setText("Pedido finalizado!");
        });
    }

    private void atualizarCarrinho() {
        carrinhoTextArea.setText(pedidoController.visualizarCarrinho());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EcommerceUI().setVisible(true));
    }
}