package com.silvalazaro.ws.cadastro;

import com.silvalazaro.modelo.cadastro.PessoaFisica;
import com.silvalazaro.ws.Facade;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Lázaro Silva
 */
@Path("pessoaFisica")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WSPessoaFisica extends Facade<PessoaFisica> {

    public WSPessoaFisica() {
        super(PessoaFisica.class);
    }
}
