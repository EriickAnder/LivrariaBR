package com.br.DAO;

import com.br.vo.FornecedorVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    private Connection getConn() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost/livraria", "root", "admin");
    }

    public boolean adiciona(FornecedorVO vo) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO fornecedor(razao_social, nome_fantasia, cpnj, telefone, data_cadastro) values (?,?,?,?,?)";
        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setString(1, vo.getRazao_social());
        pstm.setString(2, vo.getNome_fantasia());
        pstm.setInt(3, vo.getCpnj());
        pstm.setInt(4, vo.getTelefone());
        pstm.setInt(5, vo.getData_cadastro());

        if (pstm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleta(FornecedorVO vo) throws ClassNotFoundException, SQLException {
        String SQL = "delete from fornecedor where id = ?";
        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setInt(1, vo.getId());

        if (pstm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean atualiza(FornecedorVO vo) throws ClassNotFoundException, SQLException {
        String SQL = "UPDATE fornecedor SET  razao_social = ?, nome_fantasia = ?, cpnj = ?, telefone = ?, data_cadastro = ? where id =?";
        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setString(1, vo.getRazao_social());
        pstm.setString(2, vo.getNome_fantasia());
        pstm.setInt(3, vo.getCpnj());
        pstm.setInt(4, vo.getTelefone());
        pstm.setInt(5, vo.getData_cadastro());
        pstm.setInt(6, vo.getId());

        if (pstm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public List<FornecedorVO> listaTudo() throws ClassNotFoundException, SQLException {
        String SQL = "Select * from fornecedor ";

        PreparedStatement pstm = getConn().prepareStatement(SQL);
        ResultSet rs = pstm.executeQuery();

        List<FornecedorVO> listaForn = new ArrayList<FornecedorVO>();

        while (rs.next()) {
            FornecedorVO vo = new FornecedorVO();
            vo.setId(rs.getInt("id"));
            vo.setRazao_social(rs.getString("razao_social"));
            vo.setNome_fantasia(rs.getString("nome_fantasia"));
            vo.setCpnj(rs.getInt("cpnj"));
            vo.setTelefone(rs.getInt("telefone"));
            vo.setData_cadastro(rs.getInt("data_cadastro"));

            listaForn.add(vo);
        }

        return listaForn;

    }

    public List<FornecedorVO> listaId(int id) throws ClassNotFoundException, SQLException {
        String SQL = "Select * from fornecedor where id = ? ";

        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();

        List<FornecedorVO> listaFornID = new ArrayList<FornecedorVO>();

        while (rs.next()) {
            FornecedorVO vo = new FornecedorVO();
            vo.setId(rs.getInt("id"));
            vo.setRazao_social(rs.getString("razao_social"));
            vo.setNome_fantasia(rs.getString("nome_fantasia"));
            vo.setCpnj(rs.getInt("cpnj"));
            vo.setTelefone(rs.getInt("telefone"));
            vo.setData_cadastro(rs.getInt("data_cadastro"));

            listaFornID.add(vo);
        }

        return listaFornID;

    }

    public List<FornecedorVO> listaNome(String nome) throws ClassNotFoundException, SQLException {
        String SQL = "Select * from fornecedor where nome_fantasia like ? ";

        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setString(1, "%" + nome + "%");
        ResultSet rs = pstm.executeQuery();

        List<FornecedorVO> listaFornNome = new ArrayList<FornecedorVO>();

        while (rs.next()) {
            FornecedorVO vo = new FornecedorVO();
            vo.setId(rs.getInt("id"));
            vo.setRazao_social(rs.getString("razao_social"));
            vo.setNome_fantasia(rs.getString("nome_fantasia"));
            vo.setCpnj(rs.getInt("cpnj"));
            vo.setTelefone(rs.getInt("telefone"));
            vo.setData_cadastro(rs.getInt("data_cadastro"));

            listaFornNome.add(vo);
        }

        return listaFornNome;

    }

    public List<FornecedorVO> listaCnpj(String cnpj) throws ClassNotFoundException, SQLException {
        String SQL = "Select * from fornecedor where cpnj like ? ";

        PreparedStatement pstm = getConn().prepareStatement(SQL);
        pstm.setString(1, "%" + cnpj + "%");
        ResultSet rs = pstm.executeQuery();

        List<FornecedorVO> listaFornCNPJ = new ArrayList<FornecedorVO>();

        while (rs.next()) {
            FornecedorVO vo = new FornecedorVO();
            vo.setId(rs.getInt("id"));
            vo.setRazao_social(rs.getString("razao_social"));
            vo.setNome_fantasia(rs.getString("nome_fantasia"));
            vo.setCpnj(rs.getInt("cpnj"));
            vo.setTelefone(rs.getInt("telefone"));
            vo.setData_cadastro(rs.getInt("data_cadastro"));

            listaFornCNPJ.add(vo);
        }

        return listaFornCNPJ;

    }

}
