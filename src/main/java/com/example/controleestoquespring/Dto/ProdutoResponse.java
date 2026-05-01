package com.example.controleestoquespring.Dto;

public class ProdutoResponse {
    private int id;
    private String nome;
    private double preco;
    private int quantidade;

    public ProdutoResponse(int id, String nome, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getNome() {
        return nome;
    }
}
