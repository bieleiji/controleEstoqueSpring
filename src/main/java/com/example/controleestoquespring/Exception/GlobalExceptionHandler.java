package com.example.controleestoquespring.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProdutoException.class)
    public ResponseEntity<String> handleProduto(ProdutoException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
