package com.br.vo;

public class VendaVO {

    private int quantidade;
    private int parcelamento;
    private float precoTotal;
    private String formaPagamento;
    private String data = "25/10/2016";
    private String hora = "09:45 pm";
    private String tipoPgtm = "Boleto | Cartão | PayPal";

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getParcelamento() {
        return parcelamento;
    }

    public void setParcelamento(int parcelamento) {
        this.parcelamento = parcelamento;
    }

    public String getTipoPgtm() {
        return tipoPgtm;
    }

    public void setTipoPgtm(String tipoPgtm) {
        this.tipoPgtm = tipoPgtm;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

}
