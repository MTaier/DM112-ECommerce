package controllers;

import models.*;
import payments.*;

public class PedidoController {
    private Pedido pedido;

    public PedidoController() {
        this.pedido = new Pedido();
    }

    public void adicionarProduto(Produto produto) {
        pedido.adicionarProduto(produto);
    }

    public String visualizarCarrinho() {
        StringBuilder sb = new StringBuilder("Itens no Carrinho:\n");
        for (Produto p : pedido.getProdutos()) {
            sb.append("- ").append(p.getNome()).append(" | R$ ").append(String.format("%.2f", p.getPreco()))
                    .append("\n");
        }
        sb.append("Total: R$ ").append(String.format("%.2f", pedido.getTotal())).append("\n");
        return sb.toString();
    }

    public void finalizarPedido(Pagamento pagamento) {
        pedido.finalizarPedido(pagamento);
    }

    public Pedido getPedido() {
        return pedido;
    }
}
