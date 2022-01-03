/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Laptop World
 */
public class DBfacadeTest {
    
    public DBfacadeTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testLoginAdmin() throws Exception {
       
    }

    @Test
    public void testLoginEmployee() throws Exception {
        Employee a=new Employee(40, "dept", "name", "name", "name");
        DB db=DB.getinstance();
        db.insertEmployee(a);
        assertEquals(a.getEmail_Address(),db.loginemEmployee("name", "name").getEmail_Address());
    }

    @Test
    public void testLoginClient() throws Exception {
    }

    @Test
    public void testRegistorEmployee() throws Exception {
    }

    @Test
    public void testRegistorClient() throws Exception {
    }
    
}
