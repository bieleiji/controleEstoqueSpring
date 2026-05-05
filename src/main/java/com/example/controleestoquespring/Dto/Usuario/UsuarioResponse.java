package com.example.controleestoquespring.Dto.Usuario;

public class UsuarioResponse {
    private String mensagem;

    public UsuarioResponse(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
