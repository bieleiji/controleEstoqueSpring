package com.example.controleestoquespring.Dto.Produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class ProdutoRequest {

    @NotBlank(message = "'nome' não pode ser vazio")
    private String nome;

    @Positive(message = "'preço' não pode ser menor ou igual a 0")
    private double preco;

    @PositiveOrZero(message = "'quantidade' não pode ser menor que 0")
    private int quantidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
