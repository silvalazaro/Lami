package com.silvalazaro.teste.ws.cadastro;

import com.silvalazaro.modelo.busca.Busca;
import com.silvalazaro.modelo.busca.Filtro;
import com.silvalazaro.modelo.cadastro.PessoaFisica;
import com.silvalazaro.teste.HttpMetodo;
import com.silvalazaro.teste.ServidorTest;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Classe de teste do recurso PessoaFisica
 *
 * @author Lázaro Silva
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WSPessoaFisicaTest {

    private String link;

    public WSPessoaFisicaTest() {
        link = ServidorTest.link + "pessoaFisica/";
    }

    @Test
    public void test01LimpaTabelaPessoaFisica() {
        Response resp = ServidorTest.request(link, HttpMetodo.DELETE);
        TestCase.assertEquals(200, resp.getStatus());
    }

    @Test
    public void test02CadastroValido01() {
        Response resp;
        PessoaFisica pf = new PessoaFisica();

        pf.setId(1);
        pf.setCpf("64974795031");
        pf.setEmail("teste@teste.com");
        pf.setNome("Joao Sousa Silva");
        pf.setTelefone("82988881234");

        resp = ServidorTest.requestPOST(link, Entity.entity(pf, MediaType.APPLICATION_JSON));
        TestCase.assertEquals(201, resp.getStatus());
    }

    @Test
    public void test03CadastroValido02() {
        Response resp;
        PessoaFisica pf2 = new PessoaFisica();

        pf2.setId(2);
        pf2.setCpf("64974795032");
        pf2.setEmail("maria@teste.com");
        pf2.setNome("Maria Sousa Silva");
        pf2.setTelefone("82288881231");

        resp = ServidorTest.requestPOST(link, Entity.entity(pf2, MediaType.APPLICATION_JSON));
        TestCase.assertEquals("02", 201, resp.getStatus());

    }

    @Test
    public void test04Remove() {
        Response resp = ServidorTest.request(link + "1", HttpMetodo.DELETE);
        TestCase.assertEquals(200, resp.getStatus());
    }

    @Test
    public void test05BuscaPorId() {
        Response resp;
        PessoaFisica pf1;
        // busca por ID
        resp = ServidorTest.request(link + "2", HttpMetodo.GET);
        TestCase.assertEquals(200, resp.getStatus());

        pf1 = resp.readEntity(PessoaFisica.class);
        TestCase.assertEquals(2, pf1.getId());

    }

    @Test
    public void test06BuscaPorFiltro01() {
        // busca por filtro
        Busca busca1 = new Busca();
        busca1.setFiltro(new Filtro("nome", "%", "%Maria%"));
        Response resp = ServidorTest.requestPOST(link + "busca", Entity.entity(busca1, MediaType.APPLICATION_JSON));
        TestCase.assertEquals(200, 200);
        List<PessoaFisica> pessoas1 = resp.readEntity(new GenericType<List<PessoaFisica>>() {
        });
        TestCase.assertEquals(true, pessoas1.get(0).getNome().contains("Maria"));
    }

    @Test
    public void test07BuscaPorFiltro01() {
        // busca por filtro
        Busca busca1 = new Busca();
        busca1.setFiltro(new Filtro("nome", "%", "%Maria%"));
        Response resp = ServidorTest.requestPOST(link + "busca", Entity.entity(busca1, MediaType.APPLICATION_JSON));
        TestCase.assertEquals(200, 200);
        List<PessoaFisica> pessoas1 = resp.readEntity(new GenericType<List<PessoaFisica>>() {
        });
        TestCase.assertEquals(true, pessoas1.get(0).getNome().contains("Maria"));
    }

    @Test
    public void test08Atualiza() {
        Response resp;
        PessoaFisica pf1;
        resp = ServidorTest.request(link + "2", HttpMetodo.GET);
        TestCase.assertEquals(200, resp.getStatus());
        // atualiza
        pf1 = resp.readEntity(PessoaFisica.class);
        pf1.setNome("Josefa Santos Silva");

        resp = ServidorTest.requestPUT(link, Entity.entity(pf1, MediaType.APPLICATION_JSON));
        TestCase.assertEquals(200, resp.getStatus());

        pf1 = resp.readEntity(PessoaFisica.class);
        TestCase.assertEquals(true, pf1.getNome().contains("Jose"));
    }

}
