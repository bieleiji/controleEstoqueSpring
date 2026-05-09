package com.example.controleestoquespring.Service;

import com.example.controleestoquespring.Dto.Usuario.UsuarioRequest;
import com.example.controleestoquespring.Dto.Usuario.UsuarioResponse;
import com.example.controleestoquespring.Model.Usuario;
import com.example.controleestoquespring.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public void registrar(UsuarioRequest usuarioRequest) {
        if(usuarioRepository.findByNomeContaining(usuarioRequest.getNome()).isPresent()) {
            throw new RuntimeException("Usuario já existente");
        }

        Usuario usuario = new Usuario();

        String senhaCripstografada = encoder.encode(usuarioRequest.getSenha());

        usuario.setNome(usuarioRequest.getNome());
        usuario.setSenha(senhaCripstografada);

        usuarioRepository.save(usuario);
    }

    public UsuarioResponse login(UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioRepository.findByNomeContaining(usuarioRequest.getNome())
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        if(!encoder.matches(usuarioRequest.getSenha(), usuario.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }

        String token = jwtService.gerarToken(usuario.getNome());

        return new UsuarioResponse(token);
    }
}
