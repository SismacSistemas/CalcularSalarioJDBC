/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controler;

import br.com.DAO.FuncionariosDAO;
import br.com.Model.Funcionario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Diego Danniel
 */
public class FuncionarioControle {
    private Funcionario funcionario;
    private List<Funcionario> funcionarios;
    private FuncionariosDAO dao;
    
    public FuncionarioControle(){
        dao = new FuncionariosDAO();
        
    }
    public void listarFuncionarios() throws SQLException{
        funcionarios = dao.findAll();
    }
    public void calculaDesconto(){
        funcionarios = dao.listar();
    }
    
    public List<Funcionario> getFuncionario(){
        return funcionarios;
    }
    
    
    
    
    
}
