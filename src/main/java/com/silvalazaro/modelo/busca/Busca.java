package com.silvalazaro.modelo.busca;

import java.util.ArrayList;

/**
 * Classe de busca para consultar entidades dinamicamente
 *
 * @author Lázaro Silva
 */
public class Busca {
    private ArrayList<Filtro> e;
    private ArrayList<Filtro> ou;
    private String[] atributos;

    public ArrayList<Filtro> getE() {
        return e;
    }

    public void setE(ArrayList<Filtro> e) {
        this.e = e;
    }

    public ArrayList<Filtro> getOu() {
        return ou;
    }

    public void setOu(ArrayList<Filtro> ou) {
        this.ou = ou;
    }

    public String[] getAtributos() {
        return atributos;
    }

    public void setAtributos(String[] atributos) {
        this.atributos = atributos;
    }
    
}
