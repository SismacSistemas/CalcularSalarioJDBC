/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.Controler.FuncionarioControle;
import br.com.Model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Danniel
 */
public class FuncionariosDAO {

    ConexaoDAO conect = new ConexaoDAO();
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    FuncionarioControle func;

    public FuncionariosDAO() {

    }

    public List<Funcionario> findAll() throws SQLException {
        List<Funcionario> funcionario = new ArrayList<>();
        conect.conexao();
        func = new FuncionarioControle();

        String sql = "SELECT * FROM `funcionario` f ORDER BY f.`VL_SALARIO_BRUTO`";
        try {
            pst = conect.conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                funcionario.add(new Funcionario(rs.getInt("ID_FUNCIONARIO"),
                        rs.getString("NM_CLIENTE"),
                        rs.getDouble("VL_SALARIO_BRUTO")));
            }
            return funcionario;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
        return funcionario;

    }

    public List<Funcionario> listar() {
        List<Funcionario> funcionario = new ArrayList<>();
        conect.conexao();
        func = new FuncionarioControle();
        String sql = "SELECT * FROM `DESCONTOS` \n"
                + "NATURAL JOIN `FUNCIONARIO` ";
        try {
            pst = conect.conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                funcionario.add(new Funcionario(rs.getInt("ID_FUNCIONARIO"), rs.getString("NM_CLIENTE"),
                        rs.getDouble("VL_SALARIO_BRUTO"), rs.getDouble("VL_DESCONTO")));
            }
            return funcionario;
        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getMessage());
        }

        return funcionario;
    }

}
