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
public class AdminFacadeTest {
    DB db=DB.getinstance();
    
    
    public AdminFacadeTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetVenueName() throws Exception {
         

    }

    @Test
    public void testGetVenuelocation() throws Exception {
    }

    @Test
    public void testGetVenueMAxCapacity() throws Exception {
    }

    @Test
    public void testThirdPartyCopmanygetName() throws Exception {
    }

    @Test
    public void testThirdPartyCopmanygetType() throws Exception {
    }

    @Test
    public void testAddVenue() throws Exception {
        //admin DB must be empty
        //drop Admin Collection in the DB
        Admin a=Admin.getInstance();
        Venue x=new Venue("name","location",0);
        a.addVenue(x);
        a.getVenues();
        assertEquals(x.getVenueName(),a.getVenues().get(0).getVenueName());
    }

    @Test
    public void testUpdateAdmin() throws Exception {
        Admin a= Admin.getInstance();
        ThirdPartyCompany x=new ThirdPartyCompany("restrant", "restrant");
        a.addThirdPartyCompanies(x);
        assertEquals(x.getName(),a.getThirdPartyCompanies().get(0).getName());
    }

    @Test
    public void testFindIndexOfVenueByname() throws Exception {
    }

    @Test
    public void testGetVenueSize() throws Exception {
    }

    @Test
    public void testGetThirdpartyCompanySize() throws Exception {
    }

    @Test
    public void testGetCompaniesOfVenueIndex() throws Exception {
        
    }

    @Test
    public void testUpdateVenue() throws Exception {
        
    }

    @Test
    public void testAddCompanyByVenueIndex() throws Exception {
    }

    @Test
    public void testAddCompany() throws Exception {
    }

    @Test
    public void testRemoveVenue() throws Exception {
    }

    @Test
    public void testRemoveCompany() throws Exception {
    }

    @Test
    public void testGetCompanybyIndex() throws Exception {
    }

    @Test
    public void testFindIndexofCompanyByName() throws Exception {
    }

    @Test
    public void testRemoveCompanyByIndexs() throws Exception {
    }
    
}
