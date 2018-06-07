/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Model;

/**
 *
 * @author Diego Danniel
 */
public class Funcionario {

    private int idFuncionario;
    private String nomeFuncionario;
    private double vlSalarioBruto;
    private double vlSalarioLiquido;
    private double vlDesconto;

    public Funcionario() {

    }

    public Funcionario(int idFuncionario, String nomeFuncionario, double vlSalarioBruto) {
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.vlSalarioBruto = vlSalarioBruto;
    }

    public Funcionario(int idFuncionario, String nomeFuncionario, double vlSalarioBruto, double vlDesconto) {
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.vlSalarioBruto = vlSalarioBruto;
        this.vlDesconto = vlDesconto;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public double getVlSalarioBruto() {
        return vlSalarioBruto;
    }

    public void setVlSalarioBruto(double vlSalarioBruto) {
        this.vlSalarioBruto = vlSalarioBruto;
    }

    public double getVlDesconto() {
        return vlDesconto;
    }

    public void setVlDesconto(double vlDesconto) {
        this.vlDesconto = vlDesconto;
    }

    public double getVlSalarioLiquido() {
        return vlSalarioLiquido = getVlSalarioBruto() - getVlDesconto();
    }

    public void setVlSalarioLiquido(double vlSalarioLiquido) {
        this.vlSalarioLiquido = vlSalarioLiquido;
    }
   

    public void imprimirCalculo() {
        System.out.println("**Codigo:" +getIdFuncionario()+" Nome funcionario: "+getNomeFuncionario());
        System.out.println("**Salario bruto: R$" +getVlSalarioBruto()+" - Valor do desconto: R$"+getVlDesconto());
        System.out.println("**Salario liquido do funcionario e: R$" +getVlSalarioLiquido());
    }

}
