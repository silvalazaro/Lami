package com.silvalazaro.modelo.cadastro;

import com.silvalazaro.modelo.Modelo;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Usuario do sistema
 *
 * @author Lázaro Silva
 */
@Entity
@Table(name = "c_usuario")
public class Usuario extends Modelo {

    private String email;
    private String cpf;
    @OneToOne
    private PessoaFisica pessoaFisica;
    private boolean ativo;
    private int versao;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getVersao() {
        return versao;
    }

    public void setVersao(int versao) {
        this.versao = versao;
    }
}
