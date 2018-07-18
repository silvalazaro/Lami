package com.silvalazaro.teste.ws.cadastro;

import com.silvalazaro.modelo.cadastro.PessoaFisica;
import com.silvalazaro.teste.ServidorTest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import junit.framework.TestCase;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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

    static Client client = ResteasyClientBuilder.newBuilder().build();
    static WebTarget destino;

    public WSPessoaFisicaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        // limpar tabela

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        client = ClientBuilder.newClient();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01LimpaTabelaPessoaFisica() {
        destino = client.target(ServidorTest.PATH + "pessoaFisica");
        Response resp = destino.request().delete();
        TestCase.assertEquals(200, resp.getStatus());
    }

    @Test
    public void test02Cadastro() {
        Response resp = null;

        PessoaFisica pf1 = new PessoaFisica();
        pf1.setId(1);
        pf1.setCpf("64974795031");
        pf1.setEmail("teste@teste.com");
        pf1.setNome("Joao Sousa Silva");
        pf1.setTelefone("82988881234");

        destino = client.target("http://localhost:8081/ws/pessoaFisica");
        resp = destino.request().post(Entity.entity(pf1, MediaType.APPLICATION_JSON));

        TestCase.assertEquals("01", 201, resp.getStatus());

        PessoaFisica pf2 = new PessoaFisica();
        pf2.setId(2);
        pf2.setCpf("64974795032");
        pf2.setEmail("maria@teste.com");
        pf2.setNome("Maria Sousa Silva");
        pf2.setTelefone("82288881231");

        destino = client.target(ServidorTest.PATH + "pessoaFisica");
        resp = destino.request().post(Entity.entity(pf2, MediaType.APPLICATION_JSON));
        TestCase.assertEquals("02", 201, resp.getStatus());
    }

    @Test
    public void test03Remove() {
        destino = client.target(ServidorTest.PATH + "pessoaFisica/1");
        Response resp = destino.request().delete();
        TestCase.assertEquals("Remove 1", 200, resp.getStatus());
    }

    @Test
    public void test04Busca() {
        Response resp = null;
        PessoaFisica pf1 = null;

        destino = client.target(ServidorTest.PATH + "pessoaFisica/2");
        destino.request().accept(MediaType.APPLICATION_JSON);
        resp = destino.request().get();
        TestCase.assertEquals("01", 200, resp.getStatus());
        pf1 = resp.readEntity(PessoaFisica.class);
        TestCase.assertEquals("02", 2, pf1.getId());
    }

    @Test
    public void test04Atualiza() {
        Response resp = null;
        PessoaFisica pf1 = null;
        // busca cadastro
        destino = client.target(ServidorTest.PATH + "pessoaFisica/2");
        destino.request().accept(MediaType.APPLICATION_JSON);
        resp = destino.request().get();
        TestCase.assertEquals("01", 200, resp.getStatus());
        // atualiza
        pf1 = resp.readEntity(PessoaFisica.class);
        pf1.setNome("Jose");
        pf1.setEmail(null);
        destino = client.target(ServidorTest.PATH + "pessoaFisica");
        destino.request().accept(MediaType.APPLICATION_JSON);
        resp = destino.request().put(Entity.entity(pf1, MediaType.APPLICATION_JSON));
        TestCase.assertEquals("02", 200, resp.getStatus());
        
        pf1 = resp.readEntity(PessoaFisica.class);
        TestCase.assertEquals("03", "Jose", pf1.getNome());
        

    }

}
