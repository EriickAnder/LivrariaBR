package com.br.BEAN;

import com.br.DAO.FornecedorDAO;
import com.br.vo.FornecedorVO;

import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean(name = "fornBean")
@SessionScoped
public class FornecedorBean {

    private DataModel<FornecedorVO> fornDataModel;

    private FornecedorVO vo = new FornecedorVO();

    public FornecedorVO getVo() {
        return vo;
    }

    public void setVo(FornecedorVO vo) {
        this.vo = vo;
    }

    public void selecionaRegistro() {

        this.vo = fornDataModel.getRowData();

    }

    public void novoObj() {

        this.vo = new FornecedorVO();
    }

    public String adiciona() throws ClassNotFoundException, SQLException {
        FornecedorDAO dao = new FornecedorDAO();
        String retorno = "erro";

        if (dao.adiciona(vo)) {
            retorno = "lista_fornecedor?faces-redirect=true";
            listaTudo();
        } else {
            retorno = "erro";
        }
        return retorno;

    }

    public String edita() throws ClassNotFoundException, SQLException {
        FornecedorDAO dao = new FornecedorDAO();
        String retorno = "erro";

        if (dao.atualiza(vo)) {
            retorno = "lista_fornecedor";
        } else {

            retorno = "erro";
        }
        return retorno;

    }
    String retorno;

    public String deleta() throws ClassNotFoundException, SQLException {
        FornecedorDAO dao = new FornecedorDAO();
        retorno = "erro";

        if (dao.deleta(vo)) {
            retorno = "lista_fornecedor";
        } else {
            retorno = "Erro ao continuar procedimento";
        }
        return retorno;
    }

    public void buscaID() throws ClassNotFoundException, SQLException {
        FornecedorDAO dao = new FornecedorDAO();
        int pesquisa = Integer.parseInt(vo.getPesquisa());
        dao.listaId(pesquisa);
        List<FornecedorVO> listaID = dao.listaId(pesquisa);
        fornDataModel = new ListDataModel<FornecedorVO>(listaID);

    }

    public void buscaNome() throws ClassNotFoundException, SQLException {
        FornecedorDAO dao = new FornecedorDAO();
        dao.listaNome(vo.getPesquisa());
        List<FornecedorVO> listaNome = dao.listaNome(vo.getPesquisa());
        fornDataModel = new ListDataModel<FornecedorVO>(listaNome);

    }

    public void buscaCNPJ() throws ClassNotFoundException, SQLException {
        FornecedorDAO dao = new FornecedorDAO();
        dao.listaCnpj(vo.getPesquisa());
        List<FornecedorVO> listaCNPJ = dao.listaCnpj(vo.getPesquisa());
        fornDataModel = new ListDataModel<FornecedorVO>(listaCNPJ);

    }

    public void listaTudo() throws ClassNotFoundException, SQLException {

        FornecedorDAO dao = new FornecedorDAO();
        dao.listaTudo();
        List<FornecedorVO> listaTudo = dao.listaTudo();
        fornDataModel = new ListDataModel<FornecedorVO>(listaTudo);
    }

    public DataModel<FornecedorVO> getFornecedorDataModel() throws ClassNotFoundException, SQLException {

        if (vo.getPesquisa() == null) {
            FornecedorDAO dao = new FornecedorDAO();
            dao.listaTudo();
            List<FornecedorVO> listaForn = dao.listaTudo();
            fornDataModel = new ListDataModel<FornecedorVO>(listaForn);

        }

        return fornDataModel;

    }

    public void setFornecedorDataModel(DataModel<FornecedorVO> livroDataModel) {
        this.fornDataModel = livroDataModel;
    }
}
