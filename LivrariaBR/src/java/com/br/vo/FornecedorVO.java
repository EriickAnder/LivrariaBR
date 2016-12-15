package com.br.vo;

public class FornecedorVO {

    private int id;
    private String razao_social;
    private String nome_fantasia;
    private int cpnj;
    private int telefone;
    private int data_cadastro;
    private String pesquisa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public int getCpnj() {
        return cpnj;
    }

    public void setCpnj(int cpnj) {
        this.cpnj = cpnj;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(int data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

}
