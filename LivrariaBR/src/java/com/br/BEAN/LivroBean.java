package com.br.BEAN;

import com.br.DAO.LivroDAO;
import com.br.vo.LivroVO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean(name = "livroBean")
@SessionScoped
public class LivroBean {

    private DataModel<LivroVO> livroDataModel;
    private LivroVO vo = new LivroVO();

    public LivroVO getVo() {
        return vo;
    }

    public void setVo(LivroVO vo) {
        this.vo = vo;
    }

    public void selecionaRegistro() {

        this.vo = livroDataModel.getRowData();

    }

    public void novoObj() {

        this.vo = new LivroVO();
    }

    public String adiciona_livro() throws ClassNotFoundException, SQLException {
        LivroDAO dao = new LivroDAO();
        String retorno = "erro";

        if (dao.adiciona(vo)) {
          
            retorno = "lista_livros";
        } else {
            retorno = "erro";
        }
        return retorno;

    }

    public String atualiza_livro() throws ClassNotFoundException, SQLException {
        LivroDAO dao = new LivroDAO();
        String retorno = "erro";

        if (dao.atualiza(vo)) {
            retorno = "lista_livros";
        } else {

            retorno = "erro";
        }
        return retorno;

    }

    public String remove_livro() throws ClassNotFoundException, SQLException {
        LivroDAO dao = new LivroDAO();
        String retorno = "erro";

        if (dao.deleta(vo)) {
            retorno = "lista_livros";
        } else {
            retorno = "erro";
        }
        return retorno;
    }

    public void pesquisar() throws ClassNotFoundException, SQLException {
        LivroDAO dao = new LivroDAO();
        dao.pesquisarID(vo.getId());

    }

    public DataModel<LivroVO> getLivroDataModel() {

        LivroDAO dao = new LivroDAO();
        try {

            List<LivroVO> listaVO = dao.lista();
            livroDataModel = new ListDataModel<LivroVO>(listaVO);
            return livroDataModel;
        } catch (Exception e) {

        }
        return livroDataModel;
    }

    public void setLivroDataModel(DataModel<LivroVO> livroDataModel) {
        this.livroDataModel = livroDataModel;
    }

}
