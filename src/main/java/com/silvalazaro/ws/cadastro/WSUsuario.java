package com.silvalazaro.ws.cadastro;

import com.silvalazaro.modelo.cadastro.Usuario;
import com.silvalazaro.ws.Facade;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Representa o recurso Usuario
 *
 * @author Lazaro Silva
 */
@Path("usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WSUsuario extends Facade<Usuario> {

    public WSUsuario() {
        super(Usuario.class);
    }
}
