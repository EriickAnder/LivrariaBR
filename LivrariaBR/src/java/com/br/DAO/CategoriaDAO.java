package com.br.DAO;

import com.br.vo.CategoriaVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private Connection getConn() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost/livraria", "root", "admin");
    }

    public boolean adiciona(CategoriaVO vo) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO categoria(titulo, descricao) values (?,?)";
        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setString(1, vo.getTitulo());
        pstm.setString(2, vo.getDescricao());

        if (pstm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleta(CategoriaVO vo) throws ClassNotFoundException, SQLException {
        String SQL = "delete from categoria where id = ?";
        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setInt(1, vo.getId());

        if (pstm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean atualiza(CategoriaVO vo) throws ClassNotFoundException, SQLException {
        String SQL = "UPDATE categoria SET  titulo = ?, descricao = ? where id =?";
        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setString(1, vo.getTitulo());
        pstm.setString(2, vo.getDescricao());

        if (pstm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public List<CategoriaVO> lista() throws ClassNotFoundException, SQLException {
        String SQL = "Select * from categoria ";

        PreparedStatement pstm = getConn().prepareStatement(SQL);
        ResultSet rs = pstm.executeQuery();

        List<CategoriaVO> listaForn = new ArrayList<CategoriaVO>();

        while (rs.next()) {
            CategoriaVO vo = new CategoriaVO();
            vo.setId(rs.getInt("id"));
            vo.setTitulo(rs.getString("titulo"));
            vo.setDescricao(rs.getString("descricao"));
            listaForn.add(vo);
        }
        return listaForn;
    }

    public List<CategoriaVO> listaId(String pesquisa) throws ClassNotFoundException, SQLException {
        String SQL = "Select * from categoria  where id = ?";

        PreparedStatement pstm = getConn().prepareStatement(SQL);
        int pesq = Integer.parseInt(pesquisa);
        pstm.setInt(1, pesq);
        ResultSet rs = pstm.executeQuery();

        List<CategoriaVO> listaFornID = new ArrayList<CategoriaVO>();

        while (rs.next()) {
            CategoriaVO vo = new CategoriaVO();
            vo.setId(rs.getInt("id"));
            vo.setTitulo(rs.getString("titulo"));
            vo.setDescricao(rs.getString("descricao"));

            listaFornID.add(vo);
        }

        return listaFornID;

    }

    public List<CategoriaVO> listaTitulo(String titulo) throws ClassNotFoundException, SQLException {
        String SQL = "Select * from categoria  where titulo like ?";

        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setString(1, "%" + titulo + "%");
        ResultSet rs = pstm.executeQuery();

        List<CategoriaVO> listaFornID = new ArrayList<CategoriaVO>();

        while (rs.next()) {
            CategoriaVO vo = new CategoriaVO();
            vo.setId(rs.getInt("id"));
            vo.setTitulo(rs.getString("titulo"));
            vo.setDescricao(rs.getString("descricao"));

            listaFornID.add(vo);
        }

        return listaFornID;

    }

}
