package com.silvalazaro.modelo.cadastro;

import com.silvalazaro.modelo.Modelo;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Representa uma cidade
 *
 * @author Lazaro Silva
 */
@Entity
@Table(name = "c_cidade")
public class Cidade extends Modelo {

    private String nome;
    
    @Column(name = "ufId", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private UF uf;
    
    @OneToMany(mappedBy = "cidade")
    private List<Bairro> bairros;
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

}
