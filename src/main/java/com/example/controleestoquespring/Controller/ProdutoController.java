package com.example.controleestoquespring.Controller;

import com.example.controleestoquespring.Dto.ProdutoRequest;
import com.example.controleestoquespring.Dto.ProdutoResponse;
import com.example.controleestoquespring.Dto.ProdutoUpdateRequest;
import com.example.controleestoquespring.Model.Produto;
import com.example.controleestoquespring.Service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ProdutoResponse> criarProduto(@RequestBody @Valid ProdutoRequest produtoRequest) {
        return ResponseEntity.ok(produtoService.criarProduto(produtoRequest));
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

    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizarPorId(
            @PathVariable int id,
            @RequestBody ProdutoUpdateRequest produtoUpdateRequest) {
        return ResponseEntity.ok(produtoService.atualizarPorId(id,produtoUpdateRequest));
    }
}
