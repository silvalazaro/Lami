package com.silvalazaro.modelo.cadastro;

import com.silvalazaro.modelo.Modelo;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Representa uma Pessoa Física
 *
 * @author Lazaro Silva
 */
@Entity
@Table(name = "c_pessoa_fisica")
public class PessoaFisica extends Modelo {

    private String cpf;
    private String nome;
    private String email;
    private String telefone;

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
