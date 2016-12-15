package com.br.DAO;

import com.br.vo.ClienteVO;
import com.br.vo.LivroVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    private Connection getConn() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/livraria", "root", "admin");

    }

    public List<LivroVO> listaLivro(int id) throws ClassNotFoundException, SQLException {
        String SQL = "SELECT titulo, preco from livro where id = ?";
        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        List<LivroVO> listaLivro = new ArrayList<LivroVO>();

        while (rs.next()) {
            LivroVO vo = new LivroVO();

            vo.setTitulo(rs.getString("titulo"));
            vo.setPreco(rs.getFloat("preco"));
            listaLivro.add(vo);
        }
        return listaLivro;
    }

    public List<ClienteVO> listaCliente(String cpf) throws SQLException, ClassNotFoundException {
        String SQL = "SELECT nome, sobrenome from cliente where cpf = ? ";
        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setString(1, cpf);
        ResultSet rs = pstm.executeQuery();
        List<ClienteVO> listaCliente = new ArrayList<ClienteVO>();

        while (rs.next()) {
            ClienteVO vo = new ClienteVO();
            vo.setNome(rs.getString("nome"));
            vo.setSobrenome(rs.getString("sobrenome"));
            listaCliente.add(vo);
        }
        return listaCliente;
    }

}
