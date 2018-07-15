package com.silvalazaro.teste.ws.cadastro;

import com.silvalazaro.modelo.cadastro.Empresa;
import com.silvalazaro.ws.Facade;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Lazaro Silva
 */
public class WSEmpresaTest extends TestCase {

//    Facade ws = new WSEmpresa();

    public WSEmpresaTest(Facade facade) {
    }

    public WSEmpresaTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // limpar registros
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSalvarCadastroValidoDeUmaEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setCnae("100200");
        empresa.setCnpj("");
        empresa.setEmail("teste@teste.com");
        empresa.setIe("100");
        empresa.setFantasia("Teste Empresa");
        empresa.setRazao("Empresa Teste");
        
        
        //empresa = (Empresa) ws.salvar(empresa);
    }
}
