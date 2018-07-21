package com.silvalazaro.modelo.busca;

import java.util.ArrayList;

/**
 * Classe de filtro para consultas dinamicas ao banco
 *
 * @author Lázaro Silva
 */
public class Filtro {

    private String propriedade;
    private String valor;
    private String operador;
    private ArrayList<Filtro> e;
    private ArrayList<Filtro> ou;

    public Filtro(){
        
    }
    
    public Filtro(String propriedade, String operador, String valor){
        this.propriedade = propriedade; 
        this.operador = operador;
        this.valor = valor;
    }
    
    public String getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(String propriedade) {
        this.propriedade = propriedade;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String comparacao) {
        this.operador = comparacao;
    }

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
    
}
