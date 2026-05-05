package com.example.controleestoquespring.Repository;

import com.example.controleestoquespring.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNomeContaining(String name);
}
