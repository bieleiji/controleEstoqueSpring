package com.example.controleestoquespring.Repository;
import com.example.controleestoquespring.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
}
