package com.silvalazaro.modelo.cadastro;



import com.silvalazaro.modelo.Modelo;

/**
 * Representa o cadastro de uma entidade. 
 * A subclasse pode ser uma Pessoa Física ou uma Empresa
 * @author Lazaro Silva
 */
public abstract class Cadastro extends Modelo{
    private CadastroEndereco endereco;
}
