package com.example.controleestoquespring.Controller;

import com.example.controleestoquespring.Model.Produto;
import com.example.controleestoquespring.Service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public Produto criarProduto(@RequestBody @Valid Produto produto) {
        return produtoService.criarProduto(produto);
    }

    @GetMapping
    public List<Produto> mostrarProdutos() {
        return produtoService.mostrarProdutos();
    }

    @GetMapping("/{id}")
    public Produto buscaPorId(@PathVariable int id) {
        return produtoService.buscaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void removerPorId(@PathVariable int id) {
        produtoService.removerPorId(id);
    }

    @PutMapping("/{id}")
    public Produto atualizarPorId(@PathVariable int id, @RequestBody @Valid Produto novoProduto) {
        return produtoService.atualizarPorId(id, novoProduto);
    }
}
