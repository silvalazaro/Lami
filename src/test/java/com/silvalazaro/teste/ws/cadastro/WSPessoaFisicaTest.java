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

    static Client client = ClientBuilder.newClient();
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
    public void test01LimpaCadastroPessoaFisica() {
        destino = client.target(ServidorTest.PATH + "pessoaFisica");
        Response resp = destino.request().delete();
        TestCase.assertEquals(200, resp.getStatus());
    }

    @Test
    public void test02CadastroValidoPessoaFisica() {
        PessoaFisica pf = new PessoaFisica();
        pf.setCpf("64974795031");
        pf.setEmail("teste@teste.com");
        pf.setNome("Joao Sousa Silva");
        pf.setTelefone("82988881234");
        WebTarget target = client.target("http://localhost:8081/ws/pessoaFisica");
        try (Response resp = target.request().post(Entity.entity(pf, MediaType.APPLICATION_JSON))) {
            TestCase.assertEquals("POST ws/pessoasFisicas", 201, resp.getStatus());
        }
    }
}
