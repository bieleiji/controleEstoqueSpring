package com.example.controleestoquespring.Controller;

import com.example.controleestoquespring.Dto.ProdutoRequest;
import com.example.controleestoquespring.Dto.ProdutoResponse;
import com.example.controleestoquespring.Dto.ProdutoUpdateRequest;
import com.example.controleestoquespring.Service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<Page<ProdutoResponse>> listarProdutos(
            @RequestParam(required = false) String nome,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return ResponseEntity.ok(produtoService.listarProdutos(nome, page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscaPorId(@PathVariable int id) {
        return ResponseEntity.ok(produtoService.buscaPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable int id) {
        produtoService.removerPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizarPorId(
            @PathVariable int id,
            @RequestBody ProdutoUpdateRequest produtoUpdateRequest) {
        return ResponseEntity.ok(produtoService.atualizarPorId(id,produtoUpdateRequest));
    }
}
