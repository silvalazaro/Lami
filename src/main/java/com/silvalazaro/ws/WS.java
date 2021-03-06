package com.silvalazaro.ws;

import com.silvalazaro.ws.cadastro.WSEmpresa;
import com.silvalazaro.ws.cadastro.WSPessoaFisica;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Representa o servidor WebService
 *
 * @author Lazaro Silva
 */
@ApplicationPath("ws")
public class WS extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public WS() {
        singletons.add(new WSEmpresa());
        singletons.add(new WSPessoaFisica());
        singletons.add(new ExcecaoMapper());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
