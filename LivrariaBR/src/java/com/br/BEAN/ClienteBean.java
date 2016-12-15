package com.br.BEAN;

import com.br.DAO.ClienteDAO;
import com.br.vo.ClienteVO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean(name = "cliBean")
@SessionScoped
public class ClienteBean {

    private DataModel<ClienteVO> cliDataModel;

    private ClienteVO vo = new ClienteVO();

    public ClienteVO getVo() {
        return vo;
    }

    public void setVo(ClienteVO vo) {
        this.vo = vo;
    }

    public void selecionaRegistro() {
        this.vo = cliDataModel.getRowData();
    }

    public void novoObj() {
        this.vo = new ClienteVO();
    }

    public String adiciona() throws ClassNotFoundException, SQLException {
        ClienteDAO dao = new ClienteDAO();
        String retorno = "erro";

        if (dao.adiciona(vo)) {
            retorno = "lista_cliente";
        } else {
            retorno = "erro";
        }
        return retorno;

    }

    public String atualiza() throws ClassNotFoundException, SQLException {
        ClienteDAO dao = new ClienteDAO();
        String retorno = "erro";

        if (dao.atualiza(vo)) {
            retorno = "lista_cliente";
        } else {
            retorno = "erro";
        }
        return retorno;

    }

    public String remove() throws ClassNotFoundException, SQLException {
        ClienteDAO dao = new ClienteDAO();
        String retorno = "erro";

        if (dao.deleta(vo)) {
            retorno = "lista_cliente";
        } else {
            retorno = "Erro ao continuar procedimento";
        }
        return retorno;
    }

    public void buscaCPF() throws ClassNotFoundException, SQLException {

        ClienteDAO dao = new ClienteDAO();
        dao.listaCPF(vo.getPesquisa());
        List<ClienteVO> listaID = dao.listaCPF(vo.getPesquisa());
        cliDataModel = new ListDataModel<ClienteVO>(listaID);

    }

    public void buscaNome() throws ClassNotFoundException, SQLException {

        ClienteDAO dao = new ClienteDAO();
        dao.listaNome(vo.getPesquisa());
        List<ClienteVO> listaNome = dao.listaNome(vo.getPesquisa());
        cliDataModel = new ListDataModel<ClienteVO>(listaNome);

    }

    public DataModel<ClienteVO> getCliDataModel() throws ClassNotFoundException, SQLException {

        return cliDataModel;
    }

    public void setCliDataModel(DataModel<ClienteVO> livroDataModel) {
        this.cliDataModel = livroDataModel;
    }

}
