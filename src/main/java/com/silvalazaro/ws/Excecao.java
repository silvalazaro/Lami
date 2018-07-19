package com.silvalazaro.ws;

import javax.ws.rs.core.Response;

/**
 *
 * @author Lázaro Silva
 */
public class Excecao extends Exception {

    public Excecao() {
    }

    Response getReponse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
