package com.silvalazaro.teste.ws.cadastro;

import com.silvalazaro.modelo.cadastro.PessoaFisica;
import com.silvalazaro.ws.cadastro.WSPessoaFisica;
import com.silvalazaro.ws.Facade;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Classe de teste do recurso PessoaFisica
 *
 * @author Lázaro Silva
 */
public class WSPessoaFisicaTest {

    Facade ws;
    Client client;

    public WSPessoaFisicaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ws = new WSPessoaFisica();
        client = ClientBuilder.newClient();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCadastroValidoPessoaFisica() {
        PessoaFisica pf = new PessoaFisica();
        pf.setCpf("64974795031");
        pf.setEmail("teste@teste.com");
        pf.setNome("Joao Sousa Silva");
        pf.setTelefone("82988881234");

        WebTarget target = client.target("http://localhost/ws/pessoaFisica");
        try (Response resp = target.request().post(Entity.entity(pf, MediaType.APPLICATION_JSON))) {
            TestCase.assertEquals("POST ws/pessoasFisicas", Response.Status.CREATED, resp.getStatus());
        }
    }
}
