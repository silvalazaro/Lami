package com.silvalazaro.ws.cadastro;

import com.silvalazaro.modelo.cadastro.Fornecedor;
import com.silvalazaro.ws.Facade;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Representa o recurso Fornecedor
 *
 * @author Lazaro Silva
 */
@Path("fornecedor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WSFornecedor extends Facade<Fornecedor> {

    public WSFornecedor() {
        super(Fornecedor.class);
    }
}
