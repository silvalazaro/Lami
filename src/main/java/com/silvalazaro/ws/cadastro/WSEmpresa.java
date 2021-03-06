package com.silvalazaro.ws.cadastro;

import com.silvalazaro.modelo.cadastro.Empresa;
import com.silvalazaro.ws.Facade;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Representa o recurso Empresa
 *
 * @author Lazaro Silva
 */
@Path("empresa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WSEmpresa extends Facade<Empresa> {

    public WSEmpresa() {
        super(Empresa.class);
    }
}
