package com.silvalazaro.modelo.cadastro;

import com.silvalazaro.modelo.Modelo;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Representa um bairro de uma cidade ou distrito
 *
 * @author Lázaro Silva
 */
@Entity
@Table(name = "c_bairro")
public class Bairro extends Modelo {

    private String nome;

    @Column(name = "cidadeId", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Cidade cidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}
