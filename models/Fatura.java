package models;

import java.util.Date;

import javax.swing.JOptionPane;

class Fatura {
    private Pedido pedido;
    private Date data;

    public Fatura(Pedido pedido) {
        this.pedido = pedido;
        this.data = new Date();
    }

    public void gerarFatura() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== Fatura =====\n");
        sb.append("Data: " + data + "\n");
        sb.append("Itens do Pedido:\n");
        for (Produto produto : pedido.getProdutos()) {
            sb.append("- " + produto.getNome() + " | R$ " + produto.getPreco() + "\n");
        }
        sb.append("Total: R$ " + pedido.getTotal() + "\n");
        sb.append("=================\n");

        JOptionPane.showMessageDialog(null, sb.toString(), "Fatura", JOptionPane.INFORMATION_MESSAGE);
    }
}