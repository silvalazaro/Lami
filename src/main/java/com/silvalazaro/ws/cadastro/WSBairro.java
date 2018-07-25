package com.silvalazaro.ws.cadastro;

import com.silvalazaro.modelo.cadastro.Bairro;
import com.silvalazaro.ws.Facade;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Representa o recurso Bairro
 *
 * @author Lazaro Silva
 */
@Path("bairro")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WSBairro extends Facade<Bairro> {

    public WSBairro() {
        super(Bairro.class);
    }
}
