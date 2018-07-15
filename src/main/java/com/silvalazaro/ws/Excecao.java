package com.silvalazaro.ws;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.math.BigDecimal;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Classe que centraliza o tratamento de exeções do Web Service
 *
 * @author Lázaro Silva
 */
@Provider
public class Excecao implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
         ObjectNode json = new ObjectNode(JsonNodeFactory.instance);
         json.put("erro", e.getMessage());
         System.err.println(e.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(json.toString()).build();
    }

}
