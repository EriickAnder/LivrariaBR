package com.br.DAO;

import com.br.vo.AutorVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {

    private Connection getConn() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost/livraria", "root", "admin");
    }

    public boolean adiciona(AutorVO vo) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO autor(nome, nome_artistico, data_nascimento) values (?,?,?)";
        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setString(1, vo.getNome());
        pstm.setString(2, vo.getNome_artistico());
        pstm.setInt(3, vo.getData_nascimento());

        if (pstm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleta(AutorVO vo) throws ClassNotFoundException, SQLException {
        String SQL = "delete from autor where id = ?";
        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setInt(1, vo.getId());

        if (pstm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean atualiza(AutorVO vo) throws ClassNotFoundException, SQLException {
        String SQL = "UPDATE autor SET  nome = ?, nome_artistico = ?, data_nascimento = ? where id = ? ";
        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setString(1, vo.getNome());
        pstm.setString(2, vo.getNome_artistico());
        pstm.setInt(3, vo.getData_nascimento());
        pstm.setInt(4, vo.getId());

        if (pstm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public List<AutorVO> lista() throws ClassNotFoundException, SQLException {
        String SQL = "Select a.* from autor a";

        PreparedStatement pstm = getConn().prepareStatement(SQL);
        ResultSet rs = pstm.executeQuery();

        List<AutorVO> listaLivro = new ArrayList<AutorVO>();

        while (rs.next()) {
            AutorVO vo = new AutorVO();
            vo.setId(rs.getInt("a.id"));
            vo.setNome(rs.getString("a.nome"));
            vo.setNome_artistico(rs.getString("a.nome_artistico"));
            vo.setData_nascimento(rs.getInt("a.data_nascimento"));

            listaLivro.add(vo);
        }

        return listaLivro;

    }

    public ArrayList<AutorVO> listaNome(String pesq) throws ClassNotFoundException, SQLException {
        String SQL = "Select * from autor where nome like ? ";

        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setString(1, '%' + pesq + '%');
        ResultSet rs = pstm.executeQuery();
        ArrayList<AutorVO> autorId = new ArrayList<AutorVO>();

        while (rs.next()) {
            AutorVO vo1 = new AutorVO();
            vo1.setId(rs.getInt("id"));
            vo1.setNome(rs.getString("nome"));
            vo1.setNome_artistico(rs.getString("nome_artistico"));
            vo1.setData_nascimento(rs.getInt("data_nascimento"));

            autorId.add(vo1);

        }

        return autorId;
    }

}
