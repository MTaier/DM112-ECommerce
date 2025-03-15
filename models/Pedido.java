package models;

import java.util.ArrayList;
import java.util.List;

import payments.Pagamento;

public class Pedido {
    private List<Produto> produtos = new ArrayList<>();
    private double total = 0.0;

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        total += produto.getPreco();
    }

    public double getTotal() {
        return total;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void finalizarPedido(Pagamento pagamento) {
        pagamento.efetuarPagamento(total);
        new Fatura(this).gerarFatura();
    }
}