package com.br.BEAN;

import com.br.DAO.AutorDAO;
import com.br.vo.AutorVO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean(name = "autorBean")
@SessionScoped

public class AutorBean {

    private AutorVO vo = new AutorVO();
    private DataModel<AutorVO> autorDataModel;

    public AutorVO getVo() {
        return vo;
    }

    public void setVo(AutorVO vo) {
        this.vo = vo;
    }

    public String adiciona() throws ClassNotFoundException, SQLException {
        String retorno = "erro";
        AutorDAO dao = new AutorDAO();

        if (dao.adiciona(vo)) {
            retorno = "lista_autor?faces-redirect=true";
        } else {
            retorno = "erro";
        }
        return retorno;
    }

    public String deleta() throws ClassNotFoundException, SQLException {

        String retorno = "erro";
        AutorDAO dao = new AutorDAO();

        if (dao.deleta(vo)) {
            retorno = "lista_autor?faces-redirect=true";
        } else {
            retorno = "erro";
        }
        return retorno;
    }

    public String edita() throws ClassNotFoundException, SQLException {

        String retorno = "erro";
        AutorDAO dao = new AutorDAO();

        if (dao.atualiza(vo)) {
            retorno = "lista_autor?faces-redirect=true";
        } else {
            retorno = "erro";
        }
        return retorno;
    }

    public void selecionaReg() {
        this.vo = autorDataModel.getRowData();
    }

    public void novoOBJ() {
        this.vo = new AutorVO();

    }

    public void busca() throws ClassNotFoundException, SQLException {
        AutorDAO dao = new AutorDAO();
        dao.listaNome(vo.getPesquisa_nome());
        List<AutorVO> listaAutorId = dao.listaNome(vo.getPesquisa_nome());
        autorDataModel = new ListDataModel<AutorVO>(listaAutorId);

        if (listaAutorId.isEmpty()) {
            vo.setPesquisa_nome(" Não encontrado");

            //              ***********TORCE PRA DA CERTO***********
        }

    }

    public DataModel<AutorVO> getAutorDataModel() throws ClassNotFoundException, SQLException {

        if (vo.getPesquisa_nome() == null) {
            AutorDAO dao = new AutorDAO();
            dao.lista();
            List<AutorVO> listaAutor = dao.lista();
            autorDataModel = new ListDataModel<AutorVO>(listaAutor);
            return autorDataModel;
        }
        return autorDataModel;
    }

    public void setAutorDataModel(DataModel<AutorVO> autorDataModel) {
        this.autorDataModel = autorDataModel;
    }

}
