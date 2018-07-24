package com.silvalazaro.modelo.cadastro;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Representa um Fornecedor, aquele que fornece produtos/serviços
 *
 * @author Lazaro Silva
 */
@Entity
@Table(name = "c_fornecedor")
public class Fornecedor extends PessoaJuridica {

}
