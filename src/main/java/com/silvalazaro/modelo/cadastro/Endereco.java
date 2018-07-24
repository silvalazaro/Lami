package com.silvalazaro.modelo.cadastro;

import com.silvalazaro.modelo.Modelo;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Representa um endereço territorial
 *
 * @author Lázaro Silva
 */
@Entity
@Table(name = "c_endereco")
public class Endereco extends Modelo {

    @Column(name = "cidadeId")
    @ManyToOne(cascade = CascadeType.ALL)
    private Cidade cidade;

    private String cep;

    private String logradouro;

    private String complemento;

    @Column(name = "bairroId")
    @ManyToOne(cascade = CascadeType.ALL)
    private Bairro bairro;

    @Column(name = "pessoaFisicaId")
    @ManyToOne(cascade = CascadeType.ALL)
    private PessoaFisica pessoaFisica;

    @Column(name = "pessoaJuridicaId")
    @ManyToOne(cascade = CascadeType.ALL)
    private PessoaJuridica pessoaJuridica;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

}
