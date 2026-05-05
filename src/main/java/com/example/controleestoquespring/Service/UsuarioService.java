package com.example.controleestoquespring.Service;

import com.example.controleestoquespring.Dto.Usuario.UsuarioRequest;
import com.example.controleestoquespring.Dto.Usuario.UsuarioResponse;
import com.example.controleestoquespring.Model.Usuario;
import com.example.controleestoquespring.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void registrar(UsuarioRequest usuarioRequest) {
        if(usuarioRepository.findByNomeContaining(usuarioRequest.getNome()).isPresent()) {
            throw new RuntimeException("Usuario já existente");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequest.getNome());
        usuario.setSenha(usuarioRequest.getSenha());

        usuarioRepository.save(usuario);
    }

    public UsuarioResponse login(UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioRepository.findByNomeContaining(usuarioRequest.getNome())
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        if(!usuario.getSenha().equals(usuarioRequest.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }

        return new UsuarioResponse("Login realizado com sucesso");
    }
}
