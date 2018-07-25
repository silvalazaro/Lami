package com.silvalazaro.ws.cadastro;

import com.silvalazaro.modelo.cadastro.Cidade;
import com.silvalazaro.ws.Facade;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Representa o recurso Cidade
 *
 * @author Lazaro Silva
 */
@Path("cidade")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WSCidade extends Facade<Cidade> {

    public WSCidade() {
        super(Cidade.class);
    }
}
