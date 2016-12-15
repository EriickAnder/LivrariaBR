package com.br.DAO;

import com.br.vo.ClienteVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private Connection getConn() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost/livraria", "root", "admin");
    }

    public boolean adiciona(ClienteVO vo) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO cliente(nome,sobrenome, cpf, nascimento) values (?,?,?,?)";
        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setString(1, vo.getNome());
        pstm.setString(2, vo.getSobrenome());
        pstm.setString(3, vo.getCpf());
        pstm.setString(4, vo.getNascimento());

        if (pstm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleta(ClienteVO vo) throws ClassNotFoundException, SQLException {
        String SQL = "delete from cliente where id = ?";
        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setInt(1, vo.getId());

        if (pstm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean atualiza(ClienteVO vo) throws ClassNotFoundException, SQLException {
        String SQL = "UPDATE cliente SET nome = ?, sobrenome = ?, cpf = ?, nascimento = ? where id = ?";
        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setString(1, vo.getNome());
        pstm.setString(2, vo.getSobrenome());
        pstm.setString(3, vo.getCpf());
        pstm.setString(4, vo.getNascimento());
        pstm.setInt(1, vo.getId());

        if (pstm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public List<ClienteVO> lista() throws ClassNotFoundException, SQLException {
        String SQL = "Select * from cliente ";

        PreparedStatement pstm = getConn().prepareStatement(SQL);
        ResultSet rs = pstm.executeQuery();

        List<ClienteVO> listaCli = new ArrayList<ClienteVO>();

        while (rs.next()) {
            ClienteVO vo = new ClienteVO();
            vo.setId(rs.getInt("id"));
            vo.setNome(rs.getString("nome"));
            vo.setSobrenome(rs.getString("sobrenome"));
            vo.setCpf(rs.getString("cpf"));
            vo.setNascimento(rs.getString("nascimento"));

            listaCli.add(vo);
        }

        return listaCli;

    }

    public List<ClienteVO> listaCPF(String cpf) throws ClassNotFoundException, SQLException {
        String SQL = "Select * from cliente where cpf = ? ";

        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setString(1, cpf);
        ResultSet rs = pstm.executeQuery();

        List<ClienteVO> listaCliID = new ArrayList<ClienteVO>();

        while (rs.next()) {
            ClienteVO vo = new ClienteVO();
            vo.setId(rs.getInt("id"));
            vo.setNome(rs.getString("nome"));
            vo.setSobrenome(rs.getString("sobrenome"));
            vo.setCpf(rs.getString("cpf"));
            vo.setNascimento(rs.getString("nascimento"));

            listaCliID.add(vo);
        }

        return listaCliID;

    }

    public List<ClienteVO> listaNome(String nome) throws ClassNotFoundException, SQLException {
        String SQL = "Select * from cliente where nome like ? ";

        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setString(1, "%" + nome + "%");
        ResultSet rs = pstm.executeQuery();

        List<ClienteVO> listaCliNome = new ArrayList<ClienteVO>();

        while (rs.next()) {
            ClienteVO vo = new ClienteVO();
            vo.setId(rs.getInt("id"));
            vo.setNome(rs.getString("nome"));
            vo.setSobrenome(rs.getString("sobrenome"));
            vo.setCpf(rs.getString("cpf"));
            vo.setNascimento(rs.getString("nascimento"));

            listaCliNome.add(vo);
        }

        return listaCliNome;

    }

}
