package com.br.vo;

public class AutorVO {

    private int id;
    private String nome;
    private String pesquisa_nome;
    private String nome_artistico;
    private int data_nascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_artistico() {
        return nome_artistico;
    }

    public void setNome_artistico(String nome_artistico) {
        this.nome_artistico = nome_artistico;
    }

    public int getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(int data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPesquisa_nome() {
        return pesquisa_nome;
    }

    public void setPesquisa_nome(String pesquisa_nome) {
        this.pesquisa_nome = pesquisa_nome;
    }
}
