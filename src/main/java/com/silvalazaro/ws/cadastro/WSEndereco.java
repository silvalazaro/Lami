package com.silvalazaro.ws.cadastro;

import com.silvalazaro.modelo.cadastro.Endereco;
import com.silvalazaro.ws.Facade;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Representa o recurso Endereco
 *
 * @author Lazaro Silva
 */
@Path("/enderecos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WSEndereco extends Facade<Endereco> {

    public WSEndereco() {
        super(Endereco.class);
    }
}
