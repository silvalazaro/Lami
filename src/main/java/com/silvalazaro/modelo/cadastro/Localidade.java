package com.silvalazaro.modelo.cadastro;

import com.silvalazaro.modelo.Modelo;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Representa uma localidade brasileira
 *
 * @author Lazaro Silva
 */
@Entity(name = "c_localidade")
public class Localidade extends Modelo {

    @Column(name = "cidadeId", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Cidade cidade;
    private String cep;

    @Column(name = "bairroId", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Bairro bairro;
    private String logradouro;
    private String complemento;

}
