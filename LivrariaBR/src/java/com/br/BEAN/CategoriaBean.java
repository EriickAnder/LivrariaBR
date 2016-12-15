package com.br.BEAN;

import com.br.DAO.CategoriaDAO;
import com.br.vo.CategoriaVO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean(name = "CatBean")
@SessionScoped
public class CategoriaBean {

    private DataModel<CategoriaVO> catDataModel;

    private CategoriaVO vo = new CategoriaVO();

    public CategoriaVO getVo() {
        return vo;
    }

    public void setVo(CategoriaVO vo) {
        this.vo = vo;
    }

    public void selecionaRegistro() {

        this.vo = catDataModel.getRowData();

    }

    public void novoObj() {

        this.vo = new CategoriaVO();
    }

    public String adiciona_categoria() throws ClassNotFoundException, SQLException {
        CategoriaDAO dao = new CategoriaDAO();
        String retorno = "erro";

        if (dao.adiciona(vo)) {
            retorno = "lista_categoria?faces-redirect=true";
            lista(); // Chama o metodo lista para atualizar a tabela quando redirecionado para a pagina LISTA_CATEGORIA
        } else {
            retorno = "erro";
        }
        return retorno;

    }

    public String atualiza_categoria() throws ClassNotFoundException, SQLException {
        CategoriaDAO dao = new CategoriaDAO();
        String retorno = "erro";

        if (dao.atualiza(vo)) {
            retorno = "lista_categoria?faces-redirect=true";
        } else {

            retorno = "erro";
        }
        return retorno;

    }

    public String remove_categoria() throws ClassNotFoundException, SQLException {
        CategoriaDAO dao = new CategoriaDAO();
        String retorno = "erro";

        if (dao.deleta(vo)) {
            retorno = "lista_categoria?faces-redirect=true";
        } else {
            retorno = "Erro ao continuar procedimento";
        }
        return retorno;
    }

    public void lista() throws ClassNotFoundException, SQLException {
        CategoriaDAO dao = new CategoriaDAO();
        dao.lista();
        List<CategoriaVO> listaTudo = dao.lista();
        catDataModel = new ListDataModel<CategoriaVO>(listaTudo);

    }

    public void buscaID() throws ClassNotFoundException, SQLException {
        CategoriaDAO dao = new CategoriaDAO();
        dao.listaId(vo.getPesquisa());
        List<CategoriaVO> listaID = dao.listaId(vo.getPesquisa());
        catDataModel = new ListDataModel<CategoriaVO>(listaID);
        if (listaID.isEmpty()) {
            dao.listaId(vo.getPesquisa());
            List<CategoriaVO> listaTudo = dao.lista();
            catDataModel = new ListDataModel<CategoriaVO>(listaTudo);
        }

    }

    public void buscaNome() throws ClassNotFoundException, SQLException {
        CategoriaDAO dao = new CategoriaDAO();
        dao.listaTitulo(vo.getPesquisa());
        List<CategoriaVO> listaTitulo = dao.listaTitulo(vo.getPesquisa());

        catDataModel = new ListDataModel<CategoriaVO>(listaTitulo);

    }

    public DataModel<CategoriaVO> getCategoriaVODataModel() throws ClassNotFoundException, SQLException {

        if (vo.getPesquisa() == null) {

            CategoriaDAO dao = new CategoriaDAO();
            dao.lista();
            List<CategoriaVO> listaID = dao.lista();
            catDataModel = new ListDataModel<CategoriaVO>(listaID);
            return catDataModel;
        }
        return catDataModel;
    }

    public void setCategoriaVODataModel(DataModel<CategoriaVO> livroDataModel) {
        this.catDataModel = livroDataModel;
    }

}
