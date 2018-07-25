package com.silvalazaro.ws.cadastro;

import com.silvalazaro.modelo.cadastro.Bairro;
import com.silvalazaro.modelo.cadastro.Localidade;
import com.silvalazaro.ws.Facade;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Representa o recurso Localidade
 *
 * @author Lazaro Silva
 */
@Path("/localidades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WSLocalidade extends Facade<Localidade> {

    public WSLocalidade() {
        super(Localidade.class);
    }
}
