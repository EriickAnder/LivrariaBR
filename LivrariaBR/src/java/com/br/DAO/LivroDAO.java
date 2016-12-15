package com.br.DAO;

import com.br.vo.LivroVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    private Connection getConn() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost/livraria", "root", "admin");
    }

    public boolean adiciona(LivroVO vo) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO livro(titulo, autor_id, quantidade, lancamento,categoria, valor_entrada, preco, fornecedor, descricao) values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setString(1, vo.getTitulo());
        pstm.setInt(2, vo.getAutor_id());
        pstm.setInt(3, vo.getQuantidade());
        pstm.setInt(4, vo.getLancamento());
        pstm.setInt(5, vo.getCategoria());
        pstm.setFloat(6, vo.getValor_entrada());
        pstm.setFloat(7, vo.getPreco());
        pstm.setInt(8, vo.getFornecedor_id());
        pstm.setString(9, vo.getDescricao());

        if (pstm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleta(LivroVO vo) throws ClassNotFoundException, SQLException {
        String SQL = "delete from livro where id = ?";
        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setInt(1, vo.getId());

        if (pstm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean atualiza(LivroVO vo) throws ClassNotFoundException, SQLException {
        String SQL = "UPDATE livro SET  titulo = ?, autor_id = ?, quantidade = ?, lancamento = ?,categoria = ?, valor_entrada = ?, preco = ?, fornecedor_id= ?, descricao = ? where id = ? ";
        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setString(1, vo.getTitulo());
        pstm.setInt(2, vo.getAutor_id());
        pstm.setInt(3, vo.getQuantidade());
        pstm.setInt(4, vo.getLancamento());
        pstm.setFloat(5, vo.getValor_entrada());
        pstm.setFloat(6, vo.getPreco());
        pstm.setInt(7, vo.getFornecedor_id());
        pstm.setString(8, vo.getDescricao());
        pstm.setInt(9, vo.getId());
        if (pstm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public List<LivroVO> pesquisarID(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT id, titulo, preco from livro where id = ? order by id";
        PreparedStatement pstm = getConn().prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();

        List<LivroVO> livroPesqId = new ArrayList<LivroVO>();

        while (rs.next()) {
            LivroVO vo = new LivroVO();
            vo.setId(rs.getInt("id"));
            vo.setPreco(rs.getFloat("preco"));
            vo.setTitulo(rs.getString("titulo"));
            livroPesqId.add(vo);
        }

        return livroPesqId;

    }

    public List<LivroVO> lista() throws ClassNotFoundException, SQLException {
        String SQL = "select livro.*,  autor.nome_artistico as nome, autor.id as id_autor, fornecedor.razao_social as fornecedor "
                + "from livro "
                + "inner join autor on autor.id = livro.autor_id "
                + "inner join fornecedor on fornecedor.id = livro.fornecedor order by id";

        PreparedStatement pstm = getConn().prepareStatement(SQL);
        ResultSet rs = pstm.executeQuery();

        List<LivroVO> listaLivro = new ArrayList<LivroVO>();

        while (rs.next()) {
            LivroVO vo = new LivroVO();
            vo.setId(rs.getInt("livro.id"));
            vo.setTitulo(rs.getString("titulo"));
            vo.setAutor_id(rs.getInt("id_autor"));
            vo.setDescricao(rs.getString("descricao"));
            vo.setLancamento(rs.getInt("lancamento"));
            vo.setCategoria(rs.getInt("categoria"));
            vo.setPreco(rs.getFloat("preco"));
            vo.setQuantidade(rs.getInt("quantidade"));
            vo.setFornecedor_id(rs.getInt("fornecedor"));
            vo.setValor_entrada(rs.getFloat("valor_entrada"));
            vo.setNome_fantasia_autor(rs.getString("nome"));
            vo.setFornecedor_razao_social(rs.getString("fornecedor"));
            listaLivro.add(vo);
        }

        return listaLivro;

    }

}
