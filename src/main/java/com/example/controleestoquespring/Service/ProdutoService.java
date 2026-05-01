package com.example.controleestoquespring.Service;

import com.example.controleestoquespring.Dto.ProdutoRequest;
import com.example.controleestoquespring.Dto.ProdutoResponse;
import com.example.controleestoquespring.Dto.ProdutoUpdateRequest;
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

    public ProdutoResponse criarProduto(ProdutoRequest produtoRequest) {
        Produto produto = new Produto();

        produto.setNome(produtoRequest.getNome());
        produto.setPreco(produtoRequest.getPreco());
        produto.setQuantidade(produtoRequest.getQuantidade());

        Produto salvo = produtoRepository.save(produto);

        return new ProdutoResponse(
                salvo.getId(),
                salvo.getNome(),
                salvo.getPreco(),
                salvo.getQuantidade()
        );
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

    public ProdutoResponse atualizarPorId(int id, ProdutoUpdateRequest produtoUpdateRequest) {
        Produto produto = produtoRepository.findById(id).
                orElseThrow(() -> new ProdutoException("usuário inexistente"));

        if(produtoUpdateRequest.getNome() != null) {
            if (produtoUpdateRequest.getNome().isBlank())
                throw new ProdutoException("nome vazio é inválido");
            else produto.setNome(produtoUpdateRequest.getNome());
        }

        if(produtoUpdateRequest.getPreco() != null) {
            if (produtoUpdateRequest.getPreco() <= 0)
                throw new ProdutoException("preço menor ou igual a 0 é inválido");
            else produto.setPreco(produtoUpdateRequest.getPreco());
        }

        if(produtoUpdateRequest.getQuantidade() != null) {
            if (produtoUpdateRequest.getQuantidade() < 0)
                throw new ProdutoException("quantidade menor que 0 é inválido");
            else produto.setQuantidade(produtoUpdateRequest.getQuantidade());
        }

        Produto atualizado = produtoRepository.save(produto);

        return new ProdutoResponse(
                atualizado.getId(),
                atualizado.getNome(),
                atualizado.getPreco(),
                atualizado.getQuantidade()
        );
    }
}
