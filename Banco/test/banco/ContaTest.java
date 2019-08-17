/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;
import static junit.framework.Assert.*;
import org.junit.Test;
import org.junit.*;

/**
 *
 * @author igord
 */
public class ContaTest {
    
    private Conta c;
    
    public ContaTest() {
        //c = new Conta("Igor");
        //c.deposita(500);
    }
    //@Test
    public void testGetTitular() {
        assertEquals("Igor", c.getTitular());
    }

    //@Test
    public void testGetNumero() {
        assertEquals(1, c.getNumero());
    }

   // @Test
    public void testGetSaldo() {
    }

    //@Test
    public void testGetLimite() {
    }

    @Test
    public void testGetSenha() {
    }

    //@Test
    public void testIsSenhaCorreta() {
        assertEquals(true,c.isSenhaCorreta("1234"));
    }

   // @Test
    public void testDeposita() {
        
    }

    @Test
    public void testSaca() {
        assertTrue(c.saca(100));
    }

    //@Test
    public void testToString() {
    }
    
}
