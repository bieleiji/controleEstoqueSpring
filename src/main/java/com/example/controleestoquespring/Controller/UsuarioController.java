package com.example.controleestoquespring.Controller;

import com.example.controleestoquespring.Dto.Usuario.UsuarioRequest;
import com.example.controleestoquespring.Dto.Usuario.UsuarioResponse;
import com.example.controleestoquespring.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrar(@RequestBody UsuarioRequest usuarioRequest) {
        usuarioService.registrar(usuarioRequest);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponse> login(@RequestBody UsuarioRequest loginRequest) {
        return ResponseEntity.ok(usuarioService.login(loginRequest));
    }
}
