package com.example.controleestoquespring.Dto.Usuario;

public class UsuarioResponse {
    private String token;

    public UsuarioResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
