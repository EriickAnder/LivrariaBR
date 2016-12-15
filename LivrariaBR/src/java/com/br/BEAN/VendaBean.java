package com.br.BEAN;

import com.br.DAO.VendaDAO;
import com.br.vo.AutorVO;
import com.br.vo.CategoriaVO;
import com.br.vo.ClienteVO;
import com.br.vo.LivroVO;
import com.br.vo.VendaVO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean(name = "vendaBean")
@SessionScoped

public class VendaBean {
    
    private AutorVO voAutor = new AutorVO();
    private CategoriaVO voCat = new CategoriaVO();
    private ClienteVO voCli = new ClienteVO();
    private LivroVO voLivro = new LivroVO();
    private VendaVO voVenda = new VendaVO();
    
    private DataModel<LivroVO> listLivroDataModel;

    /* Inicio Getters e Setters das classes: AutorVO, CategoriaVO, ClienteVO, LivroVO */
    public AutorVO getVoAutor() {
        return voAutor;
    }
    
    public void setVoAutor(AutorVO voAutor) {
        this.voAutor = voAutor;
    }
    
    public CategoriaVO getVoCat() {
        return voCat;
    }
    
    public void setVoCat(CategoriaVO voCat) {
        this.voCat = voCat;
    }
    
    public ClienteVO getVoCli() {
        return voCli;
    }
    
    public void setVoCli(ClienteVO voCli) {
        this.voCli = voCli;
    }
    
    public LivroVO getVoLivro() {
        return voLivro;
    }
    
    public void setVoLivro(LivroVO voLivro) {
        this.voLivro = voLivro;
    }
    
    public VendaVO getVoVenda() {
        return voVenda;
    }
    
    public void setVoVenda(VendaVO voVenda) {
        this.voVenda = voVenda;
    }

    /* Fim dos Getters e Setters das Classes: AutorVO, CategoriaVO, ClienteVO, LivroVO  VendaVO*/
    public DataModel<LivroVO> getListLivroDataModel() {
        return listLivroDataModel;
    }
    
    public void setListLivroDataModel(DataModel<LivroVO> listLivroDataModel) {
        this.listLivroDataModel = listLivroDataModel;
    }
    
    public void recuperaLivro() throws ClassNotFoundException, SQLException {
        VendaDAO dao = new VendaDAO();
        List<LivroVO> resultLivro = new ArrayList<LivroVO>();
        resultLivro = dao.listaLivro(voLivro.getId());
        
        for (LivroVO x : resultLivro) {
            voLivro.setTitulo(x.getTitulo());
            voLivro.setPreco(x.getPreco());
        }
        if (resultLivro.isEmpty()) {
            voLivro.setTitulo("Não Encontrado");
            voLivro.setPreco(0);
            voLivro.setPrecoTotal(0);
            voLivro.setQuantidade(0);
            
        }
    }
    
    public void calculaTotal() {
        int quantidade = voLivro.getQuantidade();
        float preco = voLivro.getPreco();
        float precoTotal = quantidade * preco;
        voLivro.setPrecoTotal(precoTotal);
        
    }
    
    public void recuperaCliente() throws SQLException, ClassNotFoundException {
        VendaDAO dao = new VendaDAO();
        List<ClienteVO> listaCliente = new ArrayList<ClienteVO>();
        listaCliente = dao.listaCliente(voCli.getCpf());
        
        for (ClienteVO x : listaCliente) {
            voCli.setNome(x.getNome());
            voCli.setSobrenome(x.getSobrenome());
        }
        
        if(listaCliente.isEmpty()){
        voCli.setNome("Não Encontrado");
        voCli.setSobrenome("");
        
        }
        
    }
}
