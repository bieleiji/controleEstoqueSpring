package com.example.controleestoquespring.Exception;

public class ErroResponse {
    private String mensagem;
    private int erro;

    public ErroResponse(String mensagem, int erro) {
        this.mensagem = mensagem;
        this.erro = erro;
    }

    public int getErro() {
        return erro;
    }

    public String getMensagem() {
        return mensagem;
    }
}
