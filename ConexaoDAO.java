/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Danniel
 */
public class ConexaoDAO {
    public Connection conn;
    public PreparedStatement pst;
    public ResultSet rs = null;
    public Statement stm = null;
    private final String caminho = "jdbc:mysql://127.0.0.1:3306/MYDB";
    private final String driver = "com.mysql.jdbc.Driver";
    private final String usuario = "root";
    private final String senha = "";

    public void executasql(String sql) {
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("ERRO AO EXECUTAR SQL!\n erro!!!" + ex.getMessage());
        }
    }

    public void conexao() {

        try {
            System.setProperty("jdbc.drivers", driver);
            conn = DriverManager.getConnection(caminho, usuario, senha);

        } catch (SQLException ex) {
            System.out.println( "Conexão com o banco de dados mal sucedida\n" + ex.getMessage()
                    + "\nVerifique se a base de dados está ONLINE....");
            System.exit(0);

        }
    }

    public void desconecta() {
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao desconectar do banco de dados! \n" + ex);
        }

    }
}
