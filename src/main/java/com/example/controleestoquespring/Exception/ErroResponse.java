package com.example.controleestoquespring.Exception;

public class ErroResponse {
    private String mensagem;
    private int status;

    public ErroResponse(String mensagem, int status) {
        this.mensagem = mensagem;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }
}
