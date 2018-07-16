package com.silvalazaro.teste;

import com.silvalazaro.teste.ws.cadastro.WSPessoaFisicaTest;
import com.silvalazaro.ws.WS;
import com.silvalazaro.ws.cadastro.WSPessoaFisica;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import org.jboss.resteasy.plugins.server.sun.http.HttpContextBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Prepara o teste das class
 *
 * @author Lázaro Silva
 */
@RunWith(Suite.class)
@SuiteClasses({WSPessoaFisicaTest.class})
public class ServidorTest {

    public static HttpServer servidor;
    public static final String PATH = "http://localhost:8081/ws/";

    @BeforeClass
    public static void setUpClass() throws IOException {
        System.err.println("Inicializa");
        servidor = HttpServer.create(new InetSocketAddress(8081), 10);
        HttpContextBuilder contextBuilder = new HttpContextBuilder();
        contextBuilder.getDeployment().setApplication(new WS());
        contextBuilder.setPath("ws");
        contextBuilder.getDeployment().getActualResourceClasses().add(WSPessoaFisica.class);
        HttpContext context = contextBuilder.bind(servidor);
        //context.getAttributes().put("some.config.info", "42");
        servidor.start();
        
    }

    @AfterClass
    public static void tearDownClass() {
        System.err.println("Finaliza");
        servidor.stop(0);
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
