package com.example.controleestoquespring.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> handleProduto(MethodArgumentNotValidException e) {
        String mensagem = e.getBindingResult()
                .getFieldErrors()
                .stream().findFirst().orElseThrow()
                .getDefaultMessage();
        ErroResponse erro = new ErroResponse(mensagem, 400);
        return ResponseEntity.badRequest().body(erro);
    }

    @ExceptionHandler(ProdutoException.class)
    public ResponseEntity<ErroResponse> handleProduto(ProdutoException e) {
        ErroResponse erroResponse = new ErroResponse(e.getMessage(), 400);
        return ResponseEntity.badRequest().body(erroResponse);
    }
}
