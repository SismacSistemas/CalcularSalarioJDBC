/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.View;

import br.com.Controler.FuncionarioControle;
import br.com.Model.Funcionario;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Diego Danniel
 */
public class Menu {

    private static FuncionarioControle buscar;
    Funcionario funcionarios;

    public Menu() {
        buscar = new FuncionarioControle();
        funcionarios = new Funcionario();
    }

    public static void main(String[] args) {

        Menu menu = new Menu();
        Scanner sca = new Scanner(System.in);
        String comando;
        int i = 0;
        System.out.println("***Menu de Calculo de salario***\n");
        System.out.println("Digite um comando para\n");
        System.out.println("1-Listar todos os funcionarios\n");
        System.out.println("2-Calcular o salario\n");
        System.out.println("0-Sair");

        comando = sca.nextLine();
        switch (comando.toLowerCase()) {
            case "1":
                System.out.println("Lista dos funcionarios\n");
                menu.listarFuncionarios();
                break;
            case "2":
                System.out.println("Calculo de salario\n");
                menu.calcularValores();
                break;
            case "3":
                System.out.println("passo 3");
                break;
            case "0":
                System.exit(0);
                break;
            default:
                System.out.println("Nenhum comando encontrado!1");
                break;
        }

    }

    /**
     *
     */
    public void listarFuncionarios() {
        
        try {
            buscar.listarFuncionarios();
            if (buscar.getFuncionario().isEmpty()) {
                System.out.println("Erro ");
            } else {
                buscar.getFuncionario().forEach((buscar1) -> {
                    int codigo = buscar1.getIdFuncionario();
                    String nome = String.valueOf(buscar1.getNomeFuncionario());
                    Double valorSalario = buscar1.getVlSalarioBruto();

                    System.out.println("Codigo: " + codigo);
                    System.out.println("Funcionario nome: " + nome);
                    System.out.println("Valor do salario R$" + valorSalario);
                });
            }
        } catch (SQLException ex) {
            System.out.println("Erro "+ex.getMessage());
        }
    }

    public void calcularValores() {
        
        buscar.calculaDesconto();
        if (buscar.getFuncionario().isEmpty()) {
            System.out.println("Erro");
        } else {
            buscar.getFuncionario().forEach((buscar1) -> {
           
                buscar1.imprimirCalculo();
            });
        }
    }
}
