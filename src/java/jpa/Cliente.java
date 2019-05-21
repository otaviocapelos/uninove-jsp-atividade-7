/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    Integer Id;
    @Column(name = "Nome")
    String nome;
    @Column(name = "Cpf")
    String cpf;
    @Column(name = "Salario")
    Double salario;
    @Column(name = "Status")
    Boolean status;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getStatus() {
        return this.status == true ? "Crédito aprovado!" : "Crédito Reprovado!";
    }

    public void setStatus(Double valorEmprestimo, int parcela) {
        this.status = this.realizarEmprestimo(this.salario, valorEmprestimo, parcela);
    }

    private boolean realizarEmprestimo(Double SalarioBruto, Double valorEmprestimo, int parcela) {
        valorEmprestimo = valorEmprestimo * 1.45;
        Double valorMensalidade = valorEmprestimo / parcela;

        if (valorMensalidade < (SalarioBruto * 0.30)) {
            return true;
        } else {
            return false;
        }

    }
}
