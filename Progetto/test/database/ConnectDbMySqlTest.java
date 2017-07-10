/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import databse.ConnectDbMySql;
import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stefania
 */
public class ConnectDbMySqlTest {
    
    public ConnectDbMySqlTest() {
    }

    /**
     * Test of ConnectDB method, of class ConnectDbMySql.
     */
    @Test
    public void testConnectDB() {
        System.out.println("ConnectDB");
        Connection expResult = null;
        Connection result = ConnectDbMySql.ConnectDB();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
