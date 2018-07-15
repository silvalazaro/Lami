package com.silvalazaro.ws.cadastro;

import com.silvalazaro.modelo.cadastro.PessoaFisica;
import com.silvalazaro.ws.Facade;
import javax.ws.rs.Path;

/**
 *
 * @author Lázaro Silva
 * @param <T>
 */
@Path("pessoaFisica")
public class WSPessoaFisica extends Facade<PessoaFisica> {

    public WSPessoaFisica() {
        super(PessoaFisica.class);
    }
}
