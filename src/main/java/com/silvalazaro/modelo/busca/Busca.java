package com.silvalazaro.modelo.busca;

/**
 * Classe de busca para consultar entidades dinamicamente
 *
 * @author Lázaro Silva
 */
public class Busca {
    private Filtro[] e;
    private Filtro[] ou;
    private String[] atributos;

    public Filtro[] getE() {
        return e;
    }

    public void setE(Filtro[] e) {
        this.e = e;
    }

    public Filtro[] getOu() {
        return ou;
    }

    public void setOu(Filtro[] ou) {
        this.ou = ou;
    }

    public String[] getAtributos() {
        return atributos;
    }

    public void setAtributos(String[] atributos) {
        this.atributos = atributos;
    }
    
}
