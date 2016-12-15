package com.br.vo;

public class LivroVO {

    private int id;
    private String titulo;
    private int autor_id;
    private int quantidade;
    private int lancamento;
    private int categoria;
    private float valor_entrada;
    private float preco;
    private int fornecedor_id;
    private String descricao;
    private String nome_fantasia_autor;
    private String fornecedor_razao_social;
    private String categoria_cat;
    private float precoTotal;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(int autor_id) {
        this.autor_id = autor_id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getLancamento() {
        return lancamento;
    }

    public void setLancamento(int lancamento) {
        this.lancamento = lancamento;
    }

    public float getValor_entrada() {
        return valor_entrada;
    }

    public void setValor_entrada(float valor_entrada) {
        this.valor_entrada = valor_entrada;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getFornecedor_id() {
        return fornecedor_id;
    }

    public void setFornecedor_id(int fornecedor_id) {
        this.fornecedor_id = fornecedor_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFornecedor_razao_social() {
        return fornecedor_razao_social;
    }

    public void setFornecedor_razao_social(String fornecedor_razao_social) {
        this.fornecedor_razao_social = fornecedor_razao_social;
    }

    public String getNome_fantasia_autor() {
        return nome_fantasia_autor;
    }

    public void setNome_fantasia_autor(String nome_fantasia_autor) {
        this.nome_fantasia_autor = nome_fantasia_autor;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getCategoria_cat() {
        return categoria_cat;
    }

    public void setCategoria_cat(String categoria_cat) {
        this.categoria_cat = categoria_cat;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }

}
