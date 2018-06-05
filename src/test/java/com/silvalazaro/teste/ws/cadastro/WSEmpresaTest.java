package com.silvalazaro.teste.ws.cadastro;

import com.silvalazaro.modelo.cadastro.Empresa;
import com.silvalazaro.ws.Facade;
import com.silvalazaro.ws.cadastro.WSEmpresa;
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
    Facade facade = new WSEmpresa();
    
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
    public void salvarCadastroValidoDeUmaEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setCnae("100200");
        empresa.setCnpj("");
        empresa.setEmail("teste@teste.com");
        empresa.setIe("100");
        empresa.setFantasia("Teste Empresa");
        empresa.setRazao("Empresa Teste");
        //facade.salvar(empresa);
    }
}
