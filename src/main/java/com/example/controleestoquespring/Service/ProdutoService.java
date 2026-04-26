package com.example.controleestoquespring.Service;

import com.example.controleestoquespring.Model.Produto;
import com.example.controleestoquespring.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> mostrarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscaPorId(int id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public void removerPorId(int id) {
        produtoRepository.deleteById(id);
    }

    public Produto atualizarPorId(int id, Produto novoProduto) {
        Produto produto = buscaPorId(id);

        if (produto == null) return null;

        produto.setNome(novoProduto.getNome());
        produto.setPreco(novoProduto.getPreco());
        produto.setQuantidade(novoProduto.getQuantidade());

        return produtoRepository.save(produto);
    }
}
