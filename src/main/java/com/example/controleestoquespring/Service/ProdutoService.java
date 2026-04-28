package com.example.controleestoquespring.Service;

import com.example.controleestoquespring.Exception.ProdutoException;
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
        if(produto.getNome().isBlank())
            throw new ProdutoException("nome vazio é inválido");

        else if(produto.getPreco() <= 0)
            throw new ProdutoException("preço menor ou igual a 0 é inválido");

        else if(produto.getQuantidade() < 0)
          throw new ProdutoException("quantidade menor que 0 é inválido");

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

        if (produto == null)
            throw new ProdutoException("usuário inexistente");

        if(produto.getNome().isBlank())
            throw new ProdutoException("nome vazio é inválido");
        else produto.setNome(novoProduto.getNome());

        if(produto.getPreco() <= 0)
            throw new ProdutoException("preço menor ou igual a 0 é inválido");
        else produto.setPreco(novoProduto.getPreco());

        if(produto.getQuantidade() < 0)
            throw new ProdutoException("quantidade menor que 0 é inválido");
        else produto.setQuantidade(novoProduto.getQuantidade());

        return produtoRepository.save(produto);
    }
}
