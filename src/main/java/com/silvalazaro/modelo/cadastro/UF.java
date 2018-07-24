package com.silvalazaro.modelo.cadastro;

import com.silvalazaro.modelo.Modelo;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Representa Unidade Federativa Brasileira - UF
 *
 * @author Lazaro Silva
 */
@Entity
@Table(name = "c_uf")
public class UF extends Modelo {

    private String nome;
    private String sigla;
    
    @OneToMany(mappedBy = "cidade")
    private List<Cidade> cidades;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

}
