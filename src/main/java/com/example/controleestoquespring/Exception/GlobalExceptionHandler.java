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
                .getFirst()
                .getDefaultMessage();
        ErroResponse erro = new ErroResponse(mensagem, 400);
        return ResponseEntity.badRequest().body(erro);
    }

    @ExceptionHandler(ProdutoException.class)
    public ResponseEntity<ErroResponse> handleProduto(String mensagem) {
        ErroResponse erroResponse = new ErroResponse(mensagem, 400);
        return ResponseEntity.badRequest().body(erroResponse);
    }
}
