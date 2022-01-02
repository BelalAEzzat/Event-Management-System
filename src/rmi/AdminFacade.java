/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class AdminFacade extends UnicastRemoteObject implements AdminInterface {
    DB db;
    public AdminFacade() throws RemoteException {
        a = Admin.getInstance();
        db = DB.getinstance();
    }
    Admin a;

    @Override
    public String getVenueName(int index) throws RemoteException {
        return a.getVenues().get(index).getVenueName();
    }

    @Override
    public String getVenuelocation(int index) throws RemoteException {
        return a.getVenues().get(index).getVenuelocation();
    }

    @Override
    public int getVenueMAxCapacity(int index) throws RemoteException {
        return a.getVenues().get(index).getVenueMAxCapacity();
    }

    @Override
    public String ThirdPartyCopmanygetName(int index) throws RemoteException {
        return a.getThirdPartyCompanies().get(index).getName();
    }

    @Override
    public String ThirdPartyCopmanygetType(int index) throws RemoteException {
        return a.getThirdPartyCompanies().get(index).getType();
    }

    @Override
    public void AddVenue(String venueName, String venuelocation, int venueMAxCapacity) throws RemoteException {
        Venue v = new Venue(venueName, venuelocation, venueMAxCapacity);
        a.getVenues().add(v);
        db.UpdateAdmin();
    }

    @Override
    public Void UpdateAdmin() throws RemoteException {
        DB db = DB.getinstance();
        db.UpdateAdmin();
        return null;
    }

    @Override
    public int findIndexOfVenueByname(String N) throws RemoteException {
        for (int i = 0; i < a.getVenues().size(); i++) {
            String vName = a.getVenues().get(i).getVenueName();
            if (N.equals(vName)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getVenueSize() throws RemoteException {
        return a.getVenues().size();
    }

    @Override
    public int getThirdpartyCompanySize() throws RemoteException {
        return a.getThirdPartyCompanies().size();
    }

    @Override
    public ArrayList<String> getCompaniesOfVenueIndex(int i) throws RemoteException {
        ArrayList<String> lst = new ArrayList<>();
        lst.add(""); 
        Venue v = a.getVenues().get(i);
        for(ThirdPartyCompany c:v.getCompanies()){
            System.out.println(c.getName());
            lst.add(c.getName() + " | " + c.getType());
            
        }
        
        return lst;
    }

    @Override
    public void updateVenue(int i,String name,String location,int maxC) throws RemoteException {
        Venue v = a.getVenues().get(i);
        v.setVenueName(name);
        v.setVenuelocation(location);
        v.setVenueMAxCapacity(maxC);
        db.UpdateAdmin();
    }

    @Override
    public int addCompanyByVenueIndex(int i,String Name) throws RemoteException {
        Venue v = a.getVenues().get(i);
        ThirdPartyCompany com = null;
        for(ThirdPartyCompany c:a.getThirdPartyCompanies()){
            if(c.getName().equals(Name)){
                com = c;
            }
        
        }
        boolean found = false;
        for(ThirdPartyCompany c:v.getCompanies()){
            if(c.getName().equals(com.getName())){
                found = true;
            }
        
        }
        
        if(!found){
            v.addCompany(com);
            db.UpdateAdmin();
            return 1;
        }else{
            return -1;
        }
        
    }

    @Override
    public void addCompany(String Name, String type) throws RemoteException {
        ThirdPartyCompany v = new ThirdPartyCompany(Name, type);
        a.getThirdPartyCompanies().add(v);
        db.UpdateAdmin();
    }

    @Override
    public void removeVenue(int i) throws RemoteException {
        a.getVenues().remove(i);
        db.UpdateAdmin();
    }

    @Override
    public void removeCompany(int i) throws RemoteException {
        a.getThirdPartyCompanies().remove(i);
        db.UpdateAdmin();
    }

    @Override
    public String getCompanybyIndex(int i) throws RemoteException {
        return a.getThirdPartyCompanies().get(i).getName();
    }

    @Override
    public int findIndexofCompanyByName(String name) throws RemoteException {
        for (int i = 0; i < a.getThirdPartyCompanies().size(); i++) {
            String cName = a.getThirdPartyCompanies().get(i).getName();
            if (name.equals(cName)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void removeCompanyByIndexs(int i, int j) throws RemoteException {
        ThirdPartyCompany c = a.getThirdPartyCompanies().get(j);
        a.getVenues().get(i).getCompanies().remove(c);
        db.UpdateAdmin();
    }
    
    
}
